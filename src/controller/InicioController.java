package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.MedicoExecucao;
import model.SecretariaExecucao;
import view.InicioView;
import view.MedicoView;
import view.SecretariaView;

/**
 *
 * @author luiz.pereira
 */
public class InicioController {
    private SecretariaExecucao secME;
    private MedicoExecucao medME;
    private InicioView iniV;
    private ActionListener actionListener;

    public InicioController(InicioView iniV, SecretariaExecucao secME, MedicoExecucao medME) {
        this.iniV = iniV;
        this.secME = secME;
        this.medME = medME;
        
        btnSecretaria();
        btnMedico();
    }
    
    private void btnSecretaria() {
        actionListener = (ActionEvent ae) -> {
            SecretariaView secV = new SecretariaView();
            SecretariaController secC = new SecretariaController(secV, secME);
        };     
        iniV.getBtnSec().addActionListener(actionListener);
    }
    
    private void btnMedico() {
        actionListener = (ActionEvent ae) -> {
            MedicoView medV = new MedicoView();
            MedicoController medC = new MedicoController(medV, medME);
        };
        iniV.getBtnMed().addActionListener(actionListener);
    }
}
