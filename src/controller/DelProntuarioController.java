/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import model.Medico;
import model.MedicoExecucao;
import model.Paciente;
import model.Prontuario;
import service.FormataDatas;
import view.DelProntuarioView;

/**
 *
 * @author Vini
 */
public class DelProntuarioController {
    private Medico medM = new Medico();
    private MedicoExecucao medME;
    private FormataDatas dtFormat = new FormataDatas();
    private DelProntuarioView delProntV = new DelProntuarioView();
    private Prontuario prontM = new Prontuario();
    private Paciente pacM = new Paciente();
    private ActionListener actionListener;
    private FocusListener focusListener;

    public DelProntuarioController(DelProntuarioView delProntV, MedicoExecucao medME) {
        this.delProntV = delProntV;
        this.delProntV.setVisible(true);
        this.medME = medME;

        cpfPacFocusLost();
        deletarProntuario();
    }
    
    @SuppressWarnings("empty-statement")
    private void cpfPacFocusLost() {
        focusListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //não necessita implementação 
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!delProntV.isVisible()) {
                    return;
                }

                //validando cfp fornecido
                if (delProntV.getTxtCpfPac().getText().trim().equals("")) {
                    delProntV.getTxtCpfPac().setText("0");
                }

                //validando existencia de prontuário para o CPF informado
                prontM = medME.buscarProntuarioDao(delProntV.getTxtCpfPac().getText());

                if (prontM == null) {
                    JOptionPane.showMessageDialog(null, "Não encontramos prontuários para o CPF informado.", "Falha na consulta de prontuário", JOptionPane.ERROR_MESSAGE);
                    limpaCampos();
                    return;
                }

                //validando se o paciente do prontuário ainda existe, caso contrário o prontuário não sera apresentando
                //senão, apareceria apenas os dados do prontuário sem vinculo com paciente algum
                pacM = medME.buscarPacienteDao(delProntV.getTxtCpfPac().getText());
                
                if (pacM == null) {
                    JOptionPane.showMessageDialog(null, "Não encontramos paciente com o CPF informado.", "Falha na consulta de paciente", JOptionPane.ERROR_MESSAGE);
                    limpaCampos();
                    return;
                }

                //carregando dados
                delProntV.getTxtNome().setText(pacM.getNome());
                delProntV.getTxtEndereco().setText(pacM.getEndereco());
                delProntV.getTxtDtNasc().setText(dtFormat.formataPadraoBrasil(pacM.getDtNasc(), "Data de Nascimento"));
                delProntV.getTxtEmail().setText(pacM.getEmail());
                if (pacM.getConvenio() == 0) {
                    delProntV.getTxtConvenio().setText("Particular");
                } else {
                    delProntV.getTxtConvenio().setText("Plano de Saúde");
                }
                delProntV.getTxtMsgProntuario().setText(prontM.getTxtPront().trim());
                delProntV.getTxtCpfPac().setText("");
                delProntV.getTxtMsgProntuario().requestFocus();
            }
        };
        delProntV.getTxtCpfPac().addFocusListener(focusListener);
    }

    public void limpaCampos() {
        delProntV.getTxtNome().setText("");
        delProntV.getTxtEndereco().setText("");
        delProntV.getTxtDtNasc().setText("");
        delProntV.getTxtEmail().setText("");
        delProntV.getTxtConvenio().setText("");
        delProntV.getTxtCpfPac().setText("");
        delProntV.getTxtMsgProntuario().setText(""); 
        delProntV.getTxtCpfPac().requestFocus();
    }
    
    private void deletarProntuario() {
        actionListener = (ActionEvent ae) -> {
            if(prontM == null){
                JOptionPane.showMessageDialog(null, "Nenhum prontuário foi selecionado/consultado.", "Falha na alteração", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o prontuário?", "Confirmação de deleção", JOptionPane.YES_NO_OPTION) == 0) {
                prontM.setTxtPront(delProntV.getTxtMsgProntuario().getText().trim());
                medME.deletarProntuarioDao(prontM);
                delProntV.dispose();
                JOptionPane.showMessageDialog(null, "Prontuário deletado com sucesso.", "Sucesso na deleção", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        delProntV.getBtnDeletar().addActionListener(actionListener); 
    }
}
