package br.usp.exoma.view;

import br.usp.exoma.FacesUtil;
import br.usp.exoma.model.Analise;
import br.usp.exoma.service.AnaliseService;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author marcelo
 */
@RequestScoped
@Named
public class AnaliseAddMB implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private UserSession userSession;
    private Analise analise = new Analise();
    @Inject
    private AnaliseService analiseService;
    @Inject
    private FacesUtil facesUtil;
    private boolean  salvo = false;
    private UploadedFile file;

    public AnaliseAddMB() {
    }
    
    public String show(){
        System.out.println("okokok");
        return "logado/analise_add";
    }
    
    public String salvar() {
        System.out.println("esta indo...");
        if(file == null){
            facesUtil.addErroMensagem("Informe o arquivo VCF");
        }else{
            System.out.println("be happy");
            facesUtil.addMensagem("Be happy");
            try{
            analiseService.criar(analise, file.getInputstream());
            }catch(IOException ex){
                facesUtil.addErroMensagem("ops: " + ex.toString());
            }
        }
        return "analise_add";
    }

    public Analise getAnalise() {
        return analise;
    }

    public void setAnalise(Analise analise) {
        this.analise = analise;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

}
