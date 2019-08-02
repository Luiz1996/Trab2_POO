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
import view.CadPacienteView;

/**
 *
 * @author luiz.pereira
 */
public class CadPacienteController {
    private SecretariaExecucao secME;
    private CadPacienteView cadPacV = new CadPacienteView();
    private ActionListener actionListener;

    public CadPacienteController(CadPacienteView cadPacV, SecretariaExecucao secME) {
        this.cadPacV = cadPacV;
        this.secME = secME; 
        this.cadPacV.setVisible(true);
        this.cadPacV.getBtnRadParticular().setSelected(true);
        cadastrarPaciente();
    }

    private void cadastrarPaciente() {
        actionListener = (ActionEvent ae) -> {
            Paciente pacM = new Paciente();
            FormataDatas dtFormat = new FormataDatas();
            
            //setando os dados obtidos no objeto Paciente
            pacM.setNome(cadPacV.getTxtNome().getText());
            pacM.setCpf(cadPacV.getTxtCpf().getText());
            pacM.setRg(cadPacV.getTxtRg().getText());
            pacM.setEndereco(cadPacV.getTxtEndereco().getText());
            pacM.setCelular(cadPacV.getTxtCelular().getText());
            pacM.setEmail(cadPacV.getTxtEmail().getText());
            
            //setando valor do convenio
            if (cadPacV.getBtnRadParticular().isSelected()) {
                pacM.setConvenio(0);
            } else {
                if (cadPacV.getBtnRadPlano().isSelected()) {
                    pacM.setConvenio(1);
                }
            }
            
            //validando se todos os campos foram preenchidos
            if(
                    pacM.getNome().equals("") ||
                    pacM.getCpf().equals("") ||
                    pacM.getRg().equals("") ||
                    pacM.getEndereco().equals("")
                    ){
                JOptionPane.showMessageDialog(null, "Certifique-se de que todos os campos foram preenchidos.", "Falha no Cadastro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //convertendo data para padrão do banco de dados
            pacM.setDtNasc(dtFormat.formataPadraoBanco(cadPacV.getTxtDtNasc().getText().trim(), "Data de Nascimento"));
            //se for nulo a data não foi informada ou falhou a conversão, então cadastro falha
            if(pacM.getDtNasc() == null){
                cadPacV.getTxtDtNasc().requestFocus();
                return;
            }
            
            //validando se já existe paciente com mesmo cpf
            if(secME.buscarPacienteDao(pacM.getCpf().trim()) != null){
                JOptionPane.showMessageDialog(null, "Já existe paciente cadastrado com esse CPF.", "Falha no cadastro.", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //persistindo os dados no banco JavaDB
            secME.cadastrarPacienteDao(pacM);
            
            //fechando tela de cadastro e chamando garbage collector
            cadPacV.dispose();
            System.gc();
            
            JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso.", "Sucesso no Cadastro", JOptionPane.INFORMATION_MESSAGE);
        };
        cadPacV.getBtnCadastrar().addActionListener(actionListener);
    }
}
