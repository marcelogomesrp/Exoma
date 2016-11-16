package br.usp.exoma.dao;

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
public class UsuarioDao implements Serializable {

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
        user.setDataCadastro(new Date());
        return this.dao.adiciona(user);
    }

    @SuppressWarnings("unchecked")
    public Usuario buscarPorUsernamePassword(String username, String password) {
        String ql = "SELECT u FROM Usuario u WHERE u.username = :username and u.password = :password";
        List<Usuario> results = entityManager.createQuery(ql).setParameter(
                "username", username).setParameter("password", password)
                .getResultList();
        return results.isEmpty() ? null : results.get(0);
    }
}
