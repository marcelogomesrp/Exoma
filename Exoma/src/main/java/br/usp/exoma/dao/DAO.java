package br.usp.exoma.dao;

/**
 *
 * @author marcelo
 */
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class DAO<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Class<T> classe;
        
        @DataRepository
        @Inject
	private EntityManager entityManager;

	public DAO(EntityManager em, Class<T> classe) {
		this.classe = classe;
		this.entityManager = em;
	}

	public T adiciona(T t) {

		// persiste o objeto
		entityManager.persist(t);
                return t;
	}

	public void remove(T t) {

		entityManager.remove(entityManager.merge(t));

	}

	public T atualiza(T t) {
		entityManager.merge(t);
                return t;
	}

	public List<T> listaTodos() {

		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = entityManager.createQuery(query).getResultList();

		return lista;
	}

	public T buscaPorId(Integer id) {

		T instancia = entityManager.find(classe, id);

		return instancia;
	}

        /*
	public int contaTodos() {

		long result = (Long) entityManager.createQuery("select count(n) from livro n")
				.getSingleResult();

		return (int) result;
	}
        */
        
	public List<T> listaTodosPaginada(int firstResult, int maxResults) {

		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = entityManager.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		return lista;
	}

}
