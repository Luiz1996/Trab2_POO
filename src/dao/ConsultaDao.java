/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Consulta;

/**
 *
 * @author Luiz Flávio
 */
public class ConsultaDao {

    public void persistirConsulta(Consulta conM, EntityManager em) {
        em.getTransaction().begin();
        em.persist(conM);
        em.getTransaction().commit();
    }

    public List<Consulta> buscarConsultas(String cpfPac, String cpfMed, EntityManager em) {
        //obtendo os dados do banco JavaDB
        em.getTransaction().begin();
        Query query = em.createQuery("select c from Consulta c where cpfmed = (:cpf_med) and cpfpac = (:cpf_pac)");
        query.setParameter("cpf_med", cpfMed);
        query.setParameter("cpf_pac", cpfPac);
        
        List<Consulta> listaDeConsultas = query.getResultList();

        if(listaDeConsultas.size() > 0){
            em.getTransaction().commit();
            return listaDeConsultas;
        }else{
            em.getTransaction().commit();
            return null;
        }  
    }

    public void deletarConsulta(Consulta conM, EntityManager em){
        em.getTransaction().begin();
        Consulta consulta = new Consulta();
        consulta = em.find(consulta.getClass(), conM.getId());
        if (consulta != null) {
            em.remove(consulta);     
        }
        em.getTransaction().commit();
    }

    public Consulta buscarConsultasPorId(Integer idBusca, EntityManager em) {
        Consulta conM = new Consulta();

        //obtendo os dados do banco JavaDB
        em.getTransaction().begin();
        Query query = em.createQuery("select c from Consulta c where id = (:id)");
        query.setParameter("id", idBusca);
        
        List<Consulta> listaDeConsultas = query.getResultList();

        if(listaDeConsultas.size() > 0){
            conM = listaDeConsultas.get(0);
            em.getTransaction().commit();
            return conM;
        }else{
            em.getTransaction().commit();
            return null;
        } 
    }
    
    public void alterarConsulta(Consulta conM, EntityManager em) {
        em.getTransaction().begin();
        Consulta con = new Consulta();
        con = em.find(con.getClass(), conM.getId());
        
        if (con != null) {
            con.setDtConsulta(conM.getDtConsulta());   
        }
        em.getTransaction().commit();
    }
    
    public List<Consulta> buscarConsultasAmanha(Calendar dtAmanhaInicio, Calendar dtAmanhaFim, EntityManager em) {
        //obtendo os dados do banco JavaDB
        em.getTransaction().begin();
        Query query = em.createQuery("select c from Consulta c where dtconsulta between (:dtAmanhaInicio) and (:dtAmanhaFim)");
        query.setParameter("dtAmanhaInicio", dtAmanhaInicio);
        query.setParameter("dtAmanhaFim", dtAmanhaFim);
        
        List<Consulta> listaDeConsultas = query.getResultList();

        if(listaDeConsultas.size() > 0){
            em.getTransaction().commit();
            return listaDeConsultas;
        }else{
            em.getTransaction().commit();
            return null;
        }  
    }
    
    public List<Consulta> buscarAtendimentosMes(Calendar dtInicio, Calendar dtFim, String cpfMed, EntityManager em) {
        //obtendo os dados do banco JavaDB
        em.getTransaction().begin();
        Query query = em.createQuery("select c from Consulta c where (dtconsulta between (:dtInicio) and (:dtFim)) and cpfmed = (:cpf_med)");
        query.setParameter("dtInicio", dtInicio);
        query.setParameter("dtFim", dtFim);
        query.setParameter("cpf_med", cpfMed);
        
        List<Consulta> listaDeConsultas = query.getResultList();

        if(listaDeConsultas.size() > 0){
            em.getTransaction().commit();
            return listaDeConsultas;
        }else{
            em.getTransaction().commit();
            return null;
        }  
    }
}
