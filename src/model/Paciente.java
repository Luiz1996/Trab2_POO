package model;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author luiz.pereira
 */

@Entity
@DiscriminatorValue(value = "P")
public class Paciente extends Pessoa{
    
    @Column(name = "CONVENIO", nullable = true)
    private int convenio;
    
    @Column(name = "FUMA")
    private int fuma;
    
    @Column(name = "BEBE")
    private int bebe;
    
    @Column(name = "COLESTEROL")
    private int colesterol;
    
    @Column(name = "DIABETES")
    private int diabetes;
    
    @Column(name = "ALERGIAS")
    private int alergias;
    
    @Column(name = "PROBCARDIACO")
    private int probCardiaco;
    
    @Column(name = "CIRURGIA")
    private int cirurgia;

    public Paciente(){
        
    }
    
    public Paciente(int convenio, int fuma, int bebe, int colesterol, int diabetes, int alergias, int probCardiaco, int cirurgia, Integer id, String cpf, String rg, String nome, String endereco, Calendar dtNasc, String celular, String email) {
        super(id, cpf, rg, nome, endereco, dtNasc, celular, email);
        this.convenio = convenio;
        this.fuma = fuma;
        this.bebe = bebe;
        this.colesterol = colesterol;
        this.diabetes = diabetes;
        this.alergias = alergias;
        this.probCardiaco = probCardiaco;
        this.cirurgia = cirurgia;
    }

    public int getConvenio() {
        return convenio;
    }

    public void setConvenio(int convenio) {
        this.convenio = convenio;
    }

    public int getFuma() {
        return fuma;
    }

    public void setFuma(int fuma) {
        this.fuma = fuma;
    }

    public int getBebe() {
        return bebe;
    }

    public void setBebe(int bebe) {
        this.bebe = bebe;
    }

    public int getColesterol() {
        return colesterol;
    }

    public void setColesterol(int colesterol) {
        this.colesterol = colesterol;
    }

    public int getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(int diabetes) {
        this.diabetes = diabetes;
    }

    public int getAlergias() {
        return alergias;
    }

    public void setAlergias(int alergias) {
        this.alergias = alergias;
    }

    public int getProbCardiaco() {
        return probCardiaco;
    }

    public void setProbCardiaco(int probCardiaco) {
        this.probCardiaco = probCardiaco;
    }

    public int getCirurgia() {
        return cirurgia;
    }

    public void setCirurgia(int cirurgia) {
        this.cirurgia = cirurgia;
    } 
}
