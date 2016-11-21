package br.usp.exoma.dao;

import br.usp.exoma.model.Analise;
import br.usp.exoma.model.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author marcelo
 */
@RequestScoped
public class AnaliseDao implements Serializable {
    private static final long serialVersionUID = 1L;
    @DataRepository
    @Inject
    private EntityManager entityManager;
    private DAO<Analise> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<Analise>(this.entityManager, Analise.class);
    }
    
    public Analise criar(Analise analise) {
        analise.setDataCadastro(new Date());
        entityManager.persist(analise);
        return this.dao.adiciona(analise);
    }

}