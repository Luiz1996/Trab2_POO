/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Medico;

/**
 *
 * @author Luiz Flávio
 */
public class MedicoDao {
    
    public void persistirMedico(Medico medM, EntityManager em) {
        em.getTransaction().begin();
        em.persist(medM);
        em.getTransaction().commit();
    }

    public Medico buscarMedico(String cpfBusca, EntityManager em) {
        Medico medBusca = new Medico();
        
        //obtendo os dados do banco JavaDB
        em.getTransaction().begin();
        Query query = em.createQuery("select p from Medico p where tipo = 'M' and cpf = (:cpf)");
        query.setParameter("cpf", cpfBusca);
        
        List<Medico> listaDeMedicos = query.getResultList();

        for (Medico medico : listaDeMedicos) {
            //após encontrar medico, os campos são carregados com os dados
            if (medico.getCpf().equals(cpfBusca)) {
                medBusca.setId(medico.getId());
                medBusca.setNome(medico.getNome().trim());
                medBusca.setCpf(medico.getCpf().trim());
                medBusca.setRg(medico.getRg().trim());
                medBusca.setEndereco(medico.getEndereco().trim());
                medBusca.setCelular(medico.getCelular().trim());
                medBusca.setEmail(medico.getEmail().trim());
                medBusca.setDtNasc(medico.getDtNasc());
                medBusca.setCrm(medico.getCrm());
                medBusca.setDtAdmissao(medico.getDtAdmissao());
                
                em.getTransaction().commit();
                return medBusca;
            }
        } 
        em.getTransaction().commit();
        return null;
    }
    
    public void alterarMedico(Medico medM, EntityManager em) {
        em.getTransaction().begin();
        Medico med = new Medico();
        med = em.find(med.getClass(), medM.getId());
        
        if (med != null) {
            med.setNome(medM.getNome());
            med.setCpf(medM.getCpf());
            med.setRg(medM.getRg());
            med.setDtNasc(medM.getDtNasc());
            med.setEndereco(medM.getEndereco());
            med.setCelular(medM.getCelular());
            med.setEmail(medM.getEmail());
            med.setCrm(medM.getCrm());
            med.setDtAdmissao(medM.getDtAdmissao());   
        }
        em.getTransaction().commit();
    }
    
    public void deletarMedico(Medico medM, EntityManager em){
        em.getTransaction().begin();
        Medico medico = new Medico();
        medico = em.find(medico.getClass(), medM.getId());
        if (medico != null) {
            em.remove(medico);
        }
        em.getTransaction().commit();
    }
}
