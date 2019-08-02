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
import view.ConsDadosAdcView;

/**
 *
 * @author Vini
 */
public class ConsDadosAdcController {
    private Medico medM = new Medico();
    private MedicoExecucao medEM;
    private ConsDadosAdcView consDadosAdcV = new ConsDadosAdcView();
    private Paciente pacM = new Paciente();
    private ActionListener actionListener;

    public ConsDadosAdcController(ConsDadosAdcView consDadosAdcV, MedicoExecucao medEM) {
        this.consDadosAdcV = consDadosAdcV;
        this.consDadosAdcV.setVisible(true);
        this.medEM = medEM;

        consultarPaciente();
    }

    private void consultarPaciente() {
        actionListener = (ActionEvent ae) -> {
            FormataDatas dtFormat = new FormataDatas();
            
            //buscando dados do paciente desejado
            pacM = medEM.buscarPacienteDao(consDadosAdcV.getTxtCpfConsulta().getText());
            
            //caso não encontre registros então os campos são limpos
            if (pacM == null) {
                consDadosAdcV.getTxtNome().setText("");
                consDadosAdcV.getTxtCpf().setText("");
                consDadosAdcV.getTxtRg().setText("");
                consDadosAdcV.getTxtEndereco().setText("");
                consDadosAdcV.getTxtCelular().setText("");
                consDadosAdcV.getTxtEmail().setText("");
                consDadosAdcV.getTxtDtNasc().setText("");
                consDadosAdcV.getTxtConvenio().setText("");
                consDadosAdcV.getTxtCpfConsulta().setText("");
                consDadosAdcV.getBtnRadFumaNao().setSelected(false);
                consDadosAdcV.getBtnRadFumaSim().setSelected(false);
                consDadosAdcV.getBtnRadBebeNao().setSelected(false);
                consDadosAdcV.getBtnRadBebeSim().setSelected(false);
                consDadosAdcV.getBtnRadColesterolNao().setSelected(false);
                consDadosAdcV.getBtnRadColesterolSim().setSelected(false);
                consDadosAdcV.getBtnRadDiabetesNao().setSelected(false);
                consDadosAdcV.getBtnRadDiabetesSim().setSelected(false);
                consDadosAdcV.getBtnRadAlergiaNao().setSelected(false);
                consDadosAdcV.getBtnRadAlergiaSim().setSelected(false);
                consDadosAdcV.getBtnRadProbCardiacoNao().setSelected(false);
                consDadosAdcV.getBtnRadProbCardiacoSim().setSelected(false);
                consDadosAdcV.getBtnRadCirurgiaNao().setSelected(false);
                consDadosAdcV.getBtnRadCirurgiaSim().setSelected(false);
                consDadosAdcV.getTxtCpfConsulta().requestFocus();
                JOptionPane.showMessageDialog(null, "Nenhum paciente encontrado.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //carregando os txtFields
            consDadosAdcV.getTxtNome().setText(pacM.getNome().trim());
            consDadosAdcV.getTxtNome().setText(pacM.getNome().trim());
            consDadosAdcV.getTxtCpf().setText(pacM.getCpf().trim());
            consDadosAdcV.getTxtRg().setText(pacM.getRg().trim());
            consDadosAdcV.getTxtEndereco().setText(pacM.getEndereco().trim());
            consDadosAdcV.getTxtCelular().setText(pacM.getCelular().trim());
            consDadosAdcV.getTxtEmail().setText(pacM.getEmail().trim());
            
            //obtendo a data de nascimento formatada
            consDadosAdcV.getTxtDtNasc().setText(dtFormat.formataPadraoBrasil(pacM.getDtNasc(), "Data de Nascimento"));
            
            //obtendo o tipo de convenio do paciente
            if (pacM.getConvenio() == 0) {
                consDadosAdcV.getTxtConvenio().setText("Particular");
            } else {
                consDadosAdcV.getTxtConvenio().setText("Plano de Saúde");
            }
            
            //setando dados adicionais
            setandoDadosAdc();
            
            consDadosAdcV.getTxtCpfConsulta().setText("");
        };
        consDadosAdcV.getBtnConsultar().addActionListener(actionListener);
    }

    public void setandoDadosAdc() {
        //setando dados adicionais
        if (pacM.getFuma() == 2) {
            consDadosAdcV.getBtnRadFumaSim().setSelected(true);
        } else {
            if (pacM.getFuma() == 1) {
                consDadosAdcV.getBtnRadFumaNao().setSelected(true);
            } else {
                consDadosAdcV.getBtnRadFumaNao().setSelected(false);
                consDadosAdcV.getBtnRadFumaSim().setSelected(false);
            }
        }

        if (pacM.getBebe() == 2) {
            consDadosAdcV.getBtnRadBebeSim().setSelected(true);
        } else {
            if (pacM.getBebe() == 1) {
                consDadosAdcV.getBtnRadBebeNao().setSelected(true);
            } else {
                consDadosAdcV.getBtnRadBebeNao().setSelected(false);
                consDadosAdcV.getBtnRadBebeSim().setSelected(false);
            }
        }

        if (pacM.getColesterol() == 2) {
            consDadosAdcV.getBtnRadColesterolSim().setSelected(true);
        } else {
            if (pacM.getColesterol() == 1) {
                consDadosAdcV.getBtnRadColesterolNao().setSelected(true);
            } else {
                consDadosAdcV.getBtnRadColesterolNao().setSelected(false);
                consDadosAdcV.getBtnRadColesterolSim().setSelected(false);
            }
        }

        if (pacM.getDiabetes() == 2) {
            consDadosAdcV.getBtnRadDiabetesSim().setSelected(true);
        } else {
            if (pacM.getDiabetes() == 1) {
                consDadosAdcV.getBtnRadDiabetesNao().setSelected(true);
            } else {
                consDadosAdcV.getBtnRadDiabetesNao().setSelected(false);
                consDadosAdcV.getBtnRadDiabetesSim().setSelected(false);
            }
        }

        if (pacM.getAlergias() == 2) {
            consDadosAdcV.getBtnRadAlergiaSim().setSelected(true);
        } else {
            if (pacM.getAlergias() == 1) {
                consDadosAdcV.getBtnRadAlergiaNao().setSelected(true);
            } else {
                consDadosAdcV.getBtnRadAlergiaNao().setSelected(false);
                consDadosAdcV.getBtnRadAlergiaSim().setSelected(false);
            }
        }

        if (pacM.getProbCardiaco() == 2) {
            consDadosAdcV.getBtnRadProbCardiacoSim().setSelected(true);
        } else {
            if (pacM.getProbCardiaco() == 1) {
                consDadosAdcV.getBtnRadProbCardiacoNao().setSelected(true);
            } else {
                consDadosAdcV.getBtnRadProbCardiacoNao().setSelected(false);
                consDadosAdcV.getBtnRadProbCardiacoSim().setSelected(false);
            }
        }

        if (pacM.getCirurgia() == 2) {
            consDadosAdcV.getBtnRadCirurgiaSim().setSelected(true);
        } else {
            if (pacM.getCirurgia() == 1) {
                consDadosAdcV.getBtnRadCirurgiaNao().setSelected(true);
            } else {
                consDadosAdcV.getBtnRadCirurgiaNao().setSelected(false);
                consDadosAdcV.getBtnRadCirurgiaSim().setSelected(false);
            }
        }
    }
}
