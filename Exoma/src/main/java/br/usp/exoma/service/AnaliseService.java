package br.usp.exoma.service;

import br.usp.exoma.dao.AnaliseDao;
import br.usp.exoma.dao.CromossomoDao;
import br.usp.exoma.dao.PacienteDao;
import br.usp.exoma.dao.VarianteDao;
import br.usp.exoma.dao.VariantePacienteDao;
import br.usp.exoma.dao.tx.Transacional;
import br.usp.exoma.model.Analise;
import br.usp.exoma.model.Cromossomo;
import br.usp.exoma.model.Estado;
import br.usp.exoma.model.Nucleotideos;
import br.usp.exoma.model.Paciente;
import br.usp.exoma.model.Usuario;
import br.usp.exoma.model.Variante;
import br.usp.exoma.model.VariantePaciente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author marcelo
 */
@RequestScoped
public class AnaliseService {

    private static final File TARGET_FOLDER = new File("c:\\Temp");

    @Inject
    private AnaliseDao analiseDao;
    @Inject
    private VarianteDao varianteDao;
    @Inject
    private CromossomoDao cromossomoDao;
    @Inject
    private CromossomoService cromossomoService;
    @Inject 
    private PacienteDao pacienteDao;
    @Inject
    private VariantePacienteDao variantePacienteDao;
    private Analise analise;

    /*
    @Transacional
    public void criar() {        
        System.out.println("rodando...1");
        this.analise = analiseDao.criar(analise);
    }
     */
    @Transacional
    public void criar(Analise analise, InputStream inputstream) {
        this.analise = analise;
        analise.setEstado(Estado.Novo);
        analiseDao.criar(analise);
        //    this.criar();
        System.out.println("Rodando...2");
        try {
            //File arquivoLocal = new File(TARGET_FOLDER, analise.getId().toString());
            File arquivoLocal = new File(TARGET_FOLDER, "achar.txt");
            OutputStream out = new FileOutputStream(arquivoLocal);
            int read;
            byte[] bytes = new byte[1024];
            while ((read = inputstream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            inputstream.close();
            out.flush();
            out.close();
            processFile(arquivoLocal, analise);

        } catch (Exception ex) {

        }
    }

    //@Asynchronous
    public void processFile(File fileName, Analise analise) {
        BufferedReader buffRead;
        List<Paciente> pacientes = new ArrayList<Paciente>();
        try {
            FileReader fileReader = new FileReader(fileName);
            buffRead = new BufferedReader(fileReader);
            String linha;
            int qtdPacientes = -1;
            while ((linha = buffRead.readLine()) != null) {
                if (!linha.startsWith("#")) {                    
                    Variante variante = new Variante();
                    //variante.setTexto(linha);
                    String[] valores = linha.split("\\s+");
                    //adiciona os pacientes
                    if(qtdPacientes == -1){
                        qtdPacientes = (valores.length -9);
                        for(int x =0; x< qtdPacientes; x++){
                            Paciente p = new Paciente();
                            p.setNome(String.valueOf(x));
                            p.setAnalise(analise);
                            pacientes.add(pacienteDao.adiciona(p));
                            
                        }
                    }
                    
                    
                    String cromossomoNome = cromossomoService.preprarNome(valores[0]);
                    Cromossomo cromossomo
                            = cromossomoDao.buscarPorNome(cromossomoNome);
                    if (cromossomo == null) {
                        cromossomo = new Cromossomo();
                        cromossomo.setNome(cromossomoNome);
                        cromossomoDao.adiciona(cromossomo);
                    }
                    variante.setCromossomo(cromossomo);
                    
                    variante.setCromossomoPosicao(valores[1]);
                    variante.setRefSNP(valores[2]);
                    variante.setReferencia(Nucleotideos.valueOf(valores[3]));
                    variante.setTrocado(valores[4]);
                    variante.setQualidade(valores[5]);
                    variante.setFilter(valores[6]);
                    variante.setInfo(valores[7]);
                    variante.setFormat(valores[8]);
                    
                    varianteDao.adiciona(variante);
                    
                    for(int x = 9; x< valores.length; x++){
                        int posi = x - 9;
                        System.out.println("X: " + x + " - " + valores[x]);   
                        VariantePaciente vp = new VariantePaciente();
                        vp.setPaciente(pacientes.get(posi));
                        vp.setVariante(variante);
                        vp.setValor(valores[x]);
                        variantePacienteDao.adiciona(vp);
                    }
                } else {
                    System.out.println("pulado é comentario: " );
                }
            }
            buffRead.close();
            fileReader.close();
            System.out.println("..................qtdPacientes:" + qtdPacientes);
            //Thread.sleep(10000);
            //project.setProjectState(ProjectState.processed); 
        } catch (Exception ex) {
            //project.setProjectState(ProjectState.processing_error);
        }
        //projectDao.merge(project);
    }

    public List<Analise> PesquisarPorGestor(Usuario gestor) {
        return analiseDao.PesquisarPorGestor(gestor);
        //return analiseDao.PesquisarTodos();
    }

}


/*
    private static final File TARGET_FOLDER = new File("c:\\Temp");

    @Inject
    private AnaliseDao analiseDao;

    @Transacional
    public Analise criar(Analise analise) throws ServiceException {
        System.out.println("aqui:");
        analise.setDataCadastro(new Date());
        try {
            if (this.podeSerSalvo(analise)) {
                analise = analiseDao.criar(analise);
            }
        } catch (ServiceException ex) {
            throw ex;
        }
        return analise;
    }

    private boolean podeSerSalvo(Analise analise) throws ServiceException {
        ServiceException serviceException = new ServiceException();
        //serviceException.addMessage("A senha e a confirma��o n�o s�o iguais");
        if (serviceException.hasMessages()) {
            throw serviceException;
        }
        return true;
    }

    public void criar(Analise analise, InputStream inputstream) throws ServiceException {
        //System.out.println("Estou no service");
        /*
        try {
            this.criar(analise);
            //this.saveFile(analise, inputstream);
            System.out.println("Estou no service");
        } catch (ServiceException ex) {
            throw ex;
        }
        
    }
    
    public void saveFile(Analise analise,InputStream inputStream) {
        for(int x=0;x<30;x++){
            System.out.println("\nSaveFile....");
            System.err.println("eita...");
        }
    }

    private void saveFile(Analise analise, File fileName) {
        BufferedReader buffRead;
        try {
             FileReader fileReader = new FileReader(fileName);
             buffRead = new BufferedReader(fileReader);
             String linha;
             while ((linha = buffRead.readLine()) != null) {
                 System.out.println("linha:");
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 */
