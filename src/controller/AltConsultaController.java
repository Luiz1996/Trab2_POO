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
import view.AltConsultaView;

/**
 *
 * @author luiz.pereira
 */
public class AltConsultaController {
    private SecretariaExecucao secME;
    private Consulta conM = new Consulta();
    private FormataDatas dtFormat = new FormataDatas();
    private AltConsultaView altConV;
    private ActionListener actionListener;

    AltConsultaController(AltConsultaView altConV, SecretariaExecucao secME) {
        this.altConV = altConV;
        altConV.setVisible(true);
        this.secME = secME;
        conM.setId(0);
        consultarConsulta();
        alterarConsulta();
    }

    private void consultarConsulta() {
        actionListener = (ActionEvent ae) -> {
            //validando Id fornecido
            if (altConV.getTxtIdBusca().getText().equals("")) {
                conM = null;
            } else {
                conM = secME.buscarConsultasPorIdDao(Integer.parseInt(altConV.getTxtIdBusca().getText()));
            }
            
            //validando se foi encontrado algum registro
            if (conM == null) {
                altConV.getTxtNomePac().setText("");
                altConV.getTxtNomeMed().setText("");
                altConV.getTxtDtConsulta().setText("");
                altConV.getTxtDtNascPac().setText("");
                altConV.getTxtDtNascMed().setText("");
                altConV.getTxtEndereco().setText("");
                altConV.getTxtCrm().setText("");
                altConV.getBtnRadNormal().setSelected(true);
                altConV.getTxtIdBusca().setText("");
                altConV.getTxtIdBusca().requestFocus();
                conM = null;
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
            altConV.getTxtNomePac().setText(pacM.getNome().trim());
            altConV.getTxtDtNascPac().setText(dtFormat.formataPadraoBrasil(pacM.getDtNasc(), "Data de Nascimento"));
            altConV.getTxtEndereco().setText(pacM.getEndereco().trim());
            altConV.getTxtNomeMed().setText(medM.getNome().trim());
            altConV.getTxtDtNascMed().setText(dtFormat.formataPadraoBrasil(medM.getDtNasc(), "Data de Nascimento"));
            altConV.getTxtCrm().setText(medM.getCrm().trim());
            altConV.getTxtDtConsulta().setText(dtFormat.formataPadraoBrasilComHora(conM.getDtConsulta(), "Data da Consulta"));
            
            //setando tipo de consulta
            if (conM.getTipoConsulta() == 0) {
                altConV.getBtnRadNormal().setSelected(true);
            } else {
                if (conM.getTipoConsulta() == 1) {
                    altConV.getBtnRadRetorno().setSelected(true);
                }
            }
        };
        altConV.getBtnConsulta().addActionListener(actionListener);
    }

    private void alterarConsulta() {
        actionListener = (ActionEvent ae) -> {
            //validando se alguma consulta foi pesquisada na tela
            if (conM == null || conM.getId() == 0) {
                JOptionPane.showMessageDialog(null, "Nenhuma consulta foi selecionada.", "Falha na alteração", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //setando os novos dados
            if (altConV.getBtnRadNormal().isSelected()) {
                conM.setTipoConsulta(0);
            } else {
                if (altConV.getBtnRadRetorno().isSelected()) {
                    conM.setTipoConsulta(1);
                }
            }
            conM.setDtConsulta(dtFormat.formataPadraoBancoComHora(altConV.getTxtDtConsulta().getText().trim(), "Data da Consulta"));
            
            //validando se o campo data consulta foi preenchido corretamente
            if (conM.getDtConsulta() == null) {
                altConV.getTxtDtConsulta().setText("");
                altConV.getTxtDtConsulta().requestFocus();
                return;
            }
            
            //confirmando alteração da consulta
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar as alterações?", "Confirmação de alteração", JOptionPane.YES_NO_OPTION) == 0) {
                secME.alterarConsultaDao(conM);
                altConV.dispose();
                JOptionPane.showMessageDialog(null, "Consulta alterada com sucesso!", "Sucesso na alteração", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        altConV.getBtnAlterar().addActionListener(actionListener);
    }
}
