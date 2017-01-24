/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.usp.exoma.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author marcelo
 * http://www.ensembl.org/Homo_sapiens/Gene/Summary?g=ENSG00000188976
 */
@Entity
@Table(name = "tab_gene")
public class Gene implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  
    private String symbol;
    @Column(name = "ensembl_id")
    private String ensemblId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getEnsemblId() {
        return ensemblId;
    }

    public void setEnsemblId(String ensemblId) {
        this.ensemblId = ensemblId;
    }
    
    

}