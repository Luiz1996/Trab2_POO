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
import view.AltProntuarioView;

/**
 *
 * @author Vini
 */
public class AltProntuarioController {
    private Medico medM = new Medico();
    private MedicoExecucao medME;
    private FormataDatas dtFormat = new FormataDatas();
    private AltProntuarioView altProntV = new AltProntuarioView();
    private Prontuario prontM = new Prontuario();
    private Paciente pacM = new Paciente();
    private ActionListener actionListener;
    private FocusListener focusListener;

    public AltProntuarioController(AltProntuarioView altProntV, MedicoExecucao medME) {
        this.altProntV = altProntV;
        this.altProntV.setVisible(true);
        this.medME = medME;

        cpfPacFocusLost();
        alterarProntuario();
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
                if (!altProntV.isVisible()) {
                    return;
                }

                //validando cfp fornecido
                if (altProntV.getTxtCpfPac().getText().trim().equals("")) {
                    altProntV.getTxtCpfPac().setText("0");
                }

                //validando existencia de prontuário para o CPF informado
                prontM = medME.buscarProntuarioDao(altProntV.getTxtCpfPac().getText());
                
                if (prontM == null) {
                    JOptionPane.showMessageDialog(null, "Não encontramos prontuários para o CPF informado.", "Falha na consulta de prontuário", JOptionPane.ERROR_MESSAGE);
                    limpaCampos();
                    return;
                }

                //validando se o paciente do prontuário ainda existe, caso contrário o prontuário não sera apresentando
                //senão, apareceria apenas os dados do prontuário sem vinculo com paciente algum
                try {
                    pacM = medME.buscarPacienteDao(altProntV.getTxtCpfPac().getText());
                } catch (Exception ae) {
                    JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(ae.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (pacM == null) {
                    JOptionPane.showMessageDialog(null, "Não encontramos paciente com o CPF informado.", "Falha na consulta de paciente", JOptionPane.ERROR_MESSAGE);
                    limpaCampos();
                    return;
                }

                //carregando dados
                altProntV.getTxtNome().setText(pacM.getNome());
                altProntV.getTxtEndereco().setText(pacM.getEndereco());
                altProntV.getTxtDtNasc().setText(dtFormat.formataPadraoBrasil(pacM.getDtNasc(), "Data de Nascimento"));
                altProntV.getTxtEmail().setText(pacM.getEmail());
                if (pacM.getConvenio() == 0) {
                    altProntV.getTxtConvenio().setText("Particular");
                } else {
                    altProntV.getTxtConvenio().setText("Plano de Saúde");
                }
                altProntV.getTxtMsgProntuario().setText(prontM.getTxtPront().trim());
                altProntV.getTxtCpfPac().setText("");
                altProntV.getTxtMsgProntuario().requestFocus();
            }
        };
        altProntV.getTxtCpfPac().addFocusListener(focusListener);
    }

    public void limpaCampos() {
        altProntV.getTxtNome().setText("");
        altProntV.getTxtEndereco().setText("");
        altProntV.getTxtDtNasc().setText("");
        altProntV.getTxtEmail().setText("");
        altProntV.getTxtConvenio().setText("");
        altProntV.getTxtCpfPac().setText("");
        altProntV.getTxtMsgProntuario().setText(""); 
        altProntV.getTxtCpfPac().requestFocus();
    }
    
    private void alterarProntuario() {
        actionListener = (ActionEvent ae) -> {
            if(prontM == null){
                JOptionPane.showMessageDialog(null, "Nenhum prontuário foi selecionado/consultado.", "Falha na alteração", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar as novas informações?", "Confirmação de alteração de prontuário", JOptionPane.YES_NO_OPTION) == 0) {
                prontM.setTxtPront(altProntV.getTxtMsgProntuario().getText().trim());
                medME.alterarProntuarioDao(prontM);
                altProntV.dispose();
                JOptionPane.showMessageDialog(null, "Prontuário salvo com sucesso.", "Sucesso na alteração", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        altProntV.getBtnAlterar().addActionListener(actionListener); 
    }
}
