/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Medico;
import model.MedicoExecucao;
import model.Paciente;
import service.FormataDatas;
import view.DelDadosAdcView;

/**
 *
 * @author Vini
 */
public class DelDadosAdcController {
    private Medico medM = new Medico();
    private MedicoExecucao medME;
    private DelDadosAdcView delDadosAdcV = new DelDadosAdcView();
    private Paciente pacM = new Paciente();
    private ActionListener actionListener;

    public DelDadosAdcController(DelDadosAdcView delDadosAdcV, MedicoExecucao medME) {
        this.delDadosAdcV = delDadosAdcV;
        this.delDadosAdcV.setVisible(true);
        this.medME = medME;

        consultarPaciente();
        deletarDadosAdc();
    }

    private void consultarPaciente() {
        actionListener = (ActionEvent ae) -> {
            FormataDatas dtFormat = new FormataDatas();
            
            //buscando dados do paciente desejado
            pacM = medME.buscarPacienteDao(delDadosAdcV.getTxtCpfConsulta().getText());
            
            //caso não encontre registros então os campos são limpos
            if (pacM == null) {
                delDadosAdcV.getTxtNome().setText("");
                delDadosAdcV.getTxtCpf().setText("");
                delDadosAdcV.getTxtRg().setText("");
                delDadosAdcV.getTxtEndereco().setText("");
                delDadosAdcV.getTxtCelular().setText("");
                delDadosAdcV.getTxtEmail().setText("");
                delDadosAdcV.getTxtDtNasc().setText("");
                delDadosAdcV.getTxtConvenio().setText("");
                delDadosAdcV.getTxtCpfConsulta().setText("");
                delDadosAdcV.getBtnRadFumaNao().setSelected(false);
                delDadosAdcV.getBtnRadFumaSim().setSelected(false);
                delDadosAdcV.getBtnRadBebeNao().setSelected(false);
                delDadosAdcV.getBtnRadBebeSim().setSelected(false);
                delDadosAdcV.getBtnRadColesterolNao().setSelected(false);
                delDadosAdcV.getBtnRadColesterolSim().setSelected(false);
                delDadosAdcV.getBtnRadDiabetesNao().setSelected(false);
                delDadosAdcV.getBtnRadDiabetesSim().setSelected(false);
                delDadosAdcV.getBtnRadAlergiaNao().setSelected(false);
                delDadosAdcV.getBtnRadAlergiaSim().setSelected(false);
                delDadosAdcV.getBtnRadProbCardiacoNao().setSelected(false);
                delDadosAdcV.getBtnRadProbCardiacoSim().setSelected(false);
                delDadosAdcV.getBtnRadCirurgiaNao().setSelected(false);
                delDadosAdcV.getBtnRadCirurgiaSim().setSelected(false);
                delDadosAdcV.getTxtCpfConsulta().requestFocus();
                JOptionPane.showMessageDialog(null, "Nenhum paciente encontrado.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //carregando os txtFields
            delDadosAdcV.getTxtNome().setText(pacM.getNome().trim());
            delDadosAdcV.getTxtNome().setText(pacM.getNome().trim());
            delDadosAdcV.getTxtCpf().setText(pacM.getCpf().trim());
            delDadosAdcV.getTxtRg().setText(pacM.getRg().trim());
            delDadosAdcV.getTxtEndereco().setText(pacM.getEndereco().trim());
            delDadosAdcV.getTxtCelular().setText(pacM.getCelular().trim());
            delDadosAdcV.getTxtEmail().setText(pacM.getEmail().trim());
            
            //obtendo a data de nascimento formatada
            delDadosAdcV.getTxtDtNasc().setText(dtFormat.formataPadraoBrasil(pacM.getDtNasc(), "Data de Nascimento"));
            
            //obtendo o tipo de convenio do paciente
            if (pacM.getConvenio() == 0) {
                delDadosAdcV.getTxtConvenio().setText("Particular");
            } else {
                delDadosAdcV.getTxtConvenio().setText("Plano de Saúde");
            }
            
            //setando dados adicionais
            setandoDadosAdc();
            
            delDadosAdcV.getTxtCpfConsulta().setText("");
        };
        delDadosAdcV.getBtnConsultar().addActionListener(actionListener);
    }

    public void setandoDadosAdc() {
        //setando dados adicionais
        if (pacM.getFuma() == 2) {
            delDadosAdcV.getBtnRadFumaSim().setSelected(true);
        } else {
            if (pacM.getFuma() == 1) {
                delDadosAdcV.getBtnRadFumaNao().setSelected(true);
            } else {
                delDadosAdcV.getBtnRadFumaNao().setSelected(false);
                delDadosAdcV.getBtnRadFumaSim().setSelected(false);
            }
        }

        if (pacM.getBebe() == 2) {
            delDadosAdcV.getBtnRadBebeSim().setSelected(true);
        } else {
            if (pacM.getBebe() == 1) {
                delDadosAdcV.getBtnRadBebeNao().setSelected(true);
            } else {
                delDadosAdcV.getBtnRadBebeNao().setSelected(false);
                delDadosAdcV.getBtnRadBebeSim().setSelected(false);
            }
        }

        if (pacM.getColesterol() == 2) {
            delDadosAdcV.getBtnRadColesterolSim().setSelected(true);
        } else {
            if (pacM.getColesterol() == 1) {
                delDadosAdcV.getBtnRadColesterolNao().setSelected(true);
            } else {
                delDadosAdcV.getBtnRadColesterolNao().setSelected(false);
                delDadosAdcV.getBtnRadColesterolSim().setSelected(false);
            }
        }

        if (pacM.getDiabetes() == 2) {
            delDadosAdcV.getBtnRadDiabetesSim().setSelected(true);
        } else {
            if (pacM.getDiabetes() == 1) {
                delDadosAdcV.getBtnRadDiabetesNao().setSelected(true);
            } else {
                delDadosAdcV.getBtnRadDiabetesNao().setSelected(false);
                delDadosAdcV.getBtnRadDiabetesSim().setSelected(false);
            }
        }

        if (pacM.getAlergias() == 2) {
            delDadosAdcV.getBtnRadAlergiaSim().setSelected(true);
        } else {
            if (pacM.getAlergias() == 1) {
                delDadosAdcV.getBtnRadAlergiaNao().setSelected(true);
            } else {
                delDadosAdcV.getBtnRadAlergiaNao().setSelected(false);
                delDadosAdcV.getBtnRadAlergiaSim().setSelected(false);
            }
        }

        if (pacM.getProbCardiaco() == 2) {
            delDadosAdcV.getBtnRadProbCardiacoSim().setSelected(true);
        } else {
            if (pacM.getProbCardiaco() == 1) {
                delDadosAdcV.getBtnRadProbCardiacoNao().setSelected(true);
            } else {
                delDadosAdcV.getBtnRadProbCardiacoNao().setSelected(false);
                delDadosAdcV.getBtnRadProbCardiacoSim().setSelected(false);
            }
        }

        if (pacM.getCirurgia() == 2) {
            delDadosAdcV.getBtnRadCirurgiaSim().setSelected(true);
        } else {
            if (pacM.getCirurgia() == 1) {
                delDadosAdcV.getBtnRadCirurgiaNao().setSelected(true);
            } else {
                delDadosAdcV.getBtnRadCirurgiaNao().setSelected(false);
                delDadosAdcV.getBtnRadCirurgiaSim().setSelected(false);
            }
        }
    }

    private void deletarDadosAdc() {
        actionListener = (ActionEvent ae) -> {
            if (pacM.getId() == null) {
                JOptionPane.showMessageDialog(null, "Nenhum paciente foi consultado/selecionado.", "Falha na deleção", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar os dados adicionais do paciente?", "Confirmação de deleção", JOptionPane.YES_NO_OPTION) == 0) {
                //resetando dados adicionais
                pacM.setFuma(0);
                pacM.setBebe(0);
                pacM.setColesterol(0);
                pacM.setDiabetes(0);
                pacM.setProbCardiaco(0);
                pacM.setAlergias(0);
                pacM.setCirurgia(0);
                
                //efetuando as alterações
                medME.alterarPacienteDao(pacM);
                delDadosAdcV.dispose();
                JOptionPane.showMessageDialog(null, "Dados adicionais deletados com sucesso!", "Sucesso na deleção", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        delDadosAdcV.getBtnDeletar().addActionListener(actionListener);
    }
}
