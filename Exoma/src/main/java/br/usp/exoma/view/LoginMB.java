package br.usp.exoma.view;

import br.usp.exoma.FacesUtil;
import br.usp.exoma.model.Usuario;
import br.usp.exoma.service.UsuarioService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author marcelo
 */
@RequestScoped
@Named
public class LoginMB {
    private String username;
    private String password;

    @Inject
    private UserSession userSession;
    @Inject
    private UsuarioService usuarioService;
    @Inject
    private FacesUtil facesUtil;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login() {
       Usuario usuario = usuarioService.buscarPorUsernamePassword(username, password);
        if (usuario == null) {
            facesUtil.addErroMensagem("Usuário ou senha inválido");
            return "login";
        } else {
            userSession.setUsuario(usuario);
            return "logado/index";
        }
    }

}
