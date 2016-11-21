package br.usp.exoma.dao;

import br.usp.exoma.model.Variante;
import br.usp.exoma.model.VariantePaciente;
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
public class VariantePacienteDao implements Serializable {

    private static final long serialVersionUID = 1L;
    @DataRepository
    @Inject
    private EntityManager entityManager;

    private DAO<VariantePaciente> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<VariantePaciente>(this.entityManager, VariantePaciente.class);
    }

    public VariantePaciente adiciona(VariantePaciente variantePaciente) {
        return this.dao.adiciona(variantePaciente);
    }
    
}

