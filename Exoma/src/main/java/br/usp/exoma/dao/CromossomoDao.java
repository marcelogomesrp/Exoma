package br.usp.exoma.dao;


import br.usp.exoma.model.Cromossomo;
import java.io.Serializable;
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
public class CromossomoDao implements Serializable {

    private static final long serialVersionUID = 1L;

    @DataRepository
    @Inject
    private EntityManager entityManager;

    private DAO<Cromossomo> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<Cromossomo>(this.entityManager, Cromossomo.class);
    }

    public Cromossomo adiciona(Cromossomo cromossomo) {
        System.out.println("aeee");
        return this.dao.adiciona(cromossomo);
    }
    
    @SuppressWarnings("unchecked")
    public Cromossomo buscarPorNome(String nome) {
        String ql = "SELECT c FROM Cromossomo c WHERE c.nome = :nome";
        List<Cromossomo> results = entityManager.createQuery(ql).setParameter(
                "nome", nome)
                .getResultList();
         return results.isEmpty() ? null : results.get(0);
    }
    
    
}