package br.usp.exoma.view;

import br.usp.exoma.FacesUtil;
import br.usp.exoma.model.Analise;
import br.usp.exoma.model.Filtro;
import br.usp.exoma.model.Variante;
import br.usp.exoma.service.FiltroService;
import br.usp.exoma.service.VarianteService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.data.FilterEvent;
import org.primefaces.event.data.PageEvent;

/**
 *
 * @author marcelo
 */
@SessionScoped
@Named
public class SelecionarVariantesMB implements Serializable{
    @Inject
    private FacesUtil facesUtil;
    private Analise analise;
    private List<Variante> listVariante = new ArrayList<Variante>();
    //private List<Variante> listVarianteFiltradas ; //= new ArrayList<Variante>();
    @Inject
    private VarianteService varianteService;
    @Inject
    private FiltroService filtroService;
    private Filtro filtro = new Filtro();

    public Analise getAnalise() {
        return analise;
    }

    public void setAnalise(Analise analise) {
        this.analise = analise;
    }
    
    public String show(){
        System.out.println("Navegacao ok - " + analise.toString());
        listVariante = varianteService.buscaPorAnalise(analise);
        return "/logado/selecionar_variantes.xhtml?faces-redirect=true";
    }

    public String show(Analise analise){
        System.out.println("Navegacao ok");
        this.analise = analise;        
        return "/logado/selecionar_variantes.xhtml?faces-redirect=true";
    }    

    public List<Variante> getListVariante() {
        return listVariante;
    }

    public void setListVariante(List<Variante> listVariante) {
        this.listVariante = listVariante;
    }

    
     public boolean filtrarPorIdOld(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
        if(value == null) {
            return false;
        }
        filtro.setFid(Long.valueOf(filterText));
        filtro = filtroService.salvar(filtro);
        return ((Comparable) value).compareTo(Long.valueOf(filterText)) > 0;
    }
    
     public void onPageChange(PageEvent event) {  
           //this.setFirst(((DataTable) event.getSource()).getFirst());  
          // System.out.println("Pagina mudando....");
      }  
     public  void onFiltarPorId(FilterEvent filterEvent){
         System.out.println("Filtro por id");
     }
     public void onFilterChange(FilterEvent filterEvent){
         System.out.println("Modificou o filtro: " + filtro.toString());
         System.out.println("Filtro aplicado: " + filterEvent.toString());
         listVariante = varianteService.buscaPorFiltro(filtro);
     }
     
     public void filtrar(){
         //System.out.println("Filtrando...");
         listVariante = varianteService.buscaPorFiltro(filtro);
     }

    public Filtro getFiltro() {
        return filtro;
    }

    public void setFiltro(Filtro filtro) {
        this.filtro = filtro;
    }
     
     
}
