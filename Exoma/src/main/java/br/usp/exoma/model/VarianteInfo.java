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
@Table(name = "variante_info")
public class VarianteInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    private int ac;
    private double af;
    private int an;
    private int dp;
    private double excessHet;
    
    private double fs;    
    private int mleac;
    private double mleaf;
    private double mq;
    private double baseQRankSum;
    private double clippingRankSum;
    private double mQRankSum;
    private double qd;
    private double readPosRankSum;
    private double sOR;
    private double vQSLOD;
    private String culprit;
    private String ann;
    
    @OneToOne
    private Variante variante = new Variante();

    
    public Variante getVariante() {
        return variante;
    }

    public void setVariante(Variante variante) {
        this.variante = variante;
    }
    

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public double getAf() {
        return af;
    }

    public void setAf(double af) {
        this.af = af;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public int getDp() {
        return dp;
    }

    public void setDp(int dp) {
        this.dp = dp;
    }

    public double getExcessHet() {
        return excessHet;
    }

    public void setExcessHet(double excessHet) {
        this.excessHet = excessHet;
    }

    public double getFs() {
        return fs;
    }

    public void setFs(double fs) {
        this.fs = fs;
    }

    public int getMleac() {
        return mleac;
    }

    public void setMleac(int mleac) {
        this.mleac = mleac;
    }

    public double getMleaf() {
        return mleaf;
    }

    public void setMleaf(double mleaf) {
        this.mleaf = mleaf;
    }

    public double getMq() {
        return mq;
    }

    public void setMq(double mq) {
        this.mq = mq;
    }

    public double getBaseQRankSum() {
        return baseQRankSum;
    }

    public void setBaseQRankSum(double baseQRankSum) {
        this.baseQRankSum = baseQRankSum;
    }

    public double getClippingRankSum() {
        return clippingRankSum;
    }

    public void setClippingRankSum(double clippingRankSum) {
        this.clippingRankSum = clippingRankSum;
    }

    public double getmQRankSum() {
        return mQRankSum;
    }

    public void setmQRankSum(double mQRankSum) {
        this.mQRankSum = mQRankSum;
    }

    public double getQd() {
        return qd;
    }

    public void setQd(double qd) {
        this.qd = qd;
    }

    public double getReadPosRankSum() {
        return readPosRankSum;
    }

    public void setReadPosRankSum(double readPosRankSum) {
        this.readPosRankSum = readPosRankSum;
    }

    public double getsOR() {
        return sOR;
    }

    public void setsOR(double sOR) {
        this.sOR = sOR;
    }

    public double getvQSLOD() {
        return vQSLOD;
    }

    public void setvQSLOD(double vQSLOD) {
        this.vQSLOD = vQSLOD;
    }

    public String getCulprit() {
        return culprit;
    }

    public void setCulprit(String culprit) {
        this.culprit = culprit;
    }

    public String getAnn() {
        return ann;
    }

    public void setAnn(String ann) {
        this.ann = ann;
    }
    
    
    
    
    
    
    
    
}
