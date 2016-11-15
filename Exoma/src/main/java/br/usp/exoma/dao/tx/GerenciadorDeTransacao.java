package br.usp.exoma.dao.tx;

import br.usp.exoma.dao.DataRepository;
import java.io.Serializable;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Transacional
@Interceptor
public class GerenciadorDeTransacao implements Serializable {

    @DataRepository
    @Inject
    private EntityManager entityManager;

    @AroundInvoke
    public Object executaTX(InvocationContext contexto) throws Exception {

        entityManager.getTransaction().begin();

        // chamar os daos que precisam de um TX
        Object resultado = contexto.proceed();

        entityManager.getTransaction().commit();

        return resultado;
    }

}
