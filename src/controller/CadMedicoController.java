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
import view.CadMedicoView;

/**
 *
 * @author Luiz Flávio
 */
public class CadMedicoController {
    private SecretariaExecucao secME;
    private CadMedicoView cadMedV;
    private ActionListener actionListener;
    
    public CadMedicoController(CadMedicoView cadMedV, SecretariaExecucao secME){
        this.cadMedV = cadMedV;
        this.secME = secME;
        cadMedV.setVisible(true);
        cadastrarMedico();
    }
    
    private void cadastrarMedico() {
        actionListener = (ActionEvent ae) -> {
            Medico medM = new Medico();
            FormataDatas dtFormat = new FormataDatas();
            
            //setando os dados obtidos no objeto Paciente
            medM.setNome(cadMedV.getTxtNome().getText());
            medM.setCpf(cadMedV.getTxtCpf().getText());
            medM.setRg(cadMedV.getTxtRg().getText());
            medM.setEndereco(cadMedV.getTxtEndereco().getText());
            medM.setCelular(cadMedV.getTxtCelular().getText());
            medM.setEmail(cadMedV.getTxtEmail().getText());
            medM.setCrm(cadMedV.getTxtCrm().getText());
            
            //validando se todos os campos foram preenchidos
            if(
                    medM.getNome().equals("") ||
                    medM.getCpf().equals("") ||
                    medM.getRg().equals("") ||
                    medM.getEndereco().equals("") ||
                    medM.getCelular().equals("") ||
                    medM.getEmail().equals("") ||
                    medM.getCrm().equals("")
                    ){
                JOptionPane.showMessageDialog(null, "Certifique-se de que todos os campos foram preenchidos.", "Falha no Cadastro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //convertendo datas para padrão do banco de dados
            medM.setDtNasc(dtFormat.formataPadraoBanco(cadMedV.getTxtDtNasc().getText().trim(), "Data de Nascimento"));
            medM.setDtAdmissao(dtFormat.formataPadraoBanco(cadMedV.getTxtDtAdmissao().getText().trim(), "Data de Admissão"));
            //se for nulo a data não foi informada ou falhou a conversão, então cadastro falha
            if(medM.getDtNasc() == null){
                cadMedV.getTxtDtNasc().requestFocus();
                return;
            }else{
                if(medM.getDtAdmissao() == null){
                    cadMedV.getTxtDtAdmissao().requestFocus();
                    return;
                }
            }
            
            //validando se já existe médico com mesmo cpf
            if(secME.buscarMedicoDao(medM.getCpf().trim()) != null){
                JOptionPane.showMessageDialog(null, "Já existe médico cadastrado com esse CPF.", "Falha no cadastro.", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //persistindo os dados no banco JavaDB
            secME.cadastrarMedicoDao(medM);
            
            //fechando tela de cadastro e chamando garbage collector
            cadMedV.dispose();
            System.gc();
            
            JOptionPane.showMessageDialog(null, "Médico cadastrado com sucesso.", "Sucesso no Cadastro", JOptionPane.INFORMATION_MESSAGE);
        };
        cadMedV.getBtnCadastrar().addActionListener(actionListener);
    }
}
