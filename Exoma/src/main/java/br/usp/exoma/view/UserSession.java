package br.usp.exoma.view;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.usp.exoma.model.Usuario;

/**
 * This represents the users session and stores their {@link Usuario} instance
 * if they are logged in. It includes help methods to return a flag for if they
 * are logged in or not.
 *
 * @author Andy Gibson
 *
 */
@Named("userSession")
@SessionScoped
public class UserSession implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario;

    public void logout() {
        usuario = null;
    }


    public boolean isLoggedIn() {
        return usuario != null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    


}
