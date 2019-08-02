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
import view.AtestadoView;

/**
 *
 * @author Vini
 */
public class AtestadoController {
    private Medico medM = new Medico();
    private MedicoExecucao medME;
    private AtestadoView atestV = new AtestadoView();
    private ActionListener actionListener;

    AtestadoController(AtestadoView atestV, MedicoExecucao medME) {
        this.atestV = atestV;
        this.medME = medME;
        atestV.setVisible(true);
        
        gerarAtestadoAcompanhante();
    }
    
    private void gerarAtestadoAcompanhante() {
        actionListener = (ActionEvent ae) -> {
            Paciente pacM = new Paciente();
            pacM = medME.buscarPacienteDao(atestV.getTxtCpfPac().getText().trim());
            if(pacM == null){
                limpaCampos();
                JOptionPane.showMessageDialog(null, "Nenhum paciente foi encontrado para o CPF fornecido.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Medico medM = new Medico();
            medM = medME.buscarMedicoDao(atestV.getTxtCpfMed().getText().trim());
            if (medM == null) {
                limpaCampos();
                JOptionPane.showMessageDialog(null, "Nenhum médico foi encontrado para o CPF fornecido.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //setando os dados
            atestV.getTxthrIniAtes().setText(atestV.getTxtHrIni().getText().trim());
            atestV.getTxtHrFimAtest().setText(atestV.getTxtHrFim().getText().trim());
            atestV.getTxtDtAtendAtestado().setText(atestV.getTxtDtAtendimento().getText().trim());
            atestV.getTxtCrm().setText(medM.getCrm().trim());
            atestV.getTxtNomeMed().setText(medM.getNome().trim());
            atestV.getTxtNomePac().setText(pacM.getNome().trim());
        };
        atestV.getBtnGerar().addActionListener(actionListener);
    }
    
    public void limpaCampos(){
        atestV.getTxtHrIni().setText("");
        atestV.getTxtHrFim().setText("");
        atestV.getTxtDtAtendimento().setText("");
        atestV.getTxtCpfMed().setText("");
        atestV.getTxtCpfPac().setText("");
        atestV.getTxthrIniAtes().setText("");
        atestV.getTxtHrFimAtest().setText("");
        atestV.getTxtDtAtendAtestado().setText("");
        atestV.getTxtCrm().setText("");
        atestV.getTxtNomeMed().setText("");
        atestV.getTxtNomePac().setText("");
        atestV.getTxtCpfPac().requestFocus();
    }
}
