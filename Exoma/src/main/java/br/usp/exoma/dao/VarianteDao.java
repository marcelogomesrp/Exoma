/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.usp.exoma.dao;

import br.usp.exoma.model.Analise;
import br.usp.exoma.model.Filtro;
import br.usp.exoma.model.Variante;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import org.hibernate.engine.LoadQueryInfluencers;
import org.hibernate.loader.OuterJoinLoader;
import org.hibernate.loader.criteria.CriteriaLoader;
import org.hibernate.persister.entity.OuterJoinLoadable;

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

    public List<Variante> buscaPorAnalise(Analise analise) {
        //String sql = "SELECT v FROM Variante v WHERE :analise.id in v.analises.id";
        String sql = "SELECT v FROM Variante v INNER JOIN v.analises analise WHERE analise = :a";
        List<Variante> results = entityManager.createQuery(sql).setParameter(
                "a", analise)
                .getResultList();
        return results;
    }

    public List<Variante> buscaPorFiltro(Filtro filtro) { 
        List<Predicate> predList = new LinkedList<Predicate>();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Variante> cq = cb.createQuery(Variante.class);
        
        Root<Variante> root = cq.from(Variante.class);
        cq.select(root);
        Predicate conjunction = cb.conjunction();
        Predicate orConjunction = cb.conjunction();
        if(filtro.getFid() != null){
             Path<String> name = root.get("id");
             //cq.where(cb.and(cb.equal(name, filtro.getFid())));
             Predicate p1 = cb.equal(name, filtro.getFid());             
             conjunction.getExpressions().add(p1);
        }else{
            System.out.println("não buscado pelo id");
        }
        
        if(filtro.getRefSNP() != null){                
            if( (!filtro.getRefSNP().isEmpty())
            || (!filtro.getRefSNP().equals(""))
            ){                
                System.out.println("filtrado pelo snp: " + filtro.getRefSNP());
                Path<String> name = root.get("refSNP");
                //cq.where(cb.and(cb.like(name, filtro.getRefSNP() )));
                Predicate p2 = cb.like(name, filtro.getRefSNP());
                conjunction.getExpressions().add(p2);
            }else{
                System.out.println("Nao buscado pelo snp");
            }
        }
        
        if(filtro.getSelectedImpacto().length > 0){
            //Predicate q = null;
            Path<String> name = root.get("filter");
            for(String impacto : filtro.getSelectedImpacto() ){                                
                Predicate p = cb.or(cb.equal(name, impacto));
                //Predicate p = cb.equal(name, impacto);                
                orConjunction.getExpressions().add(p);                
                predList.add(p);
            }
            
            
            
        }
        //aqui
        if (    (conjunction.getExpressions().size() > 0) 
             && (orConjunction.getExpressions().isEmpty()) 
           ){
            cq.where(conjunction);            
        }
        
        if (    (conjunction.getExpressions().size() > 0) 
             && (orConjunction.getExpressions().size() > 0) 
           ){
            cq.where(conjunction, cb.or(predList.toArray(new Predicate[] {})));            
        }
        
        if (    (conjunction.getExpressions().isEmpty()) 
             && (orConjunction.getExpressions().size() > 0) 
           ){
            //cq.where(orConjunction);            
            cq.where(cb.or(predList.toArray(new Predicate[] {})));            
        }
        
        /*
        if (conjunction.getExpressions().size() > 0) {
            cq.where(conjunction, orConjunction);            
        }*/
        
        TypedQuery<Variante> query = entityManager.createQuery(cq);
        //for(Variante v: query.getResultList()){
        //    System.out.println("V: " + v.toString());
        //}
        
        System.out.println("query:"+query.toString());
        
        for(String f : filtro.getSelectedImpacto()){
            System.out.println("\n\t******:" + f);
        }
        
        return query.getResultList();
    }

    
    public List<Variante> buscaPorFiltro4(Filtro filtro) {        
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Variante> cq = cb.createQuery(Variante.class);
        Root<Variante> root = cq.from(Variante.class);
        cq.select(root);
        if(filtro.getFid() != null){
             Path<String> name = root.get("id");
             cq.where(cb.and(cb.equal(name, filtro.getFid())));
        }else{
            System.out.println("não buscado pelo id");
        }
        
        if((filtro.getRefSNP() != null) || (!filtro.getRefSNP().isEmpty() )){                
            System.out.println("filtrado pelo snp: " + filtro.getRefSNP());
             Path<String> name = root.get("refSNP");
             cq.where(cb.and(cb.like(name, filtro.getRefSNP() )));
        }else{
            System.out.println("Nao buscado pelo snp");
        }
        
        TypedQuery<Variante> query = entityManager.createQuery(cq);
        //for(Variante v: query.getResultList()){
        //    System.out.println("V: " + v.toString());
        //}
        return query.getResultList();
    }

    
    public List<Variante> buscaPorFiltro3(Filtro filtro) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Variante> c = cb.createQuery(Variante.class);
        Root<Variante> variante = c.from(Variante.class);
        if (filtro.getFid() != null) {
            c.where(cb.equal(variante.get("id"), cb.parameter(String.class, "id")));
        }
        TypedQuery q = entityManager.createQuery(c);
        q.setParameter("id", filtro.getFid());

        return (List<Variante>) q.getSingleResult();
    }
    /*
    public List<Variante> buscaPorFiltro2(Filtro filtro) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Variante> cq = cb.createQuery(Variante.class);
        Root<Variante> root = cq.from(Variante.class);
        cq.select(root);
        if (filtro.getFid() != null) {
            //cq.where(cb.gt(root.get("id"), filtro.getFid()));
            //cq.where(cb.gt(from.get("id"), 1l));

        }

        TypedQuery<Variante> query = entityManager.createQuery(cq);
        return query.getResultList();

    }
     */
}
