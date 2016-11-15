package br.usp.exoma.view;

import br.usp.exoma.FacesUtil;
import br.usp.exoma.model.Usuario;
import br.usp.exoma.service.UsuarioService;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlInputText;
import javax.inject.Inject;
import javax.inject.Named;
import static org.hsqldb.Library.user;

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
    HtmlInputText usernameEntry;

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
            facesUtil.addErroMensagem(usernameEntry.getClientId(), "Usuário ou senha inválido");
            return "login";
        } else {
            userSession.setUser(usuario);
            return "logado/index";
        }
    }

}
