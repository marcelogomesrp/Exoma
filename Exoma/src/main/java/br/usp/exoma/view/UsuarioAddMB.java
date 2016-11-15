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
public class UsuarioAddMB {
    private Usuario user = new Usuario();
    @Inject
    private UsuarioService usuarioService;
    @Inject
    private FacesUtil facesUtil;

    public UsuarioAddMB() {
    }
    
    public void salvar(){
        usuarioService.create(user);
        user = new Usuario();
        facesUtil.addMensagem("Usuário adicionado com sucesso");
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
}
