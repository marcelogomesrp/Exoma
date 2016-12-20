/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.usp.exoma.dao;

import br.usp.exoma.model.Filtro;
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
public class FiltroDao implements Serializable {
    private static final long serialVersionUID = 1L;

    @DataRepository
    @Inject
    private EntityManager entityManager;
    
    private DAO<Filtro> dao;

    public FiltroDao() {
    }

    public FiltroDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @PostConstruct
    void init() {
        this.dao = new DAO<Filtro>(this.entityManager, Filtro.class);
    }
    
    public Filtro adiciona(Filtro filtro) {
        return this.dao.adiciona(filtro);
    }
    
    public Filtro atualiza(Filtro filtro) {
        return this.dao.atualiza(filtro);
    }
    

}