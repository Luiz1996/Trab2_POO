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
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.SecretariaExecucao;
import service.FormataDatas;
import view.CadConsultaView;

/**
 *
 * @author Luiz Flávio
 */
public class CadConsultaController {
    private SecretariaExecucao secME;
    private CadConsultaView cadConV = new CadConsultaView();
    private FormataDatas dtFormat = new FormataDatas();
    private ActionListener actionListener;
    private FocusListener focusListener;
    
    public CadConsultaController(CadConsultaView cadConV, SecretariaExecucao secME) {
        this.cadConV = cadConV;
        cadConV.setVisible(true);
        this.cadConV.getBtnRadNormal().setSelected(true);
        this.secME = secME;
        cadastrarConsulta();
        cpfPacFocusLost();
        cpfMedFocusLost();
    }
    
    private void cadastrarConsulta() {
        actionListener = (ActionEvent ae) -> {
            Consulta cadConM = new Consulta();
            
            //validando se os campos CPFs não foram preenchidos
            if(
                    cadConV.getTxtCpfMed().getText().trim().equals("") ||
                    cadConV.getTxtCpfPac().getText().trim().equals("")
                    ){
                JOptionPane.showMessageDialog(null, "Certifique-se de que todos os campos foram preenchidos.", "Falha no Cadastro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //setando os dados no objeto Consulta
            cadConM.setCpfMed(cadConV.getTxtCpfMed().getText().trim());
            cadConM.setCpfPac(cadConV.getTxtCpfPac().getText().trim());
            cadConM.setDtConsulta(dtFormat.formataPadraoBancoComHora(cadConV.getTxtDtHora().getText(), "Data e Hora da Consulta"));
            //se for nulo a data não foi informada ou falhou a conversão, então cadastro falha
            if(cadConM.getDtConsulta() == null){
                cadConV.getTxtDtHora().requestFocus();
                return;
            }
            
            //setando tipo de consulta
            if(cadConV.getBtnRadNormal().isSelected()){
                cadConM.setTipoConsulta(0);
            }else{
                if(cadConV.getBtnRadRetorno().isSelected()){
                    cadConM.setTipoConsulta(1);
                }
            }
            
            //persistindo os dados no banco JavaDB
            secME.cadastrarConsultaDao(cadConM);
            
            //fechando tela de cadastro e chamando garbage collector
            cadConV.dispose();
            System.gc();
            
            JOptionPane.showMessageDialog(null, "Consulta cadastrada com sucesso.", "Sucesso no Cadastro", JOptionPane.INFORMATION_MESSAGE);
        };
        cadConV.getBtnCadastrar().addActionListener(actionListener);
    } 
    
    @SuppressWarnings("empty-statement")
    private void cpfPacFocusLost() {
        focusListener = new FocusListener()  {
            @Override
            public void focusGained(FocusEvent e) {
                //não necessita implementação
            }

            @Override
            public void focusLost(FocusEvent e) {
                
                if(!cadConV.isVisible()){
                    return;
                }
                
                Paciente pacM = new Paciente();
                pacM = secME.buscarPacienteDao(cadConV.getTxtCpfPac().getText());
                  
                if(pacM == null){
                    JOptionPane.showMessageDialog(null, "Nenhum paciente com o CPF informado.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                    cadConV.getTxtCpfPac().setText("");
                    cadConV.getTxtCpfPac().requestFocus();
                    return;
                }else{
                    cadConV.getTxtCpfMed().requestFocus();
                }
                
                cadConV.getTxtNomePac().setText(pacM.getNome().trim());
                cadConV.getTxtDtNascPac().setText(dtFormat.formataPadraoBrasil(pacM.getDtNasc(), "Data de Nascimento"));     
            }
        };
        cadConV.getTxtCpfPac().addFocusListener(focusListener);
    } 
    
    @SuppressWarnings("empty-statement")
    private void cpfMedFocusLost() {                                    
        focusListener = new FocusListener()  {
            @Override
            public void focusGained(FocusEvent e) {
                //não necessita implementação
            }

            @Override
            public void focusLost(FocusEvent e) {
                Medico medM = new Medico();
                medM = secME.buscarMedicoDao(cadConV.getTxtCpfMed().getText()); 
                
                if(medM == null){
                    JOptionPane.showMessageDialog(null, "Nenhum médico com o CPF informado.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                    cadConV.getTxtCpfMed().setText("");
                    cadConV.getTxtCpfMed().requestFocus();
                    return;
                }else{
                    cadConV.getTxtDtHora().requestFocus();
                }
                
                cadConV.getTxtNomeMed().setText(medM.getNome().trim());
                cadConV.getTxtDtNascMed().setText(dtFormat.formataPadraoBrasil(medM.getDtNasc(), "Data de Nascimento"));     
                cadConV.getTxtCrm().setText(medM.getCrm().trim());
            }
        };
        cadConV.getTxtCpfMed().addFocusListener(focusListener);
    }
}
