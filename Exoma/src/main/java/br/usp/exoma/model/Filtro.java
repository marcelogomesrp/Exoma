/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.usp.exoma.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "filtro")
public class Filtro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long fid;
    private String refSNP;
    private String[] selectedImpacto;
    @OneToOne
    private Analise analise;
    private Integer posicaoInicial;
    private Integer posicaoFinal;
    private String cid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getRefSNP() {
        return refSNP;
    }

    public void setRefSNP(String refSNP) {
        this.refSNP = refSNP;
    }

    @Override
    public String toString() {
        return "Filtro{" + "id=" + id + ", fid=" + fid + ", refSNP=" + refSNP + '}';
    }

    public String[] getSelectedImpacto() {
        return selectedImpacto;
    }

    public void setSelectedImpacto(String[] selectedImpacto) {
        this.selectedImpacto = selectedImpacto;
    }

    public Analise getAnalise() {
        return analise;
    }

    public void setAnalise(Analise analise) {
        this.analise = analise;
    }

    public Integer getPosicaoInicial() {
        return posicaoInicial;
    }

    public void setPosicaoInicial(Integer posicaoInicial) {
        this.posicaoInicial = posicaoInicial;
    }

    public Integer getPosicaoFinal() {
        return posicaoFinal;
    }

    public void setPosicaoFinal(Integer posicaoFinal) {
        this.posicaoFinal = posicaoFinal;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    
    
    
    
    
    
    
    
}