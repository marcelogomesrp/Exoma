package br.usp.exoma.view;

import br.usp.exoma.FacesUtil;
import br.usp.exoma.model.Analise;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author marcelo
 */
@RequestScoped
@Named
public class SelecionarVariantesMB {
    @Inject
    private FacesUtil facesUtil;
    private Analise analise;

    public Analise getAnalise() {
        return analise;
    }

    public void setAnalise(Analise analise) {
        this.analise = analise;
    }
    
    public String show(){
        System.out.println("Navegacao ok");
        return "/logado/selecionar_variantes";
    }
    
    
}
