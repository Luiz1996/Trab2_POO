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
import view.CadProntuarioView;

/**
 *
 * @author Vini
 */
public class CadProntuarioController {
    private Medico medM = new Medico();
    private MedicoExecucao medME;
    private FormataDatas dtFormat = new FormataDatas();
    private CadProntuarioView cadProntV = new CadProntuarioView();
    private Prontuario prontM = new Prontuario();
    private Paciente pacM = new Paciente();
    private ActionListener actionListener;
    private FocusListener focusListener;

    public CadProntuarioController(CadProntuarioView cadProntV, MedicoExecucao medME) {
        this.cadProntV = cadProntV;
        this.cadProntV.setVisible(true);
        this.medME = medME;

        cadastrarProntuario();
        cpfPacFocusLost();
    }

    private void cadastrarProntuario() {
        actionListener = (ActionEvent ae) -> {
            if (pacM.getId() == null) {
                JOptionPane.showMessageDialog(null, "Nenhum paciente foi consultado/selecionado.", "Falha na deleção", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar?", "Confirmação de Cadastro de Prontuário", JOptionPane.YES_NO_OPTION) == 0) {
                prontM.setCpfPac(pacM.getCpf());
                prontM.setTxtPront(cadProntV.getTxtMsgProntuario().getText());
                
                //efetuando as alterações
                medME.cadastrarProntuarioDao(prontM);
                
                cadProntV.dispose();
                JOptionPane.showMessageDialog(null, "Prontuário salvo com sucesso!", "Sucesso no Cadastramento", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        cadProntV.getBtnCadastrar().addActionListener(actionListener);
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
                if (!cadProntV.isVisible()) {
                    return;
                }

                //validando cfp fornecido
                if (cadProntV.getTxtCpfPac().getText().trim().equals("")) {
                    cadProntV.getTxtCpfPac().setText("0");
                }

                //consultando dados do paciente
                pacM = medME.buscarPacienteDao(cadProntV.getTxtCpfPac().getText());

                if (pacM == null) {
                    //caso não encontre paciente, então os campos da consulta anterior são limpados
                    cadProntV.getTxtNome().setText("");
                    cadProntV.getTxtEndereco().setText("");
                    cadProntV.getTxtDtNasc().setText("");
                    cadProntV.getTxtEmail().setText("");
                    cadProntV.getTxtConvenio().setText("");
                    cadProntV.getTxtCpfPac().setText("");
                    cadProntV.getTxtMsgProntuario().setText("");
                    JOptionPane.showMessageDialog(null, "Não encontramos paciente com o CPF informado.", "Falha na consulta de paciente", JOptionPane.ERROR_MESSAGE);
                    cadProntV.getTxtCpfPac().requestFocus();
                    return;
                }

                //verificando se o paciente já possui prontuário cadastrado
                if (medME.buscarProntuarioQuantidadeDao(cadProntV.getTxtCpfPac().getText()) > 0) {
                    cadProntV.getTxtCpfPac().setText("");
                    JOptionPane.showMessageDialog(null, "Paciente já possui prontuário cadastrado, utilize a opção Alterar Prontuário.", "Paciente com prontuário", JOptionPane.ERROR_MESSAGE);
                    cadProntV.getTxtCpfPac().requestFocus();
                    return;
                }

                //carregando dados do paciente
                cadProntV.getTxtNome().setText(pacM.getNome());
                cadProntV.getTxtEndereco().setText(pacM.getEndereco());
                cadProntV.getTxtDtNasc().setText(dtFormat.formataPadraoBrasil(pacM.getDtNasc(), "Data de Nascimento"));
                cadProntV.getTxtEmail().setText(pacM.getEmail());
                if (pacM.getConvenio() == 0) {
                    cadProntV.getTxtConvenio().setText("Particular");
                } else {
                    cadProntV.getTxtConvenio().setText("Plano de Saúde");
                }
                cadProntV.getTxtCpfPac().setText("");
                cadProntV.getTxtMsgProntuario().requestFocus();
            }
        };
        cadProntV.getTxtCpfPac().addFocusListener(focusListener);
    }
}
