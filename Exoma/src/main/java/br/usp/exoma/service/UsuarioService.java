package br.usp.exoma.service;

import br.usp.exoma.dao.UsuarioDao;
import br.usp.exoma.dao.tx.Transacional;
import br.usp.exoma.model.Usuario;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author marcelo
 */
@RequestScoped
public class UsuarioService {
    @Inject
    private UsuarioDao usuarioDao;

    public UsuarioService() {
    }
    
    @Transacional
    public Usuario create(Usuario usuario){
        return usuarioDao.adiciona(usuario);
    }
    
}
