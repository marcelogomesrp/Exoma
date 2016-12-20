package br.usp.exoma.view;

import br.usp.exoma.model.Analise;
import br.usp.exoma.service.AnaliseService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author marcelo
 */
@SessionScoped
@Named
public class ListarTodosMB implements Serializable{
    @Inject
    private UserSession userSession;
    @Inject
    private AnaliseService analiseService;
    private List<Analise> listAnalise = new ArrayList<Analise>();
    
    /*
    public void atualizar(){
        listAnalise = analiseService.PesquisarPorUsuario(userSession.getUsuario());
    }
    */
    
    public String show(){
        listAnalise = analiseService.PesquisarPorGestor(userSession.getUsuario());
        return "/logado/listar_todos";
    }

    public List<Analise> getListAnalise() {
        return listAnalise;
    }

    public void setListAnalise(List<Analise> listAnalise) {
        this.listAnalise = listAnalise;
    }
    
    
}
