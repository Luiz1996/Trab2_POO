/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Vini
 */   
@Entity
@Table(name = "PRONTUARIO")
public class Prontuario implements Serializable{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CPFPAC", length = 15)
    private String cpfPac; 
    
    @Column(name = "TEXTOPRONT", length = 10000)
    private String txtPront; 

    public Prontuario(Integer id, String cpfPac, String txtPront) {
        this.id = id;
        this.cpfPac = cpfPac;
        this.txtPront = txtPront;
    }
    
    public Prontuario(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpfPac() {
        return cpfPac;
    }

    public void setCpfPac(String cpfPac) {
        this.cpfPac = cpfPac;
    }

    public String getTxtPront() {
        return txtPront;
    }

    public void setTxtPront(String txtPront) {
        this.txtPront = txtPront;
    }
}
