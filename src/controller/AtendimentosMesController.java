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
import model.Medico;
import model.MedicoExecucao;
import model.Paciente;
import view.AtendimentosMesView;

/**
 *
 * @author Vini
 */
public class AtendimentosMesController {
    private Medico medM = new Medico();
    private MedicoExecucao medME;
    private AtendimentosMesView atendMesV = new AtendimentosMesView();
    private ConsultaTable tableModel = new ConsultaTable();
    private ActionListener actionListener;

    AtendimentosMesController(AtendimentosMesView atendMesV, MedicoExecucao medME) {
        this.atendMesV = atendMesV;
        this.medME = medME;
        atendMesV.setVisible(true);
        
        //setando model da tabela
        atendMesV.getTblTabela().setModel(tableModel);
        tableModel.removeRow(0);
              
        //adicionando a funcionalidade de ordenação das colunas
        ConsultaTable modelo = (ConsultaTable) atendMesV.getTblTabela().getModel();
        atendMesV.getTblTabela().setRowSorter(new TableRowSorter(modelo));
                
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
            //validando CPF fornecido
            if(atendMesV.getTxtCpfMed().getText().trim().equals("".trim())){
                atendMesV.getTxtCpfMed().setText("0");
            }
            //obtendo periodo das consultas
            Calendar dtInicio = Calendar.getInstance();
            dtInicio.set(Calendar.DAY_OF_MONTH, 1);
            dtInicio.set(Calendar.HOUR_OF_DAY, 0);
            dtInicio.set(Calendar.MINUTE, 00);
            dtInicio.set(Calendar.SECOND, 00);
            dtInicio.set(Calendar.MILLISECOND, 000);
            Calendar dtFim = Calendar.getInstance();
            dtFim.set(Calendar.DAY_OF_MONTH, dtFim.getActualMaximum(Calendar.DAY_OF_MONTH));
            dtFim.set(Calendar.HOUR_OF_DAY, 23);
            dtFim.set(Calendar.MINUTE, 59);
            dtFim.set(Calendar.SECOND, 59);
            dtFim.set(Calendar.MILLISECOND, 999);
            //trazendo dados da consulta
            try {
                consConM = medME.buscarAtendimentosMesDao(dtInicio, dtFim, atendMesV.getTxtCpfMed().getText().trim());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //validando se nenhuma consulta foi encontrada no banco de dados
            if (consConM == null) {
                if(tableModel.getRowCount() > 0){
                    tableModel.removeRow(0);
                }
                atendMesV.getTxtCpfMed().setText("".trim());
                atendMesV.getTxtCpfMed().requestFocus();
                JOptionPane.showMessageDialog(null, "Nenhuma consulta encontrada para o CPF informado no mês atual.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Paciente pacM = new Paciente();
            
            medM = medME.buscarMedicoDao(atendMesV.getTxtCpfMed().getText());
            //montando objeto que sera apresentado na JTable
            for (int i = 0; i < consConM.size(); i++) {
                //obtendo dados particulares do paciente
                try {
                    pacM = medME.buscarPacienteDao(consConM.get(i).getCpfPac().trim());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
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
                Consulta cons_temp = new Consulta(consConM.get(i).getId(), consConM.get(i).getDtConsulta(), pacM.getNome().trim(), pacM.getDtNasc(), pacM.getEndereco().trim(), medM.getNome().trim(), medM.getDtNasc(), medM.getCrm().trim(), tpConsulta);
                tableModel.addRow(cons_temp);  
            }
        };
        atendMesV.getBtnConsultar().addActionListener(actionListener);
    }

    private void exportarConsulta() {
        actionListener = (ActionEvent ae) -> {
            Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
            atendMesV.setCursor(cursor);
            
            medME.getExcC().exportarExcel(atendMesV.getTblTabela());
            
            cursor = Cursor.getDefaultCursor();
            atendMesV.setCursor(cursor);
        };
        atendMesV.getBtnExportar().addActionListener(actionListener);
    }
}
