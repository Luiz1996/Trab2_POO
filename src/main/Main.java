package main;

import controller.InicioController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Medico;
import model.MedicoExecucao;
import model.SecretariaExecucao;
import view.InicioView;

/**
 *
 * @author luiz.pereira
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SaudeECia");
        EntityManager em = emf.createEntityManager();
        
        SecretariaExecucao secME = new SecretariaExecucao(em);
        MedicoExecucao medME = new MedicoExecucao(em);
        
        InicioView iniV = new InicioView();
        InicioController iniC = new InicioController(iniV, secME, medME);
    }
}
