/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import model.Consulta;
import model.ConsultaTable;
import model.Email;
import model.Medico;
import model.Paciente;
import model.SecretariaExecucao;
import model.Sms;
import view.ConsConsultaAmanhaView;

/**
 *
 * @author luiz.pereira
 */
public class ConsConsultaAmanhaController {
    private SecretariaExecucao secME;
    private ConsConsultaAmanhaView consAmanhaV = new ConsConsultaAmanhaView();
    private List<Consulta> listConsAmanha = new ArrayList<Consulta>();
    private ConsultaTable tableModel = new ConsultaTable();
    private ActionListener actionListener;

    ConsConsultaAmanhaController(ConsConsultaAmanhaView consAmanhaV, SecretariaExecucao secME) {
        this.consAmanhaV = consAmanhaV;
        this.secME = secME;
        consAmanhaV.setVisible(true);
        consAmanhaV.getBtnRadTodosPac().setSelected(true);

        //setando model da tabela
        consAmanhaV.getTblResultado().setModel(tableModel);
        tableModel.removeRow(0);

        //adicionando a funcionalidade de ordenação das colunas
        ConsultaTable modelo = (ConsultaTable) consAmanhaV.getTblResultado().getModel();
        consAmanhaV.getTblResultado().setRowSorter(new TableRowSorter(modelo));

        consultarConsulta();
        enviarEmail();
        enviarSms();
        exportarConsulta();
    }

