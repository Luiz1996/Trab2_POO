/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.SecretariaExecucao;
import view.AltConsultaView;
import view.AltMedicoView;
import view.AltPacienteView;
import view.CadConsultaView;
import view.CadMedicoView;
import view.CadPacienteView;
import view.ConsConsultaView;
import view.ConsMedicoView;
import view.ConsPacienteView;
import view.ConsConsultaAmanhaView;
import view.DelConsultaView;
import view.DelMedicoView;
import view.DelPacienteView;
import view.SecretariaView;

/**
 *
 * @author luiz.pereira
 */
public class SecretariaController {
    private SecretariaView secV;
    private SecretariaExecucao secME;
    private ActionListener actionListener;
    
    public SecretariaController(SecretariaView secV, SecretariaExecucao secME) {
        this.secV = secV;
        this.secME = secME;
        btnCadPaciente();
        btnConsPaciente();
        btnAltPaciente();
        btnDelPaciente();
        btnCadMedico();
        btnConsMedico();
        btnAltMedico();
        btnDelMedico();
        btnCadConsulta();
        btnConsConsulta();
        btnAltConsulta();
        btnDelConsulta();
        btnConsultasDeAmanha();
    }
    
    private void btnCadPaciente() {
        actionListener = (ActionEvent ae) -> {
            CadPacienteView cadPacV = new CadPacienteView();
            CadPacienteController cadPacC = new CadPacienteController(cadPacV, secME);
        };    
        secV.getBtnCadPac().addActionListener(actionListener);
    }
    
    private void btnConsPaciente() {
        actionListener = (ActionEvent ae) -> {
            ConsPacienteView consPacV = new ConsPacienteView();
            ConsPacienteController consPacC = new ConsPacienteController(consPacV, secME);
        };    
        secV.getBtnConsPac().addActionListener(actionListener);
    }
    
    private void btnAltPaciente() {
        actionListener = (ActionEvent ae) -> {
            AltPacienteView altPacV = new AltPacienteView();
            AltPacienteController altPacC = new AltPacienteController(altPacV, secME);
        };    
        secV.getBtnAltPac().addActionListener(actionListener);
    }
    
    private void btnDelPaciente() {
        actionListener = (ActionEvent ae) -> {
            DelPacienteView delPacV = new DelPacienteView();
            DelPacienteController delPacC = new DelPacienteController(delPacV, secME);
        };    
        secV.getBtnDelPac().addActionListener(actionListener);
    }
    
    private void btnCadMedico() {
        actionListener = (ActionEvent ae) -> {
            CadMedicoView cadMedV = new CadMedicoView();
            CadMedicoController cadMedC = new CadMedicoController(cadMedV, secME);
        };    
        secV.getBtnCadMed().addActionListener(actionListener);
    }
    
    private void btnConsMedico() {
        actionListener = (ActionEvent ae) -> {
            ConsMedicoView consMedV = new ConsMedicoView();
            ConsMedicoController consMedC = new ConsMedicoController(consMedV, secME);
        };    
        secV.getBtnConsMed().addActionListener(actionListener);
    }
    
    private void btnAltMedico() {
        actionListener = (ActionEvent ae) -> {
            AltMedicoView altMedV = new AltMedicoView();
            AltMedicoController altMedC = new AltMedicoController(altMedV, secME);
        };    
        secV.getBtnAltMed().addActionListener(actionListener);
    }
    
    private void btnDelMedico() {
        actionListener = (ActionEvent ae) -> {
            DelMedicoView delMedV = new DelMedicoView();
            DelMedicoController delMedC = new DelMedicoController(delMedV, secME);
        };    
        secV.getBtnDelMed().addActionListener(actionListener);
    }
    
    private void btnCadConsulta() {
        actionListener = (ActionEvent ae) -> {
            CadConsultaView cadConV = new CadConsultaView();
            CadConsultaController cadConC = new CadConsultaController(cadConV, secME);
        };    
        secV.getBtnCadCon().addActionListener(actionListener);
    }
    
    private void btnConsConsulta() {
        actionListener = (ActionEvent ae) -> {
            ConsConsultaView consConV = new ConsConsultaView();
            ConsConsultaController consConC = new ConsConsultaController(consConV, secME);
        };    
        secV.getBtnConsCon().addActionListener(actionListener);
    }
    
    private void btnAltConsulta() {
        actionListener = (ActionEvent ae) -> {
            AltConsultaView altConV = new AltConsultaView();
            AltConsultaController altConC = new AltConsultaController(altConV, secME);
        };    
        secV.getBtnAltCon().addActionListener(actionListener);
    }
    
    private void btnDelConsulta() {
        actionListener = (ActionEvent ae) -> {
            DelConsultaView delConV = new DelConsultaView();
            DelConsultaController delConC = new DelConsultaController(delConV, secME);
        };    
        secV.getBtnDelCon().addActionListener(actionListener);
    }
    
    private void btnConsultasDeAmanha() {
        actionListener = (ActionEvent ae) -> {
            ConsConsultaAmanhaView consAmanhaConV = new ConsConsultaAmanhaView();
            ConsConsultaAmanhaController delConC = new ConsConsultaAmanhaController(consAmanhaConV, secME);
        };    
        secV.getBtnConsAmanha().addActionListener(actionListener);
    }
}
