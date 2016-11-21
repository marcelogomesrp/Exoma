/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.usp.exoma.dao;

import br.usp.exoma.model.Variante;
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
public class VarianteDao implements Serializable {

    private static final long serialVersionUID = 1L;

    @DataRepository
    @Inject
    private EntityManager entityManager;

    private DAO<Variante> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<Variante>(this.entityManager, Variante.class);
    }

    public Variante adiciona(Variante variante) {
        return this.dao.adiciona(variante);
    }

}