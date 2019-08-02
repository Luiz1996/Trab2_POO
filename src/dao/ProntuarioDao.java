/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Prontuario;

/**
 *
 * @author Vini
 */
public class ProntuarioDao {
    
    public void persistirProntuario(Prontuario prontM, EntityManager em) {
        em.getTransaction().begin();
        em.persist(prontM);
        em.getTransaction().commit();
    }
    
    public Prontuario buscarProntuario(String cpfPac, EntityManager em) {
        //obtendo os dados do banco JavaDB
        em.getTransaction().begin();
        Query query = em.createQuery("select p from Prontuario p where cpfpac = (:cpf_pac)");
        query.setParameter("cpf_pac", cpfPac);
        
        Prontuario prontM = new Prontuario();
        List<Prontuario> listaDeProntuarios = query.getResultList();

        for (Prontuario prontuario : listaDeProntuarios) {
            //após encontrar paciente, os campos são carregados com os dados
            if (prontuario.getCpfPac().equals(cpfPac)) {
                prontM.setId(prontuario.getId());
                prontM.setCpfPac(prontuario.getCpfPac());
                prontM.setTxtPront(prontuario.getTxtPront());
                
                em.getTransaction().commit();
                return prontM;
            }
        }  
        em.getTransaction().commit();
        return null; 
    }
    
    public int buscarQtdeProntuario(String cpfPac, EntityManager em) {
        //obtendo os dados do banco JavaDB
        em.getTransaction().begin();
        Query query = em.createQuery("select p from Prontuario p where cpfpac = (:cpf_pac)");
        query.setParameter("cpf_pac", cpfPac);
        
        List<Prontuario> listaDeProntuarios = query.getResultList();
        em.getTransaction().commit();
        return listaDeProntuarios.size(); 
    }
    
    public void alterarProntuario(Prontuario prontM, EntityManager em) {
        em.getTransaction().begin();
        Prontuario pront = new Prontuario();
        pront = em.find(pront.getClass(), prontM.getId());
        
        if (pront != null) {
            pront.setTxtPront(prontM.getTxtPront().trim()); 
        }
        em.getTransaction().commit();
    }
    
    public void deletarProntuario(Prontuario prontM, EntityManager em){
        em.getTransaction().begin();
        Prontuario prontuario = new Prontuario();
        prontuario = em.find(prontuario.getClass(), prontM.getId());
        if (prontuario != null) {
            em.remove(prontuario);     
        }
        em.getTransaction().commit();
    }
}
