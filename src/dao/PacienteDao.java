/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Paciente;

/**
 *
 * @author Luiz Flávio
 */
public class PacienteDao {
    
    public void persistirPaciente(Paciente pacM, EntityManager em) {
        em.getTransaction().begin();
        em.persist(pacM);
        em.getTransaction().commit();
    }

    public Paciente buscarPacientes(String cpfBusca, EntityManager em) {
        Paciente pacBusca = new Paciente();
        
        //obtendo os dados do banco JavaDB
        em.getTransaction().begin();
        Query query = em.createQuery("select p from Paciente p where tipo = 'P' and cpf = (:cpf)");
        query.setParameter("cpf", cpfBusca);
        
        List<Paciente> listaDePacientes = query.getResultList();

        for (Paciente paciente : listaDePacientes) {
            //após encontrar paciente, os campos são carregados com os dados
            if (paciente.getCpf().equals(cpfBusca)) {
                pacBusca.setId(paciente.getId());
                pacBusca.setNome(paciente.getNome().trim());
                pacBusca.setCpf(paciente.getCpf().trim());
                pacBusca.setRg(paciente.getRg().trim());
                pacBusca.setEndereco(paciente.getEndereco().trim());
                pacBusca.setCelular(paciente.getCelular().trim());
                pacBusca.setEmail(paciente.getEmail().trim());
                pacBusca.setDtNasc(paciente.getDtNasc());
                pacBusca.setConvenio(paciente.getConvenio()); 
                pacBusca.setFuma(paciente.getFuma());
                pacBusca.setBebe(paciente.getBebe());
                pacBusca.setColesterol(paciente.getColesterol());
                pacBusca.setDiabetes(paciente.getDiabetes());
                pacBusca.setAlergias(paciente.getAlergias());
                pacBusca.setProbCardiaco(paciente.getProbCardiaco());
                pacBusca.setCirurgia(paciente.getCirurgia());
                
                em.getTransaction().commit();
                return pacBusca;
            }
        }  
        em.getTransaction().commit();
        return null;
    }
    
    public void alterarPaciente(Paciente pacM, EntityManager em) {
        em.getTransaction().begin();
        Paciente pac = new Paciente();
        pac = em.find(pac.getClass(), pacM.getId());
        
        if (pac != null) {
            pac.setNome(pacM.getNome());
            pac.setCpf(pacM.getCpf());
            pac.setRg(pacM.getRg());
            pac.setDtNasc(pacM.getDtNasc());
            pac.setEndereco(pacM.getEndereco());
            pac.setCelular(pacM.getCelular());
            pac.setEmail(pacM.getEmail());
            pac.setConvenio(pacM.getConvenio());
            pac.setFuma(pacM.getFuma()); 
            pac.setBebe(pacM.getBebe()); 
            pac.setColesterol(pacM.getColesterol()); 
            pac.setDiabetes(pacM.getDiabetes()); 
            pac.setAlergias(pacM.getAlergias()); 
            pac.setProbCardiaco(pacM.getProbCardiaco()); 
            pac.setCirurgia(pacM.getCirurgia()); 
        }
        em.getTransaction().commit();
    }
    
    public void deletarPaciente(Paciente pacM, EntityManager em){
        em.getTransaction().begin();
        Paciente paciente = new Paciente();
        paciente = em.find(paciente.getClass(), pacM.getId());
        if (paciente != null) {
            em.remove(paciente);    
        }
        em.getTransaction().commit();
    }
}