    private void consultarConsulta() {
        actionListener = (ActionEvent ae) -> {
            //limpando a lista de consultas da busca anterior, pois ela será alimentada novamente
            if(listConsAmanha.size() > 0){
                listConsAmanha = new ArrayList<>();
            }
            
            //manipulando o intervalo de datas
            Calendar dtAmanhaInicio = Calendar.getInstance();
            dtAmanhaInicio.add(Calendar.DAY_OF_MONTH, 1);
            dtAmanhaInicio.set(Calendar.HOUR_OF_DAY, 0);
            dtAmanhaInicio.set(Calendar.MINUTE, 0);
            dtAmanhaInicio.set(Calendar.SECOND, 0);
            dtAmanhaInicio.set(Calendar.MILLISECOND, 0);
            
            Calendar dtAmanhaFim = Calendar.getInstance();
            dtAmanhaFim.add(Calendar.DAY_OF_MONTH, 1);
            dtAmanhaFim.set(Calendar.HOUR_OF_DAY, 23);
            dtAmanhaFim.set(Calendar.MINUTE, 59);
            dtAmanhaFim.set(Calendar.SECOND, 59);
            dtAmanhaFim.set(Calendar.MILLISECOND, 999);
            
            //instanciando objetos e realizando consulta no banco de dados
            List<Consulta> consConAmanhaM = new ArrayList<Consulta>();
            consConAmanhaM = secME.buscarConsultasAmanhaDao(dtAmanhaInicio, dtAmanhaFim);
            
            //validando se nenhuma consulta foi encontrada no banco de dados
            if (consConAmanhaM == null) {
                if (tableModel.getRowCount() > 0) {
                    tableModel.removeRow(0);
                }
                JOptionPane.showMessageDialog(null, "Nenhuma consulta encontrada para a data de amanhã.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //limpando tabela para nova consulta
            if (tableModel.getRowCount() > 0) {
                tableModel.removeRow(0);
            }
            
            //montando objeto que sera apresentado na JTable
            for (int i = 0; i < consConAmanhaM.size(); i++) {
                //obtendo dados particulares do paciente
                Paciente pacM = new Paciente();
                pacM = secME.buscarPacienteDao(consConAmanhaM.get(i).getCpfPac().trim());
                
                //obtendo dados particulares do médico
                Medico medM = new Medico();
                medM = secME.buscarMedicoDao(consConAmanhaM.get(i).getCpfMed().trim());
                
                //setando tipo da consulta
                String tpConsulta = null;
                if (consConAmanhaM.get(i).getTipoConsulta() == 0) {
                    tpConsulta = "Normal";
                } else {
                    if (consConAmanhaM.get(i).getTipoConsulta() == 1) {
                        tpConsulta = "Retorno";
                    }
                }
                
                //validando se é todos os pacientes ou apenas os que possuem email/celular cadastrado
                if (consAmanhaV.getBtnRadTodosPac().isSelected()) {
                    //contruindo objeto com todos os dados necessáriosde todos os pacientes
                    Consulta cons_temp = new Consulta(
                            consConAmanhaM.get(i).getId(),
                            consConAmanhaM.get(i).getDtConsulta(),
                            pacM.getNome().trim(),
                            pacM.getDtNasc(),
                            pacM.getEndereco().trim(),
                            medM.getNome().trim(),
                            medM.getDtNasc(),
                            medM.getCrm().trim(),
                            tpConsulta,
                            pacM.getEmail().trim(),
                            pacM.getCelular().trim()
                    );
                    tableModel.addRow(cons_temp);
                    listConsAmanha.add(cons_temp);
                } else {
                    if (
                            consAmanhaV.getBtnRadPacEmailCelular().isSelected() &&
                            !pacM.getEmail().trim().equals("") &&
                            !pacM.getCelular().trim().equals("")
                            ) {
                        //contruindo objeto com todos os dados necessários apenas pacientes com email/celular
                        Consulta cons_temp = new Consulta(
                                consConAmanhaM.get(i).getId(),
                                consConAmanhaM.get(i).getDtConsulta(),
                                pacM.getNome().trim(),
                                pacM.getDtNasc(),
                                pacM.getEndereco().trim(),
                                medM.getNome().trim(),
                                medM.getDtNasc(),
                                medM.getCrm().trim(),
                                tpConsulta,
                                pacM.getEmail().trim(),
                                pacM.getCelular().trim()
                        );
                        tableModel.addRow(cons_temp);
                        listConsAmanha.add(cons_temp);
                    }
                }
            }
        };
        consAmanhaV.getBtnConsultar().addActionListener(actionListener);
    }

    private void exportarConsulta() {
        actionListener = (ActionEvent ae) -> {
            Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
            consAmanhaV.setCursor(cursor);
            
            secME.getExcC().exportarExcel(consAmanhaV.getTblResultado());
            
            cursor = Cursor.getDefaultCursor();
            consAmanhaV.setCursor(cursor);
        };
        consAmanhaV.getBtnExportar().addActionListener(actionListener);
    }

    private void enviarEmail() {
        actionListener = (ActionEvent ae) -> {
            int count = 0;
            for(int i = 0; i < listConsAmanha.size(); i++){
                if (!listConsAmanha.get(i).getEmailPac().trim().equals("")) {
                    count++;
                    //enviando e-mail real
                    Email email = new Email();
                    email.setAssunto("Lembrete de Consulta - Saúde&Cia");
                    email.setMsg("Olá, você possui consulta amanhã.");
                    email.setEmailDestinatario(listConsAmanha.get(i).getEmailPac().trim());
                    email.enviarMensagem(listConsAmanha.get(i).getEmailPac().concat(" - ").concat(listConsAmanha.get(i).getNomePac()));  
                }
            }
            
            if(count == 0){
                JOptionPane.showMessageDialog(null, "Não há pacientes para enviar e-mail", "Falha no envio de SMS", JOptionPane.ERROR_MESSAGE);
            }
        };
        consAmanhaV.getBtnEmail().addActionListener(actionListener);
    }

    private void enviarSms() {
        actionListener = (ActionEvent ae) -> {
            int count = 0;
            for(int i = 0; i < listConsAmanha.size(); i++){
                if (!listConsAmanha.get(i).getCelularPac().trim().equals("")) {
                    count++;
                    Sms sms = new Sms();
                    sms.enviarMensagem(listConsAmanha.get(i).getCelularPac().concat(" - ").concat(listConsAmanha.get(i).getNomePac()));  
                }
            }
            
            if(count == 0){
                JOptionPane.showMessageDialog(null, "Não há pacientes para enviar SMS", "Falha no envio de SMS", JOptionPane.ERROR_MESSAGE);
            }
        };
        consAmanhaV.getBtnSms().addActionListener(actionListener);
    }
}
