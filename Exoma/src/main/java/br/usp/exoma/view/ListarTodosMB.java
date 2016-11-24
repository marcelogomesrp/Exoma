package br.usp.exoma.view;

import br.usp.exoma.model.Analise;
import br.usp.exoma.service.AnaliseService;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author marcelo
 */
@RequestScoped
@Named
public class ListarTodosMB {
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
