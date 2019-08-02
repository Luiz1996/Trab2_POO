package model;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author luiz.pereira
 */
@Entity
@DiscriminatorValue(value = "M")
public class Medico extends Pessoa {

    @Column(name = "CRM", length = 20)
    private String crm;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dtAdmissao;

    public Medico() {}

    public Medico(String crm, Calendar dtAdmissao, Integer id, String cpf, String rg, String nome, String endereco, Calendar dtNasc, String celular, String email) {
        super(id, cpf, rg, nome, endereco, dtNasc, celular, email);
        this.crm = crm;
        this.dtAdmissao = dtAdmissao;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Calendar getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Calendar dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }
}
