package br.usp.exoma;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Simple Utility bean for making it easier to add error messages
 *
 * @author Andy Gibson
 *
 */
@RequestScoped
public class FacesUtil {

    private FacesContext facesContext;

    @PostConstruct
    void init() {
	facesContext = FacesContext.getCurrentInstance();
    }
    
    public void addMensagem(String msg) {
        this.addMensagem(null, msg);
    }
    
    public void addMensagem(String compId, String msg) {
	facesContext.addMessage(compId, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
    }
    public void addErroMensagem(String msg) {
        this.addErroMensagem(null, msg);
    }
    
    public void addErroMensagem(String compId, String msg) {
        facesContext.addMessage(compId, 
            new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
    }
    
}
