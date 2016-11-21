package br.usp.exoma.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Marcelo Gomes de Paula
 */
@Entity
@Table(name = "analise")
public class Analise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String suspeitaDiagnostico;
    @ManyToOne
    private Usuario gestor;
    @OneToMany
    private List<Usuario> revisor;
    @Column(name = "data_cadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuspeitaDiagnostico() {
        return suspeitaDiagnostico;
    }

    public void setSuspeitaDiagnostico(String suspeitaDiagnostico) {
        this.suspeitaDiagnostico = suspeitaDiagnostico;
    }

    public Usuario getGestor() {
        return gestor;
    }

    public void setGestor(Usuario gestor) {
        this.gestor = gestor;
    }

    public List<Usuario> getRevisor() {
        return revisor;
    }

    public void setRevisor(List<Usuario> revisor) {
        this.revisor = revisor;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    
}
