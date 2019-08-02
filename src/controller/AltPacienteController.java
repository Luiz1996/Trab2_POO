/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Paciente;
import model.SecretariaExecucao;
import service.FormataDatas;
import view.AltPacienteView;

/**
 *
 * @author Luiz Flávio
 */
public class AltPacienteController {
    private SecretariaExecucao secME;
    private Paciente pacM = new Paciente();
    private FormataDatas dtFormat = new FormataDatas();
    private AltPacienteView altPacV = new AltPacienteView();
    private ActionListener actionListener;
    private String cpfAux;

    public AltPacienteController(AltPacienteView altPacV, SecretariaExecucao secME) {
        this.altPacV = altPacV;
        this.secME = secME;
        this.altPacV.setVisible(true);
        alterarPaciente();
        consultarPaciente();
    }

    private void alterarPaciente() {
        actionListener = (ActionEvent ae) -> {
            //setando os novos valores
            pacM.setNome(altPacV.getTxtNome().getText());
            pacM.setCpf(altPacV.getTxtCpf().getText());
            pacM.setRg(altPacV.getTxtRg().getText());
            pacM.setEndereco(altPacV.getTxtEndereco().getText());
            pacM.setCelular(altPacV.getTxtCelular().getText());
            pacM.setEmail(altPacV.getTxtEmail().getText());
            
            //setando data de nascimento convertida
            pacM.setDtNasc(dtFormat.formataPadraoBanco(altPacV.getTxtDtNasc().getText().trim(), "Data de Nascimento"));
            
            //se for nulo a data não foi informada ou falhou a conversão, então cadastro falha
            if (pacM.getDtNasc() == null) {
                altPacV.getTxtDtNasc().requestFocus();
                return;
            }
            
            //setando tipo de convenio
            if (altPacV.getBtnRadParticular().isSelected()) {
                pacM.setConvenio(0);
            } else {
                if (altPacV.getBtnRadPlano().isSelected()) {
                    pacM.setConvenio(1);
                }
            }
            
            //validando se todos os campos foram preenchidos
            if (pacM.getNome().equals("")
                    || pacM.getCpf().equals("")
                    || pacM.getRg().equals("")
                    || pacM.getEndereco().equals("")) {
                JOptionPane.showMessageDialog(null, "Certifique-se de que todos os campos foram preenchidos.", "Falha na alteração", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //presistindo novos dados no banco JavaDB
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar as novas informações?", "Confirmação de alteração", JOptionPane.YES_NO_OPTION) == 0) {
                //validando se já existe paciente para o novo cpf informado
                if (!pacM.getCpf().trim().equals(cpfAux) && secME.buscarPacienteDao(pacM.getCpf().trim()) != null) {
                    JOptionPane.showMessageDialog(null, "Já existe paciente cadastrado para o novo CPF.", "Falha na alteração", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                //se não houver problemas a persistencia ocorre normalmente
                secME.alterarPacienteDao(pacM);
                
                altPacV.dispose();
                JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso.", "Sucesso na alteração", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        altPacV.getBtnAlterar().addActionListener(actionListener);
    }

    private void consultarPaciente() {
        actionListener = (ActionEvent ae) -> {
            //buscando dados do paciente desejado
            try {
                pacM = secME.buscarPacienteDao(altPacV.getTxtCpfConsulta().getText());
                cpfAux = pacM.getCpf().trim();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //caso não encontre registros então os campos são limpos
            if (pacM == null) {
                altPacV.getTxtNome().setText("");
                altPacV.getTxtCpf().setText("");
                altPacV.getTxtRg().setText("");
                altPacV.getTxtEndereco().setText("");
                altPacV.getTxtCelular().setText("");
                altPacV.getTxtEmail().setText("");
                altPacV.getTxtDtNasc().setText("");
                altPacV.getBtnRadParticular().setSelected(false);
                altPacV.getBtnRadPlano().setSelected(false);
                altPacV.getTxtCpfConsulta().setText("");
                altPacV.getTxtCpfConsulta().requestFocus();
                JOptionPane.showMessageDialog(null, "Nenhum paciente encontrado.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //carregando os txtFields
            altPacV.getTxtNome().setText(pacM.getNome().trim());
            altPacV.getTxtNome().setText(pacM.getNome().trim());
            altPacV.getTxtCpf().setText(pacM.getCpf().trim());
            altPacV.getTxtRg().setText(pacM.getRg().trim());
            altPacV.getTxtEndereco().setText(pacM.getEndereco().trim());
            altPacV.getTxtCelular().setText(pacM.getCelular().trim());
            altPacV.getTxtEmail().setText(pacM.getEmail().trim());
            
            //obtendo a data de nascimento formatada
            altPacV.getTxtDtNasc().setText(dtFormat.formataPadraoBrasil(pacM.getDtNasc(), "Data de Nascimento"));
            
            //obtendo o tipo de convenio do paciente
            if (pacM.getConvenio() == 0) {
                altPacV.getBtnRadParticular().setSelected(true);
            } else {
                if (pacM.getConvenio() == 1) {
                    altPacV.getBtnRadPlano().setSelected(true);
                }
            }
            altPacV.getTxtCpfConsulta().setText("");
        };
        altPacV.getBtnConsultar().addActionListener(actionListener);
    }
}
