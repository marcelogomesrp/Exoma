package br.usp.exoma.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    //@Enumerated(EnumType.STRING)
    private String referencia;
    //@Enumerated(EnumType.STRING)
    private String trocado;
    private Double qualidade;
    private String filter;
    @Lob
    private String info;
    @Lob
    private String format;    
    @ManyToMany
    private List<Analise> analises = new ArrayList<Analise>();
    @OneToOne(mappedBy = "variante")
    private VarianteInfo varianteInfo;
    

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

    public List<Analise> getAnalises() {
        return analises;
    }

    public void setAnalises(List<Analise> analises) {
        this.analises = analises;
    }
    
    public void addAnalise(Analise analise){
        this.analises.add(analise);
    }

    public VarianteInfo getVarianteInfo() {
        return varianteInfo;
    }

    public void setVarianteInfo(VarianteInfo varianteInfo) {
        this.varianteInfo = varianteInfo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTrocado() {
        return trocado;
    }

    public void setTrocado(String trocado) {
        this.trocado = trocado;
    }
    
    
    

    @Override
    public String toString() {
        return "Variante{" + "id=" + id + ", cromossomo=" + cromossomo + ", cromossomoPosicao=" + cromossomoPosicao + ", refSNP=" + refSNP + ", referencia=" + referencia + ", trocado=" + trocado + ", qualidade=" + qualidade + ", filter=" + filter + ", info=" + info + ", format=" + format + ", analises=" + analises + '}';
    }
    
    
    
}