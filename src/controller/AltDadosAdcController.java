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
import view.AltDadosAdcView;

/**
 *
 * @author Vini
 */
public class AltDadosAdcController {
    private Medico medM = new Medico();
    private MedicoExecucao medME;
    private AltDadosAdcView altDadosAdcV = new AltDadosAdcView();
    private Paciente pacM = new Paciente();
    private ActionListener actionListener;

    public AltDadosAdcController(AltDadosAdcView altDadosAdcV, MedicoExecucao medME) {
        this.altDadosAdcV = altDadosAdcV;
        this.altDadosAdcV.setVisible(true);
        this.medME = medME;

        consultarPaciente();
        alterarDadosAdc();
    }

    private void consultarPaciente() {
        actionListener = (ActionEvent ae) -> {
            FormataDatas dtFormat = new FormataDatas();
            
            //buscando dados do paciente desejado
            pacM = medME.buscarPacienteDao(altDadosAdcV.getTxtCpfConsulta().getText());
            
            //caso não encontre registros então os campos são limpos
            if (pacM == null) {
                altDadosAdcV.getTxtNome().setText("");
                altDadosAdcV.getTxtCpf().setText("");
                altDadosAdcV.getTxtRg().setText("");
                altDadosAdcV.getTxtEndereco().setText("");
                altDadosAdcV.getTxtCelular().setText("");
                altDadosAdcV.getTxtEmail().setText("");
                altDadosAdcV.getTxtDtNasc().setText("");
                altDadosAdcV.getTxtConvenio().setText("");
                altDadosAdcV.getTxtCpfConsulta().setText("");
                altDadosAdcV.getBtnRadFumaSim().setSelected(true);
                altDadosAdcV.getBtnRadBebeSim().setSelected(true);
                altDadosAdcV.getBtnRadColesterolSim().setSelected(true);
                altDadosAdcV.getBtnRadDiabetesSim().setSelected(true);
                altDadosAdcV.getBtnRadAlergiaSim().setSelected(true);
                altDadosAdcV.getBtnRadProbCardiacoSim().setSelected(true);
                altDadosAdcV.getBtnRadCirurgiaSim().setSelected(true);
                altDadosAdcV.getTxtCpfConsulta().requestFocus();
                JOptionPane.showMessageDialog(null, "Nenhum paciente encontrado.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //carregando os txtFields
            altDadosAdcV.getTxtNome().setText(pacM.getNome().trim());
            altDadosAdcV.getTxtNome().setText(pacM.getNome().trim());
            altDadosAdcV.getTxtCpf().setText(pacM.getCpf().trim());
            altDadosAdcV.getTxtRg().setText(pacM.getRg().trim());
            altDadosAdcV.getTxtEndereco().setText(pacM.getEndereco().trim());
            altDadosAdcV.getTxtCelular().setText(pacM.getCelular().trim());
            altDadosAdcV.getTxtEmail().setText(pacM.getEmail().trim());
            
            //obtendo a data de nascimento formatada
            altDadosAdcV.getTxtDtNasc().setText(dtFormat.formataPadraoBrasil(pacM.getDtNasc(), "Data de Nascimento"));
            
            //obtendo o tipo de convenio do paciente
            if (pacM.getConvenio() == 0) {
                altDadosAdcV.getTxtConvenio().setText("Particular");
            } else {
                altDadosAdcV.getTxtConvenio().setText("Plano de Saúde");
            }
            
            //setando dados adicionais
            setandoDadosAdcEmBtnRadio();
            
            altDadosAdcV.getTxtCpfConsulta().setText("");
        };
        altDadosAdcV.getBtnConsultar().addActionListener(actionListener);
    }

    public void setandoDadosAdcEmBtnRadio() {
        //setando dados adicionais
        if (pacM.getFuma() == 2 || pacM.getFuma() == 0) {
            altDadosAdcV.getBtnRadFumaSim().setSelected(true);
        } else {
            if (pacM.getFuma() == 1) {
                altDadosAdcV.getBtnRadFumaNao().setSelected(true);
            }
        }

        if (pacM.getBebe() == 2 || pacM.getBebe() == 0) {
            altDadosAdcV.getBtnRadBebeSim().setSelected(true);
        } else {
            if (pacM.getBebe() == 1) {
                altDadosAdcV.getBtnRadBebeNao().setSelected(true);
            }
        }

        if (pacM.getColesterol() == 2 || pacM.getColesterol() == 0) {
            altDadosAdcV.getBtnRadColesterolSim().setSelected(true);
        } else {
            if (pacM.getColesterol() == 1) {
                altDadosAdcV.getBtnRadColesterolNao().setSelected(true);
            }
        }

        if (pacM.getDiabetes() == 2 || pacM.getDiabetes() == 0) {
            altDadosAdcV.getBtnRadDiabetesSim().setSelected(true);
        } else {
            if (pacM.getDiabetes() == 1) {
                altDadosAdcV.getBtnRadDiabetesNao().setSelected(true);
            }
        }

        if (pacM.getAlergias() == 2 || pacM.getAlergias() == 0) {
            altDadosAdcV.getBtnRadAlergiaSim().setSelected(true);
        } else {
            if (pacM.getAlergias() == 1) {
                altDadosAdcV.getBtnRadAlergiaNao().setSelected(true);
            }
        }

        if (pacM.getProbCardiaco() == 2 || pacM.getProbCardiaco() == 0) {
            altDadosAdcV.getBtnRadProbCardiacoSim().setSelected(true);
        } else {
            if (pacM.getProbCardiaco() == 1) {
                altDadosAdcV.getBtnRadProbCardiacoNao().setSelected(true);
            }
        }

        if (pacM.getCirurgia() == 2 || pacM.getCirurgia() == 0) {
            altDadosAdcV.getBtnRadCirurgiaSim().setSelected(true);
        } else {
            if (pacM.getCirurgia() == 1) {
                altDadosAdcV.getBtnRadCirurgiaNao().setSelected(true);
            }
        }
    }

    private void alterarDadosAdc() {
        actionListener = (ActionEvent ae) -> {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar as novas informações?", "Confirmação de cadastramento de dados adicionais", JOptionPane.YES_NO_OPTION) == 0) {
                if (altDadosAdcV.getBtnRadFumaSim().isSelected()) {
                    pacM.setFuma(2);
                } else {
                    if (altDadosAdcV.getBtnRadFumaNao().isSelected()) {
                        pacM.setFuma(1);
                    }
                }
                
                if (altDadosAdcV.getBtnRadBebeSim().isSelected()) {
                    pacM.setBebe(2);
                } else {
                    if (altDadosAdcV.getBtnRadBebeNao().isSelected()) {
                        pacM.setBebe(1);
                    }
                }
                
                if (altDadosAdcV.getBtnRadColesterolSim().isSelected()) {
                    pacM.setColesterol(2);
                } else {
                    if (altDadosAdcV.getBtnRadColesterolNao().isSelected()) {
                        pacM.setColesterol(1);
                    }
                }
                
                if (altDadosAdcV.getBtnRadDiabetesSim().isSelected()) {
                    pacM.setDiabetes(2);
                } else {
                    if (altDadosAdcV.getBtnRadDiabetesNao().isSelected()) {
                        pacM.setDiabetes(1);
                    }
                }
                
                if (altDadosAdcV.getBtnRadAlergiaSim().isSelected()) {
                    pacM.setAlergias(2);
                } else {
                    if (altDadosAdcV.getBtnRadAlergiaNao().isSelected()) {
                        pacM.setAlergias(1);
                    }
                }
                
                if (altDadosAdcV.getBtnRadProbCardiacoSim().isSelected()) {
                    pacM.setProbCardiaco(2);
                } else {
                    if (altDadosAdcV.getBtnRadProbCardiacoNao().isSelected()) {
                        pacM.setProbCardiaco(1);
                    }
                }
                
                if (altDadosAdcV.getBtnRadCirurgiaSim().isSelected()) {
                    pacM.setCirurgia(2);
                } else {
                    if (altDadosAdcV.getBtnRadCirurgiaNao().isSelected()) {
                        pacM.setCirurgia(1);
                    }
                }
                
                medME.alterarPacienteDao(pacM);
                altDadosAdcV.dispose();
                JOptionPane.showMessageDialog(null, "Dados adicionais salvos com sucesso.", "Sucesso na alteração de dados adicionais", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        altDadosAdcV.getBtnAlterar().addActionListener(actionListener);
    }
}
