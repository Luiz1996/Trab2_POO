/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.SecretariaExecucao;
import service.FormataDatas;
import view.DelConsultaView;

/**
 *
 * @author Luiz Flávio
 */
public class DelConsultaController {
    private SecretariaExecucao secME;
    private Consulta conM = new Consulta();
    private FormataDatas dtFormat = new FormataDatas();
    private DelConsultaView delConV;
    private ActionListener actionListener;

    DelConsultaController(DelConsultaView delConV, SecretariaExecucao secME) {
        this.delConV = delConV;
        delConV.setVisible(true);
        this.secME = secME;
        conM.setId(0);
        consultarConsulta();
        deletarConsulta();
    }

    private void consultarConsulta() {
        actionListener = (ActionEvent ae) -> {
            //validando Id fornecido
            if (delConV.getTxtIdBusca().getText().trim().equals("")) {
                conM = null;
            } else {
                //trazendo dados da consulta
                conM = secME.buscarConsultasPorIdDao(Integer.parseInt(delConV.getTxtIdBusca().getText()));
            }
            
            //validando se foi encontrado algum registro
            if (conM == null) {
                delConV.getTxtNomePac().setText("");
                delConV.getTxtNomeMed().setText("");
                delConV.getTxtDtConsulta().setText("");
                delConV.getTxtDtNascPac().setText("");
                delConV.getTxtDtNascMed().setText("");
                delConV.getTxtEndereco().setText("");
                delConV.getTxtCrm().setText("");
                delConV.getTxtTipoConsulta().setText("");
                delConV.getTxtIdBusca().setText("");
                delConV.getTxtIdBusca().requestFocus();
                JOptionPane.showMessageDialog(null, "Nenhuma consulta encontrada para o ID informado.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //obtendo dados particulares do paciente
            Paciente pacM = new Paciente();
            pacM = secME.buscarPacienteDao(conM.getCpfPac());
            
            //obtendo dados particulares do médico
            Medico medM = new Medico();
            medM = secME.buscarMedicoDao(conM.getCpfMed());
            
            //setando os valores nos txtFields
            delConV.getTxtNomePac().setText(pacM.getNome().trim());
            delConV.getTxtDtNascPac().setText(dtFormat.formataPadraoBrasil(pacM.getDtNasc(), "Data de Nascimento"));
            delConV.getTxtEndereco().setText(pacM.getEndereco().trim());
            delConV.getTxtNomeMed().setText(medM.getNome().trim());
            delConV.getTxtDtNascMed().setText(dtFormat.formataPadraoBrasil(medM.getDtNasc(), "Data de Nascimento"));
            delConV.getTxtCrm().setText(medM.getCrm().trim());
            delConV.getTxtDtConsulta().setText(dtFormat.formataPadraoBrasilComHora(conM.getDtConsulta(), "Data da Consulta"));
            
            //setando tipo de consulta
            if (conM.getTipoConsulta() == 0) {
                delConV.getTxtTipoConsulta().setText("Normal");
            } else {
                if (conM.getTipoConsulta() == 1) {
                    delConV.getTxtTipoConsulta().setText("Retorno");
                }
            }
        };
        delConV.getBtnConsulta().addActionListener(actionListener);
    }

    private void deletarConsulta() {
        actionListener = (ActionEvent ae) -> {
            //validando se alguma consulta foi pesquisada na tela
            if (conM == null || conM.getId() == 0) {
                JOptionPane.showMessageDialog(null, "Nenhuma consulta foi selecionada.", "Falha na alteração", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //confirmando deleção da consulta
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar a consulta?", "Confirmação de deleção", JOptionPane.YES_NO_OPTION) == 0) {
                secME.deletarConsultaDao(conM);
                delConV.dispose();
                JOptionPane.showMessageDialog(null, "Consulta deletada com sucesso!", "Sucesso na deleção", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        delConV.getBtnDeletar().addActionListener(actionListener);
    }
}
