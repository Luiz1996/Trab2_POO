/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Luiz Flávio
 */
@Entity
@Table(name = "CONSULTA")
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "CPFMED", length = 15)
    private String cpfMed;
    
    @Column(name = "CPFPAC", length = 15)
    private String cpfPac;

    @Temporal(TemporalType.TIMESTAMP) 
    @Column(name = "DTCONSULTA")
    private Calendar dtConsulta;
    
    @Column(name = "TIPOCONSULTA")
    private int tipoConsulta;
    
    @Transient
    private String nomePac;
    
    @Transient
    private Calendar dtNascPac;
    
    @Transient
    private String enderecoPac;
    
    @Transient
    private String nomeMed;
    
    @Transient
    private Calendar dtNascMed;
    
    @Transient
    private String crm;
    
    @Transient
    private String tpConsulta;
    
    @Transient
    private String emailPac;
    
    @Transient
    private String celularPac;
            
    public Consulta(){
    
    }

    public Consulta(Integer id, String cpfMed, String cpfPac, Calendar dtConsulta, int tipoConsulta) {
        this.id = id;
        this.cpfMed = cpfMed;
        this.cpfPac = cpfPac;
        this.dtConsulta = dtConsulta;
        this.tipoConsulta = tipoConsulta;
    }

    public Consulta(Integer id, String cpfMed, String cpfPac, Calendar dtConsulta, int tipoConsulta, String nomePac, Calendar dtNascPac, String enderecoPac, String nomeMed, Calendar dtNascMed, String crm) {
        this.id = id;
        this.cpfMed = cpfMed;
        this.cpfPac = cpfPac;
        this.dtConsulta = dtConsulta;
        this.tipoConsulta = tipoConsulta;
        this.nomePac = nomePac;
        this.dtNascPac = dtNascPac;
        this.enderecoPac = enderecoPac;
        this.nomeMed = nomeMed;
        this.dtNascMed = dtNascMed;
        this.crm = crm;
    }

    public Consulta(Integer id, Calendar dtConsulta, String nomePac, Calendar dtNascPac, String enderecoPac, String nomeMed, Calendar dtNascMed, String crm, String tpConsulta) {
        this.id = id;
        this.dtConsulta = dtConsulta;
        this.nomePac = nomePac;
        this.dtNascPac = dtNascPac;
        this.enderecoPac = enderecoPac;
        this.nomeMed = nomeMed;
        this.dtNascMed = dtNascMed;
        this.crm = crm;
        this.tpConsulta = tpConsulta;
    }
    
    public Consulta(Integer id, Calendar dtConsulta, String nomePac, Calendar dtNascPac, String enderecoPac, String nomeMed, Calendar dtNascMed, String crm, String tpConsulta, String emailPac, String celularPac) {
        this.id = id;
        this.dtConsulta = dtConsulta;
        this.nomePac = nomePac;
        this.dtNascPac = dtNascPac;
        this.enderecoPac = enderecoPac;
        this.nomeMed = nomeMed;
        this.dtNascMed = dtNascMed;
        this.crm = crm;
        this.tpConsulta = tpConsulta;
        this.emailPac = emailPac;
        this.celularPac = celularPac;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpfMed() {
        return cpfMed;
    }

    public void setCpfMed(String cpfMed) {
        this.cpfMed = cpfMed;
    }

    public String getCpfPac() {
        return cpfPac;
    }

    public void setCpfPac(String cpfPac) {
        this.cpfPac = cpfPac;
    }

    public Calendar getDtConsulta() {
        return dtConsulta;
    }

    public void setDtConsulta(Calendar dtConsulta) {
        this.dtConsulta = dtConsulta;
    }

    public int getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(int tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getNomePac() {
        return nomePac;
    }

    public void setNomePac(String nomePac) {
        this.nomePac = nomePac;
    }

    public Calendar getDtNascPac() {
        return dtNascPac;
    }

    public void setDtNascPac(Calendar dtNascPac) {
        this.dtNascPac = dtNascPac;
    }

    public String getEnderecoPac() {
        return enderecoPac;
    }

    public void setEnderecoPac(String enderecoPac) {
        this.enderecoPac = enderecoPac;
    }

    public String getNomeMed() {
        return nomeMed;
    }

    public void setNomeMed(String nomeMed) {
        this.nomeMed = nomeMed;
    }

    public Calendar getDtNascMed() {
        return dtNascMed;
    }

    public void setDtNascMed(Calendar dtNascMed) {
        this.dtNascMed = dtNascMed;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getTpConsulta() {
        return tpConsulta;
    }

    public void setTpConsulta(String tpConsulta) {
        this.tpConsulta = tpConsulta;
    }

    public String getEmailPac() {
        return emailPac;
    }

    public void setEmailPac(String emailPac) {
        this.emailPac = emailPac;
    }

    public String getCelularPac() {
        return celularPac;
    }

    public void setCelularPac(String celularPac) {
        this.celularPac = celularPac;
    }
}
