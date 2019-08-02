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
import model.SecretariaExecucao;
import service.FormataDatas;
import view.ConsMedicoView;

/**
 *
 * @author Luiz Flávio
 */
public class ConsMedicoController {
    private SecretariaExecucao secME;
    private ConsMedicoView consMedV = new ConsMedicoView();
    private ActionListener actionListener;
    
    public  ConsMedicoController(ConsMedicoView consMedV, SecretariaExecucao secME){
        this.consMedV = consMedV;
        this.secME = secME;
        consMedV.setVisible(true);
        consultarMedico();  
    }

    private void consultarMedico() {
        actionListener = (ActionEvent ae) -> {
            Medico med = new Medico();
            FormataDatas dtFormat = new FormataDatas();
            
            //buscando dados do paciente desejado
            med = secME.buscarMedicoDao(consMedV.getTxtCpfConsulta().getText());
            
            //caso não encontre registros então os campos são limpos
            if (med == null) {
                consMedV.getTxtNome().setText("");
                consMedV.getTxtCpf().setText("");
                consMedV.getTxtRg().setText("");
                consMedV.getTxtEndereco().setText("");
                consMedV.getTxtCelular().setText("");
                consMedV.getTxtEmail().setText("");
                consMedV.getTxtDtNasc().setText("");
                consMedV.getTxtCrm().setText("");
                consMedV.getTxtCpfConsulta().setText("");
                consMedV.getTxtDtAdmissao().setText("");
                consMedV.getTxtCpfConsulta().requestFocus();
                JOptionPane.showMessageDialog(null, "Nenhum médico encontrado.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //carregando os txtFields
            consMedV.getTxtNome().setText(med.getNome().trim());
            consMedV.getTxtNome().setText(med.getNome().trim());
            consMedV.getTxtCpf().setText(med.getCpf().trim());
            consMedV.getTxtRg().setText(med.getRg().trim());
            consMedV.getTxtEndereco().setText(med.getEndereco().trim());
            consMedV.getTxtCelular().setText(med.getCelular().trim());
            consMedV.getTxtEmail().setText(med.getEmail().trim());
            consMedV.getTxtCrm().setText(med.getCrm().trim());
            
            //obtendo a data de nascimento formatada
            consMedV.getTxtDtNasc().setText(dtFormat.formataPadraoBrasil(med.getDtNasc(), "Data de Nascimento"));
            consMedV.getTxtDtAdmissao().setText(dtFormat.formataPadraoBrasil(med.getDtAdmissao(), "Data de Admissão"));
            
            consMedV.getTxtCpfConsulta().setText("");
        };
        consMedV.getBtnConsultar().addActionListener(actionListener);
    } 
}
