/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ExcelController;
import dao.ConsultaDao;
import dao.MedicoDao;
import dao.PacienteDao;
import dao.ProntuarioDao;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author luiz.pereira
 */
public class MedicoExecucao{
    private EntityManager em;
    private PacienteDao pacD = new PacienteDao();
    private ProntuarioDao prontD = new ProntuarioDao();
    private MedicoDao medD = new MedicoDao();
    private ConsultaDao consD = new ConsultaDao();
    private ExcelController excC = new ExcelController();
    
    public MedicoExecucao(EntityManager em) {
        this.em = em;
    }
    
    public Paciente buscarPacienteDao(String cpfPac) {
        try {
            return pacD.buscarPacientes(cpfPac, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return null;
        }
    }

    public void alterarPacienteDao(Paciente pacM) {
        try {
            pacD.alterarPaciente(pacM, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public Medico buscarMedicoDao(String cpfMed) {
        try {
            return medD.buscarMedico(cpfMed, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return null;
        }
    }
    
    public void cadastrarProntuarioDao(Prontuario prontM) {
        try {
            prontD.persistirProntuario(prontM, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public int buscarProntuarioQuantidadeDao(String cpfPac) {
        try {
            return prontD.buscarQtdeProntuario(cpfPac, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return 0;
        }
    }
    
    public Prontuario buscarProntuarioDao(String cpfPac) {
        try {
            return prontD.buscarProntuario(cpfPac, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return null;
        }
    }
    
    public void alterarProntuarioDao(Prontuario prontM) {
        try {
            prontD.alterarProntuario(prontM, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public void deletarProntuarioDao(Prontuario prontM) {
        try {
            prontD.deletarProntuario(prontM, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public List<Consulta> buscarAtendimentosMesDao(Calendar dtInicio, Calendar dtFim, String cpfMed) {
        try {
            return consD. buscarAtendimentosMes(dtInicio, dtFim, cpfMed, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return null;
        }
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    } 

    public ExcelController getExcC() {
        return excC;
    }

    public void setExcC(ExcelController excC) {
        this.excC = excC;
    }
}
