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
import view.AltMedicoView;

/**
 *
 * @author Luiz Flávio
 */
public class AltMedicoController {
    private SecretariaExecucao secME;
    private Medico medM = new Medico();
    private FormataDatas dtFormat = new FormataDatas();
    private AltMedicoView altMedV = new AltMedicoView();
    private ActionListener actionListener;
    private String cpfAux;

    public AltMedicoController(AltMedicoView altMedV, SecretariaExecucao secME) {
        this.altMedV = altMedV;
        this.secME = secME;
        altMedV.setVisible(true);
        consultarMedico();
        alterarMedico();
    }

    private void alterarMedico() {
        actionListener = (ActionEvent ae) -> {
            //setando os novos valores
            medM.setNome(altMedV.getTxtNome().getText());
            medM.setCpf(altMedV.getTxtCpf().getText());
            medM.setRg(altMedV.getTxtRg().getText());
            medM.setEndereco(altMedV.getTxtEndereco().getText());
            medM.setCelular(altMedV.getTxtCelular().getText());
            medM.setEmail(altMedV.getTxtEmail().getText());
            medM.setCrm(altMedV.getTxtCrm().getText());
            
            //setando data de nascimento convertida
            medM.setDtNasc(dtFormat.formataPadraoBanco(altMedV.getTxtDtNasc().getText().trim(), "Data de Nascimento"));
            medM.setDtAdmissao(dtFormat.formataPadraoBanco(altMedV.getTxtDtAdmissao().getText().trim(), "Data de Admissão"));
            
            //se for nulo a data não foi informada ou falhou a conversão, então cadastro falha
            if (medM.getDtNasc() == null) {
                altMedV.getTxtDtNasc().requestFocus();
                return;
            } else {
                if (medM.getDtAdmissao() == null) {
                    altMedV.getTxtDtAdmissao().requestFocus();
                }
            }
            
            //validando se todos os campos foram preenchidos
            if (medM.getNome().equals("")
                    || medM.getCpf().equals("")
                    || medM.getRg().equals("")
                    || medM.getEndereco().equals("")
                    || medM.getCelular().equals("")
                    || medM.getEmail().equals("")
                    || medM.getCrm().equals("")) {
                JOptionPane.showMessageDialog(null, "Certifique-se de que todos os campos foram preenchidos.", "Falha na alteração", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //presistindo novos dados no banco JavaDB
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar as novas informações?", "Confirmação de alteração", JOptionPane.YES_NO_OPTION) == 0) {
                //validando se já existe médico para o novo cpf informado
                if (!medM.getCpf().trim().equals(cpfAux) && secME.buscarMedicoDao(medM.getCpf().trim()) != null) {
                    JOptionPane.showMessageDialog(null, "Já existe médico cadastrado para o novo CPF.", "Falha na alteração", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                secME.alterarMedicoDao(medM);
                altMedV.dispose();
                JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso.", "Sucesso na alteração", JOptionPane.INFORMATION_MESSAGE);
                
            }
        };
        altMedV.getBtnAlterar().addActionListener(actionListener);
    }

    private void consultarMedico() {
        actionListener = (ActionEvent ae) -> {
            FormataDatas dtFormat1 = new FormataDatas();
            //buscando dados do medico desejado
            medM = secME.buscarMedicoDao(altMedV.getTxtCpfConsulta().getText());
            cpfAux = medM.getCpf().trim();
            //caso não encontre registros então os campos são limpos
            if (medM == null) {
                altMedV.getTxtNome().setText("");
                altMedV.getTxtCpf().setText("");
                altMedV.getTxtRg().setText("");
                altMedV.getTxtEndereco().setText("");
                altMedV.getTxtCelular().setText("");
                altMedV.getTxtEmail().setText("");
                altMedV.getTxtDtNasc().setText("");
                altMedV.getTxtCrm().setText("");
                altMedV.getTxtCpfConsulta().setText("");
                altMedV.getTxtDtAdmissao().setText("");
                altMedV.getTxtCpfConsulta().requestFocus();
                JOptionPane.showMessageDialog(null, "Nenhum médico encontrado.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //carregando os txtFields
            altMedV.getTxtNome().setText(medM.getNome().trim());
            altMedV.getTxtNome().setText(medM.getNome().trim());
            altMedV.getTxtCpf().setText(medM.getCpf().trim());
            altMedV.getTxtRg().setText(medM.getRg().trim());
            altMedV.getTxtEndereco().setText(medM.getEndereco().trim());
            altMedV.getTxtCelular().setText(medM.getCelular().trim());
            altMedV.getTxtEmail().setText(medM.getEmail().trim());
            altMedV.getTxtCrm().setText(medM.getCrm().trim());
            //obtendo a data de nascimento formatada
            altMedV.getTxtDtNasc().setText(dtFormat1.formataPadraoBrasil(medM.getDtNasc(), "Data de Nascimento"));
            altMedV.getTxtDtAdmissao().setText(dtFormat1.formataPadraoBrasil(medM.getDtAdmissao(), "Data de Admissão"));
            altMedV.getTxtCpfConsulta().setText("");
        };
        altMedV.getBtnConsultar().addActionListener(actionListener);
    }
}
