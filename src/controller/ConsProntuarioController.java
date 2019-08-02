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
import model.Prontuario;
import service.FormataDatas;
import view.ConsProntuarioView;

/**
 *
 * @author Vini
 */
public class ConsProntuarioController {
    private Medico medM = new Medico();
    private MedicoExecucao medME;
    private FormataDatas dtFormat = new FormataDatas();
    private ConsProntuarioView consProntV = new ConsProntuarioView();
    private Prontuario prontM = new Prontuario();
    private Paciente pacM = new Paciente();
    private ActionListener actionListener;

    public ConsProntuarioController(ConsProntuarioView consProntV, MedicoExecucao medME) {
        this.consProntV = consProntV;
        this.consProntV.setVisible(true);
        this.medME = medME;

        consultarProntuario();
    }

    private void consultarProntuario() {
        actionListener = (ActionEvent ae) -> {
            //validando existencia de prontuário para o CPF informado
            prontM = medME.buscarProntuarioDao(consProntV.getTxtCpfPac().getText());
            
            if(prontM == null){
                JOptionPane.showMessageDialog(null, "Não encontramos prontuários para o CPF informado.", "Falha na consulta de prontuário", JOptionPane.ERROR_MESSAGE);
                limpaCampos();
                return;
            }
            
            //validando se o paciente do prontuário ainda existe, caso contrário o prontuário não sera apresentando
            //senão, apareceria apenas os dados do prontuário sem vinculo com paciente algum
            pacM = medME.buscarPacienteDao(consProntV.getTxtCpfPac().getText());
            
            if(pacM == null){
                JOptionPane.showMessageDialog(null, "Não encontramos paciente com o CPF informado.", "Falha na consulta de paciente", JOptionPane.ERROR_MESSAGE);
                limpaCampos();
                return;
            }
            
            //setando dados obtidos
            consProntV.getTxtNome().setText(pacM.getNome().trim());
            consProntV.getTxtEndereco().setText(pacM.getEndereco().trim());
            consProntV.getTxtDtNasc().setText(dtFormat.formataPadraoBrasil(pacM.getDtNasc(), "Data de Nascimento"));
            consProntV.getTxtEmail().setText(pacM.getEmail().trim());
            consProntV.getTxtMsgProntuario().setText(prontM.getTxtPront().trim());
            if (pacM.getConvenio() == 0) {
                consProntV.getTxtConvenio().setText("Particular");
            } else {
                consProntV.getTxtConvenio().setText("Plano de Saúde");
            }
            consProntV.getTxtCpfPac().setText("");
            consProntV.getTxtCpfPac().requestFocus();
        };
        consProntV.getBtnConsultar().addActionListener(actionListener);
    }
    
    public void limpaCampos() {
        consProntV.getTxtNome().setText("");
        consProntV.getTxtEndereco().setText("");
        consProntV.getTxtDtNasc().setText("");
        consProntV.getTxtEmail().setText("");
        consProntV.getTxtConvenio().setText("");
        consProntV.getTxtCpfPac().setText("");
        consProntV.getTxtMsgProntuario().setText(""); 
        consProntV.getTxtCpfPac().requestFocus();
    }
}
