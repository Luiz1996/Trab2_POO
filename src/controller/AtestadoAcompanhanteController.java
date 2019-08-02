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
import view.AtestadoAcompanhanteView;

/**
 *
 * @author Vini
 */
public class AtestadoAcompanhanteController {
    private Medico medM = new Medico();
    private MedicoExecucao medME;
    private AtestadoAcompanhanteView atestAcompV = new AtestadoAcompanhanteView();
    private ActionListener actionListener;

    AtestadoAcompanhanteController(AtestadoAcompanhanteView atestAcompV, MedicoExecucao medME) {
        this.atestAcompV = atestAcompV;
        this.medME = medME;
        atestAcompV.setVisible(true);
        
        gerarAtestadoAcompanhante();
    }
    
    private void gerarAtestadoAcompanhante() {
        actionListener = (ActionEvent ae) -> {
            Paciente pacM = new Paciente();
            pacM = medME.buscarPacienteDao(atestAcompV.getTxtCpfPac().getText().trim());
            if(pacM == null){
                limpaCampos();
                JOptionPane.showMessageDialog(null, "Nenhum paciente foi encontrado para o CPF fornecido.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            medM = medME.buscarMedicoDao(atestAcompV.getTxtCpfMed().getText().trim());
            if (medM == null) {
                limpaCampos();
                JOptionPane.showMessageDialog(null, "Nenhum médico foi encontrado para o CPF fornecido.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //setando os dados
            atestAcompV.getTxtNomeAcompAtestado().setText(atestAcompV.getTxtNomeAcomp().getText().trim());
            atestAcompV.getTxthrIniAtes().setText(atestAcompV.getTxtHrIni().getText().trim());
            atestAcompV.getTxtHrFimAtest().setText(atestAcompV.getTxtHrFim().getText().trim());
            atestAcompV.getTxtDtAtendAtestado().setText(atestAcompV.getTxtDtAtendimento().getText().trim());
            atestAcompV.getTxtCrm().setText(medM.getCrm().trim());
            atestAcompV.getTxtNomeMed().setText(medM.getNome().trim());
            atestAcompV.getTxtNomePac().setText(pacM.getNome().trim());
        };
        atestAcompV.getBtnGerar().addActionListener(actionListener);
    }
    
    public void limpaCampos(){
        atestAcompV.getTxtHrIni().setText("");
        atestAcompV.getTxtHrFim().setText("");
        atestAcompV.getTxtDtAtendimento().setText("");
        atestAcompV.getTxtCpfMed().setText("");
        atestAcompV.getTxtCpfPac().setText("");
        atestAcompV.getTxtNomeAcomp().setText("");
        atestAcompV.getTxtNomeAcompAtestado().setText("");
        atestAcompV.getTxthrIniAtes().setText("");
        atestAcompV.getTxtHrFimAtest().setText("");
        atestAcompV.getTxtDtAtendAtestado().setText("");
        atestAcompV.getTxtCrm().setText("");
        atestAcompV.getTxtNomeMed().setText("");
        atestAcompV.getTxtNomePac().setText("");
        atestAcompV.getTxtCpfPac().requestFocus();
    }
}
