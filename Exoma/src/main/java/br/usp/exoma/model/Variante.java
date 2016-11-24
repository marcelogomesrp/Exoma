package br.usp.exoma.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "variante")
public class Variante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Cromossomo cromossomo;
    private int cromossomoPosicao;
    private String refSNP;
    //@Lob
    //private String texto;
    @Enumerated(EnumType.STRING)
    private Nucleotideos referencia;
    @Enumerated(EnumType.STRING)
    private Nucleotideos trocado;
    private Double qualidade;
    private String filter;
    @Lob
    private String info;
    @Lob
    private String format;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cromossomo getCromossomo() {
        return cromossomo;
    }

    public void setCromossomo(Cromossomo cromossomo) {
        this.cromossomo = cromossomo;
    }

    public int getCromossomoPosicao() {
        return cromossomoPosicao;
    }

    public void setCromossomoPosicao(int chromossomoPosicao) {
        this.cromossomoPosicao = chromossomoPosicao;
    }
    
    public void setCromossomoPosicao(String chromossomoPosicao) {
        this.setCromossomoPosicao(Integer.valueOf(chromossomoPosicao));
    }

    public String getRefSNP() {
        return refSNP;
    }

    public void setRefSNP(String refSNP) {
        this.refSNP = refSNP;
    }

    public Nucleotideos getReferencia() {
        return referencia;
    }

    public void setReferencia(Nucleotideos referencia) {
        this.referencia = referencia;
    }
    
    public void setReferencia(String referencia) {
        this.setReferencia(Nucleotideos.valueOf(referencia));
    }


    public Nucleotideos getTrocado() {
        return trocado;
    }

    public void setTrocado(Nucleotideos trocado) {
        this.trocado = trocado;
    }
    
    public void setTrocado(String referencia) {
        this.setTrocado(Nucleotideos.valueOf(referencia));
    }

    public Double getQualidade() {
        return qualidade;
    }

    public void setQualidade(Double qualidade) {
        this.qualidade = qualidade;
    }
    
    public void setQualidade(String qualidade) {
        setQualidade(Double.valueOf(qualidade));
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
    
}