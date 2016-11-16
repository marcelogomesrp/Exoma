package br.usp.exoma.service;

import br.usp.exoma.dao.UsuarioDao;
import br.usp.exoma.dao.tx.Transacional;
import br.usp.exoma.model.Usuario;
import br.usp.exoma.util.ServiceException;
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
    public Usuario create(Usuario usuario, String confirmaSenha) throws ServiceException {
        try {
            if(this.podeSerSalvo(usuario, confirmaSenha)){
                usuario = usuarioDao.adiciona(usuario);
            }
        } catch (ServiceException ex) {
            throw ex;
        }
        return usuario;
    }

    public Usuario buscarPorUsernamePassword(String username, String password) {
        return usuarioDao.buscarPorUsernamePassword(username, password);
    }

    private boolean podeSerSalvo(Usuario usuario, String confirmaSenha) throws ServiceException{
        ServiceException serviceException = new ServiceException();
        if(!usuario.getPassword().equals(confirmaSenha)){
            serviceException.addMessage("A senha e a confirmação não são iguais");
        }
        
        if(serviceException.hasMessages()){
            throw serviceException;
        }
        return true;
    }
    
}
