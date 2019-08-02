package model;

import controller.ExcelController;
import dao.ConsultaDao;
import dao.MedicoDao;
import dao.PacienteDao;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

public class SecretariaExecucao{
    private EntityManager em;
    private PacienteDao pacD = new PacienteDao();
    private MedicoDao medD = new MedicoDao();
    private ConsultaDao consD = new ConsultaDao();
    private ExcelController excC = new ExcelController();

    public SecretariaExecucao(){}
    
    public SecretariaExecucao(EntityManager em) {
        this.em = em;
    }

    public void cadastrarPacienteDao(Paciente pacM) {
        try {
            pacD.persistirPaciente(pacM, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public Paciente buscarPacienteDao(String cpfPac){
        try {
            return pacD.buscarPacientes(cpfPac, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return null;
        }
    }
    
    public void alterarPacienteDao(Paciente pacM){
        try {
            pacD.alterarPaciente(pacM, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public void deletarPacienteDao(Paciente pacM){
        try {
            pacD.deletarPaciente(pacM, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public void cadastrarMedicoDao(Medico medM) {
        try {
            medD.persistirMedico(medM, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public Medico buscarMedicoDao(String cpfMed){
        try {
            return medD.buscarMedico(cpfMed, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return null;
        }
    }
    
    public void alterarMedicoDao(Medico medM){
        try {
            medD.alterarMedico(medM, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public void deletarMedicoDao(Medico medM){
        try {
            medD.deletarMedico(medM, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public void cadastrarConsultaDao(Consulta consM) {
        try {
            consD.persistirConsulta(consM, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public List<Consulta> buscarConsultasDao(String cpfPac, String cpfMed){
        try {
            return consD.buscarConsultas(cpfPac, cpfMed, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return null;
        }
    }
    
    public Consulta buscarConsultasPorIdDao(Integer idCons){
        try {
            return consD.buscarConsultasPorId(idCons, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return null;
        }
    }
    
    public List<Consulta> buscarConsultasAmanhaDao(Calendar dtAmanhaInicio, Calendar dtAmanhaFim){
        try {
            return consD.buscarConsultasAmanha(dtAmanhaInicio, dtAmanhaFim, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return null;
        }
    }
    
    public void alterarConsultaDao(Consulta consM){
        try {
            consD.alterarConsulta(consM, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public void deletarConsultaDao(Consulta consM){
        try {
            consD.deletarConsulta(consM, em);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Close your application!\nError: ".concat(e.getMessage().trim()), "Falha ao conectar-se com banco de dados.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
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
