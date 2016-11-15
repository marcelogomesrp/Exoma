package br.usp.exoma.dao;

import br.usp.exoma.model.Usuario;
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
public class UsuarioDao implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @DataRepository
    @Inject
    private EntityManager entityManager;
    
    private DAO<Usuario> dao;
    
    @PostConstruct
	void init() {
		this.dao = new DAO<Usuario>(this.entityManager, Usuario.class);
	}
    
    public Usuario adiciona(Usuario user) {
        return this.dao.adiciona(user);
		//entityManager.getTransaction().begin();
		//entityManager.persist(user);
		//entityManager.getTransaction().commit();
               // return user;
	}
}
