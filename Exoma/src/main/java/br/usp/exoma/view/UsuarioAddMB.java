package br.usp.exoma.view;

import br.usp.exoma.FacesUtil;
import br.usp.exoma.model.Usuario;
import br.usp.exoma.service.UsuarioService;
import br.usp.exoma.util.ServiceException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private String confirmaSenha;
    private boolean salvo = false;

    public UsuarioAddMB() {
    }

    public void salvar() {
        try {
            usuarioService.create(user, confirmaSenha);
            user = new Usuario();
            confirmaSenha = "";
            facesUtil.addMensagem("Usuário adicionado com sucesso");
            salvo=true;
        } catch (ServiceException ex) {
            for(Exception e : ex.getMessages()){
                facesUtil.addErroMensagem(e.getMessage());
            }
            //Logger.getLogger(UsuarioAddMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void novo(){
        salvo=false;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public boolean isSalvo() {
        return salvo;
    }

}
