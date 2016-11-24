package br.usp.exoma.dao;

import br.usp.exoma.model.Analise;
import br.usp.exoma.model.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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

    @SuppressWarnings("unchecked")
    public List<Analise> PesquisarPorGestor(Usuario gestor) {
        String ql = "SELECT a FROM Analise a WHERE a.gestor = :gestor";
        List<Analise> results = entityManager.createQuery(ql).setParameter(
                "gestor", gestor)
                .getResultList();
        return results;
    }
    
    public List<Analise> PesquisarTodos(){
        return this.dao.listaTodos();
    }
    
    

}