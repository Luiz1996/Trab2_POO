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
import view.ReceitaView;

/**
 *
 * @author Vini
 */
public class ReceitaController {
    private Medico medM = new Medico();
    private MedicoExecucao medME;
    private ReceitaView recV = new ReceitaView();
    private ActionListener actionListener;

    ReceitaController(ReceitaView recV, MedicoExecucao medME) {
        this.recV = recV;
        this.medME = medME;
        recV.setVisible(true);

        gerarReceita();
    }

    private void gerarReceita() {
        actionListener = (ActionEvent ae) -> {
            FormataDatas dtFormat = new FormataDatas();
            Paciente pacM = new Paciente();
            pacM = medME.buscarPacienteDao(recV.getTxtCpfPaciente().getText().trim());
            if (pacM == null) {
                limpaCampos();
                JOptionPane.showMessageDialog(null, "Nenhum paciente foi encontrado para o CPF fornecido.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Medico medM1 = new Medico();
            medM1 = medME.buscarMedicoDao(recV.getTxtCpfMedico().getText().trim());
            if (medM1 == null) {
                limpaCampos();
                JOptionPane.showMessageDialog(null, "Nenhum médico foi encontrado para o CPF fornecido.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //setando os dados
            recV.getTxtDtNasc().setText(dtFormat.formataPadraoBrasil(pacM.getDtNasc(), "Data de Nascimento"));
            recV.getTxtNomePac().setText(pacM.getNome().trim());
            recV.getTxtEndereco().setText(pacM.getEndereco().trim());
            recV.getTxtCelular().setText(pacM.getCelular().trim());
            recV.getTxtEmail().setText(pacM.getEmail().trim());
            if (pacM.getConvenio() == 0) {
                recV.getTxtConvenio().setText("Particular");
            } else {
                recV.getTxtConvenio().setText("Plano de Saúde");
            }
            recV.getTxtNomeMed().setText(medM1.getNome().trim());
            recV.getTxtCrm().setText(medM1.getCrm().trim());
            recV.getTxtCpf().setText(medM1.getCpf().trim());
        };
        recV.getBtnConsultar().addActionListener(actionListener);
    }

    public void limpaCampos() {
        recV.getTxtDtNasc().setText("");
        recV.getTxtNomePac().setText("");
        recV.getTxtEndereco().setText("");
        recV.getTxtCelular().setText("");
        recV.getTxtEmail().setText("");
        recV.getTxtConvenio().setText("");
        recV.getTxtNomeMed().setText("");
        recV.getTxtCrm().setText("");
        recV.getTxtCpfMedico().setText("");
        recV.getTxtCpfPaciente().setText("");
        recV.getTxtCpf().setText("");
        recV.getTxtReceituario().setText("Medicamento.:\nModo de usar:\nPrecauções...:\nReações Adv.:\n--------------------------------------------------------------------------------------------------------\nMedicamento.:\nModo de usar:\nPrecauções...:\nReações Adv.:\n--------------------------------------------------------------------------------------------------------\nMedicamento.:\nModo de usar:\nPrecauções..:\nReações Adv.:");
        recV.getTxtCpfMedico().requestFocus();
    }
}
