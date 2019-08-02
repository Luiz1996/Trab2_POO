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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import model.Consulta;
import model.ConsultaTable;
import model.Medico;
import model.Paciente;
import model.SecretariaExecucao;
import view.ConsConsultaView;

/**
 *
 * @author luiz.pereira
 */
public class ConsConsultaController {
    private SecretariaExecucao secME;
    private ActionListener actionListener;
    private ConsConsultaView consConV = new ConsConsultaView();
    private ConsultaTable tableModel = new ConsultaTable();

    ConsConsultaController(ConsConsultaView consConV, SecretariaExecucao secME) {
        this.consConV = consConV;
        this.secME = secME;
        consConV.setVisible(true);
        
        //setando model da tabela
        consConV.getTblTabela().setModel(tableModel);
        tableModel.removeRow(0);
              
        //adicionando a funcionalidade de ordenação das colunas
        ConsultaTable modelo = (ConsultaTable) consConV.getTblTabela().getModel();
        consConV.getTblTabela().setRowSorter(new TableRowSorter(modelo));
                
        consultarConsulta();
        exportarConsulta();
    }

    private void consultarConsulta() {
        actionListener = (ActionEvent ae) -> {
            List<Consulta> consConM = new ArrayList<>();
            
            //limpando tabela para nova consulta
            if(tableModel.getRowCount() > 0){
                tableModel.removeRow(0);
            }
            
            //validando CPF's fornecidos
            if(consConV.getTxtCpfPac().getText().trim().equals("".trim())){
                consConV.getTxtCpfPac().setText("0");
            }else{
                if(consConV.getTxtCpfMed().getText().trim().equals("".trim())){
                    consConV.getTxtCpfMed().setText("0");
                }
            }
            
            //trazendo dados da consulta
            consConM = secME.buscarConsultasDao(consConV.getTxtCpfPac().getText(), consConV.getTxtCpfMed().getText());
            
            //validando se nenhuma consulta foi encontrada no banco de dados
            if (consConM == null) {
                if(tableModel.getRowCount() > 0){
                    tableModel.removeRow(0);
                }
                consConV.getTxtCpfPac().setText("".trim());
                consConV.getTxtCpfMed().setText("".trim());
                consConV.getTxtCpfPac().requestFocus();
                JOptionPane.showMessageDialog(null, "Nenhuma consulta encontrada para os CPF's informados.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //obtendo dados particulares do paciente
            Paciente pacM = new Paciente();
            pacM = secME.buscarPacienteDao(consConV.getTxtCpfPac().getText());
            
            //obtendo dados particulares do médico
            Medico medM = new Medico();
            medM = secME.buscarMedicoDao(consConV.getTxtCpfMed().getText());
            
            //montando objeto que sera apresentado na JTable
            for (int i = 0; i < consConM.size(); i++) {
                //setando tipo da consulta
                String tpConsulta = null;
                if (consConM.get(i).getTipoConsulta() == 0) {
                    tpConsulta = "Normal";
                } else {
                    if (consConM.get(i).getTipoConsulta() == 1) {
                        tpConsulta = "Retorno";
                    }
                }
                
                //contruindo objeto com todos os dados necessários
                Consulta cons_temp = new Consulta(
                        consConM.get(i).getId(),
                        consConM.get(i).getDtConsulta(),
                        pacM.getNome().trim(),
                        pacM.getDtNasc(),
                        pacM.getEndereco().trim(),
                        medM.getNome().trim(),
                        medM.getDtNasc(),
                        medM.getCrm().trim(),
                        tpConsulta
                );
                
                tableModel.addRow(cons_temp);  
            }
        };
        consConV.getBtnConsultar().addActionListener(actionListener);
    }

    private void exportarConsulta() {
        actionListener = (ActionEvent ae) -> {
            Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
            consConV.setCursor(cursor);
            
            //exportando arquivo
            secME.getExcC().exportarExcel(consConV.getTblTabela());
            
            cursor = Cursor.getDefaultCursor();
            consConV.setCursor(cursor);
        };
        consConV.getBtnExportar().addActionListener(actionListener);
    }
}
