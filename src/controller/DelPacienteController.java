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
import view.DelPacienteView;

/**
 *
 * @author Luiz Flávio
 */
public class DelPacienteController {
    private SecretariaExecucao secME;
    private Paciente pacM = new Paciente();
    private FormataDatas dtFormat = new FormataDatas();
    private DelPacienteView delPacV = new DelPacienteView();
    private ActionListener actionListener;
    
    public DelPacienteController(DelPacienteView delPacV, SecretariaExecucao secME) {
        this.delPacV = delPacV;
        this.secME = secME; 
        this.delPacV.setVisible(true);
        deletarPaciente();
        consultarPaciente();
    }
    
    private void deletarPaciente() {
        actionListener = (ActionEvent ae) -> {
            if(pacM.getId() == null){
                JOptionPane.showMessageDialog(null, "Nenhum paciente foi consultado/selecionado.", "Falha na deleção", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o paciente?", "Confirmação de deleção", JOptionPane.YES_NO_OPTION) == 0){
                secME.deletarPacienteDao(pacM);
                delPacV.dispose();
                JOptionPane.showMessageDialog(null, "Paciente deletado com sucesso!", "Sucesso na deleção", JOptionPane.INFORMATION_MESSAGE); 
            }
        };
        delPacV.getBtnDeletar().addActionListener(actionListener); 
    }
    
    private void consultarPaciente() {
        actionListener = (ActionEvent ae) -> {
            //buscando dados do paciente desejado
            pacM = secME.buscarPacienteDao(delPacV.getTxtCpfConsulta().getText());
            
            //caso não encontre registros então os campos são limpados
            if (pacM == null) {
                delPacV.getTxtNome().setText("");
                delPacV.getTxtCpf().setText("");
                delPacV.getTxtRg().setText("");
                delPacV.getTxtEndereco().setText("");
                delPacV.getTxtCelular().setText("");
                delPacV.getTxtEmail().setText("");
                delPacV.getTxtDtNasc().setText("");
                delPacV.getBtnRadParticular().setSelected(false);
                delPacV.getBtnRadPlano().setSelected(false);
                delPacV.getTxtCpfConsulta().setText("");
                delPacV.getTxtCpfConsulta().requestFocus();
                JOptionPane.showMessageDialog(null, "Nenhum paciente encontrado.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //carregando os txtFields
            delPacV.getTxtNome().setText(pacM.getNome().trim());
            delPacV.getTxtNome().setText(pacM.getNome().trim());
            delPacV.getTxtCpf().setText(pacM.getCpf().trim());
            delPacV.getTxtRg().setText(pacM.getRg().trim());
            delPacV.getTxtEndereco().setText(pacM.getEndereco().trim());
            delPacV.getTxtCelular().setText(pacM.getCelular().trim());
            delPacV.getTxtEmail().setText(pacM.getEmail().trim());
            
            //obtendo a data de nascimento formatada
            delPacV.getTxtDtNasc().setText(dtFormat.formataPadraoBrasil(pacM.getDtNasc(), "Data de Nascimento"));
            
            //obtendo o tipo de convenio do paciente
            if (pacM.getConvenio() == 0) {
                delPacV.getBtnRadParticular().setSelected(true);
            } else {
                if(pacM.getConvenio() == 1){
                    delPacV.getBtnRadPlano().setSelected(true);
                }
            }
            delPacV.getTxtCpfConsulta().setText("");
        };
        delPacV.getBtnConsultar().addActionListener(actionListener);
    }
}
