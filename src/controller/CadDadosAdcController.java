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
import view.CadDadosAdcView;

/**
 *
 * @author Vini
 */
public class CadDadosAdcController {
    private Medico medM = new Medico();
    private MedicoExecucao medME;
    private CadDadosAdcView cadDadosAdcV = new CadDadosAdcView();
    private Paciente pacM = new Paciente();
    private ActionListener actionListener;

    public CadDadosAdcController(CadDadosAdcView cadDadosAdcV, MedicoExecucao medME) {
        this.cadDadosAdcV = cadDadosAdcV;
        this.cadDadosAdcV.setVisible(true);
        this.medME = medME;

        cadDadosAdcV.getBtnRadFumaSim().setSelected(true);
        cadDadosAdcV.getBtnRadBebeSim().setSelected(true);
        cadDadosAdcV.getBtnRadColesterolSim().setSelected(true);
        cadDadosAdcV.getBtnRadDiabetesSim().setSelected(true);
        cadDadosAdcV.getBtnRadAlergiaSim().setSelected(true);
        cadDadosAdcV.getBtnRadProbCardiacoSim().setSelected(true);
        cadDadosAdcV.getBtnRadCirurgiaSim().setSelected(true);

        cadastrarDadosAdc();
        consultarPaciente();
    }

    private void cadastrarDadosAdc() {
        actionListener = (ActionEvent ae) -> {
            setandoDadosAdc();
        };
        cadDadosAdcV.getBtnCadastrar().addActionListener(actionListener);
    }

    private void consultarPaciente() {
        actionListener = (ActionEvent ae) -> {
            FormataDatas dtFormat = new FormataDatas();
            
            //buscando dados do paciente desejado
            pacM = medME.buscarPacienteDao(cadDadosAdcV.getTxtCpfConsulta().getText());
            
            //caso não encontre registros então os campos são limpos
            if (pacM == null) {
                cadDadosAdcV.getTxtNome().setText("");
                cadDadosAdcV.getTxtCpf().setText("");
                cadDadosAdcV.getTxtRg().setText("");
                cadDadosAdcV.getTxtEndereco().setText("");
                cadDadosAdcV.getTxtCelular().setText("");
                cadDadosAdcV.getTxtEmail().setText("");
                cadDadosAdcV.getTxtDtNasc().setText("");
                cadDadosAdcV.getTxtConvenio().setText("");
                cadDadosAdcV.getTxtCpfConsulta().setText("");
                cadDadosAdcV.getTxtCpfConsulta().requestFocus();
                JOptionPane.showMessageDialog(null, "Nenhum paciente encontrado.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //carregando os txtFields
            cadDadosAdcV.getTxtNome().setText(pacM.getNome().trim());
            cadDadosAdcV.getTxtNome().setText(pacM.getNome().trim());
            cadDadosAdcV.getTxtCpf().setText(pacM.getCpf().trim());
            cadDadosAdcV.getTxtRg().setText(pacM.getRg().trim());
            cadDadosAdcV.getTxtEndereco().setText(pacM.getEndereco().trim());
            cadDadosAdcV.getTxtCelular().setText(pacM.getCelular().trim());
            cadDadosAdcV.getTxtEmail().setText(pacM.getEmail().trim());
            
            //obtendo a data de nascimento formatada
            cadDadosAdcV.getTxtDtNasc().setText(dtFormat.formataPadraoBrasil(pacM.getDtNasc(), "Data de Nascimento"));
            
            //obtendo o tipo de convenio do paciente
            if (pacM.getConvenio() == 0) {
                cadDadosAdcV.getTxtConvenio().setText("Particular");
            } else {
                cadDadosAdcV.getTxtConvenio().setText("Plano de Saúde");
            }
            cadDadosAdcV.getTxtCpfConsulta().setText("");
        };
        cadDadosAdcV.getBtnConsultar().addActionListener(actionListener);
    }

    public void setandoDadosAdc() {
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar as novas informações?", "Confirmação de cadastramento de dados adicionais", JOptionPane.YES_NO_OPTION) == 0) {
            if (cadDadosAdcV.getBtnRadFumaSim().isSelected()) {
                pacM.setFuma(2);
            } else {
                if (cadDadosAdcV.getBtnRadFumaNao().isSelected()) {
                    pacM.setFuma(1);
                }
            }

            if (cadDadosAdcV.getBtnRadBebeSim().isSelected()) {
                pacM.setBebe(2);
            } else {
                if (cadDadosAdcV.getBtnRadBebeNao().isSelected()) {
                    pacM.setBebe(1);
                }
            }

            if (cadDadosAdcV.getBtnRadColesterolSim().isSelected()) {
                pacM.setColesterol(2);
            } else {
                if (cadDadosAdcV.getBtnRadColesterolNao().isSelected()) {
                    pacM.setColesterol(1);
                }
            }

            if (cadDadosAdcV.getBtnRadDiabetesSim().isSelected()) {
                pacM.setDiabetes(2);
            } else {
                if (cadDadosAdcV.getBtnRadDiabetesNao().isSelected()) {
                    pacM.setDiabetes(1);
                }
            }

            if (cadDadosAdcV.getBtnRadAlergiaSim().isSelected()) {
                pacM.setAlergias(2);
            } else {
                if (cadDadosAdcV.getBtnRadAlergiaNao().isSelected()) {
                    pacM.setAlergias(1);
                }
            }

            if (cadDadosAdcV.getBtnRadProbCardiacoSim().isSelected()) {
                pacM.setProbCardiaco(2);
            } else {
                if (cadDadosAdcV.getBtnRadProbCardiacoNao().isSelected()) {
                    pacM.setProbCardiaco(1);
                }
            }

            if (cadDadosAdcV.getBtnRadCirurgiaSim().isSelected()) {
                pacM.setCirurgia(2);
            } else {
                if (cadDadosAdcV.getBtnRadCirurgiaNao().isSelected()) {
                    pacM.setCirurgia(1);
                }
            }
            
            medME.alterarPacienteDao(pacM);
            cadDadosAdcV.dispose();
            JOptionPane.showMessageDialog(null, "Dados adicionais salvos com sucesso.", "Sucesso no cadastro de dados adicionais", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
