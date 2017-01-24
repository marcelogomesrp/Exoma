package br.usp.exoma.dao;
//dgpinheiro
//http://www.disgenet.org/web/DisGeNET/menu;jsessionid=10exzi5x2nwrk19tmhav6p8628
//http://ctdbase.org/help/goDiseaseDetailHelp.jsp
import br.usp.exoma.model.Gene;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;


@RequestScoped
public class GeneDao implements Serializable {
    private static final long serialVersionUID = 1L;

    @DataRepository
    @Inject
    private EntityManager entityManager;
    
    private DAO<Gene> dao;

    public GeneDao() {
    }

    public GeneDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @PostConstruct
    void init() {
        this.dao = new DAO<Gene>(this.entityManager, Gene.class);
    }
    
    public Gene adiciona(Gene gene) {
        return this.dao.adiciona(gene);
    }
    
    @SuppressWarnings("unchecked")
    public Gene buscarPorSymbol(String symbol) {
        String ql = "SELECT g FROM Gene g WHERE g.symbol = :symbol";
        List<Gene> results = entityManager.createQuery(ql).setParameter(
                "symbol", symbol)
                .getResultList();
        return results.isEmpty() ? null : results.get(0);
    }
    
    @SuppressWarnings("unchecked")
    public Gene buscarPorSymbol(Gene gene) {
        return buscarPorSymbol(gene.getSymbol());
    }

    @SuppressWarnings("unchecked")
    public Gene buscarPorEnsemblId(String ensemblId) {
        String ql = "SELECT g FROM Gene g WHERE g.ensemblId = :ensemblId";
        List<Gene> results = entityManager.createQuery(ql).setParameter(
                "ensemblId", ensemblId)
                .getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

}
