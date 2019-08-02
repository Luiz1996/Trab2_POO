/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.MedicoExecucao;
import view.AltDadosAdcView;
import view.AltProntuarioView;
import view.AtendimentosMesView;
import view.AtestadoAcompanhanteView;
import view.AtestadoView;
import view.CadDadosAdcView;
import view.CadProntuarioView;
import view.ConsDadosAdcView;
import view.ConsProntuarioView;
import view.DelDadosAdcView;
import view.DelProntuarioView;
import view.MedicoView;
import view.ReceitaView;

/**
 *
 * @author Vini
 */
public class MedicoController {
    private MedicoView medV;
    private MedicoExecucao medME;
    private ActionListener actionListener;
    
    public MedicoController(MedicoView medV, MedicoExecucao medME){
        this.medV = medV;
        this.medME = medME;
        
        btnCadDadosAdcPaciente();
        btnConsDadosAdcPaciente();
        btnAltDadosAdcPaciente();
        btnDelDadosAdcPaciente();
        btnCadProntuarioPaciente();
        btnConsProntuarioPaciente();
        btnAltProntuarioPaciente();
        btnDelProntuarioPaciente();
        btnAtendimentosMes();
        btnReceituarioMedico();
        btnAtestadoPaciente();
        btnAtestadoAcompanhante();
    }
    
    private void btnCadDadosAdcPaciente() {
        actionListener = (ActionEvent ae) -> {
            CadDadosAdcView cadDadosAdcV = new CadDadosAdcView();
            CadDadosAdcController cadDadosAdcC = new CadDadosAdcController(cadDadosAdcV, medME);
        };    
        medV.getBtnCadDadosAdc().addActionListener(actionListener);
    }
    
    private void btnConsDadosAdcPaciente() {
        actionListener = (ActionEvent ae) -> {
            ConsDadosAdcView consDadosAdcV = new ConsDadosAdcView();
            ConsDadosAdcController consDadosAdcC = new ConsDadosAdcController(consDadosAdcV, medME);
        };    
        medV.getBtnConsDadosAdc().addActionListener(actionListener);
    }
    
    private void btnAltDadosAdcPaciente() {
        actionListener = (ActionEvent ae) -> {
            AltDadosAdcView altDadosAdcV = new AltDadosAdcView();
            AltDadosAdcController altDadosAdcC = new AltDadosAdcController(altDadosAdcV, medME);
        };    
        medV.getBtnAltDadosAdc().addActionListener(actionListener);
    }
    
    private void btnDelDadosAdcPaciente() {
        actionListener = (ActionEvent ae) -> {
            DelDadosAdcView delDadosAdcV = new DelDadosAdcView();
            DelDadosAdcController delDadosAdcC = new DelDadosAdcController(delDadosAdcV, medME);
        };    
        medV.getBtnDelDadosAdc().addActionListener(actionListener);
    }
    
    private void btnCadProntuarioPaciente() {
        actionListener = (ActionEvent ae) -> {
            CadProntuarioView cadProntV = new CadProntuarioView();
            CadProntuarioController cadProntC = new CadProntuarioController(cadProntV, medME);
        };    
        medV.getBtnCadPront().addActionListener(actionListener);
    }
    
    private void btnConsProntuarioPaciente() {
        actionListener = (ActionEvent ae) -> {
            ConsProntuarioView consProntV = new ConsProntuarioView();
            ConsProntuarioController consProntC = new ConsProntuarioController(consProntV, medME);
        };    
        medV.getBtnConsPront().addActionListener(actionListener);
    }
    
    private void btnAltProntuarioPaciente() {
        actionListener = (ActionEvent ae) -> {
            AltProntuarioView altProntV = new AltProntuarioView();
            AltProntuarioController altProntC = new AltProntuarioController(altProntV, medME);
        };    
        medV.getBtnAltPront().addActionListener(actionListener);
    }
    
    private void btnDelProntuarioPaciente() {
        actionListener = (ActionEvent ae) -> {
            DelProntuarioView delProntV = new DelProntuarioView();
            DelProntuarioController delProntC = new DelProntuarioController(delProntV, medME);
        };    
        medV.getBtnDelPront().addActionListener(actionListener);
    }
    
    private void btnAtendimentosMes() {
        actionListener = (ActionEvent ae) -> {
            AtendimentosMesView atendMesV = new AtendimentosMesView();
            AtendimentosMesController atendMesC = new AtendimentosMesController(atendMesV, medME);
        };    
        medV.getBtnAtendMes().addActionListener(actionListener);
    }
    
    private void btnReceituarioMedico() {
        actionListener = (ActionEvent ae) -> {
            ReceitaView recV = new ReceitaView();
            ReceitaController recC = new ReceitaController(recV, medME);
        };    
        medV.getBtnReceitas().addActionListener(actionListener);
    }
    
    private void btnAtestadoPaciente() {
        actionListener = (ActionEvent ae) -> {
            AtestadoView atestV = new AtestadoView();
            AtestadoController atestC = new AtestadoController(atestV, medME);
        };    
        medV.getBtnAtestados().addActionListener(actionListener);
    }
    
    private void btnAtestadoAcompanhante() {
        actionListener = (ActionEvent ae) -> {
            AtestadoAcompanhanteView atestAcompV = new AtestadoAcompanhanteView();
            AtestadoAcompanhanteController atestAcompC = new AtestadoAcompanhanteController(atestAcompV, medME);
        };    
        medV.getBtnAtestAcomp().addActionListener(actionListener);
    }
}
