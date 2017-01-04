/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.usp.exoma.dao;

import br.usp.exoma.model.VarianteInfo;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author marcelo
 */
@RequestScoped
public class VarianteInfoDao implements Serializable {

    private static final long serialVersionUID = 1L;

    @DataRepository
    @Inject
    private EntityManager entityManager;

    private DAO<VarianteInfo> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<VarianteInfo>(this.entityManager, VarianteInfo.class);
    }
    
    public VarianteInfo adiciona(VarianteInfo info) {
        return this.dao.adiciona(info);
    }
    
}
