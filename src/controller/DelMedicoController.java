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
import view.DelMedicoView;

/**
 *
 * @author Luiz Flávio
 */
public class DelMedicoController {
    private SecretariaExecucao secME;
    private Medico medM = new Medico();
    private DelMedicoView delMedV = new DelMedicoView();
    private ActionListener actionListener;
    
    public  DelMedicoController(DelMedicoView delMedV, SecretariaExecucao secME){
        this.delMedV = delMedV;
        this.secME = secME;
        delMedV.setVisible(true);
        consultarMedico();
        deletarMEdico();
    }
    
    private void consultarMedico() {
        actionListener = (ActionEvent ae) -> {
            FormataDatas dtFormat = new FormataDatas();
            
            //buscando dados do paciente desejado
            medM = secME.buscarMedicoDao(delMedV.getTxtCpfConsulta().getText());
            
            //caso não encontre registros então os campos são limpos
            if (medM == null) {
                delMedV.getTxtNome().setText("");
                delMedV.getTxtCpf().setText("");
                delMedV.getTxtRg().setText("");
                delMedV.getTxtEndereco().setText("");
                delMedV.getTxtCelular().setText("");
                delMedV.getTxtEmail().setText("");
                delMedV.getTxtDtNasc().setText("");
                delMedV.getTxtCrm().setText("");
                delMedV.getTxtCpfConsulta().setText("");
                delMedV.getTxtDtAdmissao().setText("");
                delMedV.getTxtCpfConsulta().requestFocus();
                JOptionPane.showMessageDialog(null, "Nenhum médico encontrado.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //carregando os txtFields
            delMedV.getTxtNome().setText(medM.getNome().trim());
            delMedV.getTxtNome().setText(medM.getNome().trim());
            delMedV.getTxtCpf().setText(medM.getCpf().trim());
            delMedV.getTxtRg().setText(medM.getRg().trim());
            delMedV.getTxtEndereco().setText(medM.getEndereco().trim());
            delMedV.getTxtCelular().setText(medM.getCelular().trim());
            delMedV.getTxtEmail().setText(medM.getEmail().trim());
            delMedV.getTxtCrm().setText(medM.getCrm().trim());
            
            //obtendo a data de nascimento formatada
            delMedV.getTxtDtNasc().setText(dtFormat.formataPadraoBrasil(medM.getDtNasc(), "Data de Nascimento"));
            delMedV.getTxtDtAdmissao().setText(dtFormat.formataPadraoBrasil(medM.getDtAdmissao(), "Data de Admissão"));
            
            delMedV.getTxtCpfConsulta().setText("");
        };
        delMedV.getBtnConsultar().addActionListener(actionListener);
    } 

    private void deletarMEdico() {
        actionListener = (ActionEvent ae) -> {
            if(medM.getId() == null){
                JOptionPane.showMessageDialog(null, "Nenhum médico foi consultado/selecionado.", "Falha na deleção", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o médico?", "Confirmação de deleção", JOptionPane.YES_NO_OPTION) == 0){
                secME.deletarMedicoDao(medM);
                delMedV.dispose();
                JOptionPane.showMessageDialog(null, "Médico deletado com sucesso!", "Sucesso na deleção", JOptionPane.INFORMATION_MESSAGE); 
            }
        };
        delMedV.getBtnDeletar().addActionListener(actionListener);
    }
}
