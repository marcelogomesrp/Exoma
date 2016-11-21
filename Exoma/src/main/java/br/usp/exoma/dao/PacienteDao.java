package br.usp.exoma.dao;

import br.usp.exoma.model.Paciente;
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
public class PacienteDao implements Serializable {

    private static final long serialVersionUID = 1L;

    @DataRepository
    @Inject
    private EntityManager entityManager;

    private DAO<Paciente> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<Paciente>(this.entityManager, Paciente.class);
    }

    public Paciente adiciona(Paciente paciente) {        
        return this.dao.adiciona(paciente);
    }

}