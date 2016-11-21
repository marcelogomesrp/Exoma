package br.usp.exoma.service;

import br.usp.exoma.dao.CromossomoDao;
import br.usp.exoma.dao.tx.Transacional;
import br.usp.exoma.model.Cromossomo;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author marcelo
 */
@RequestScoped
public class CromossomoService implements Serializable {
    private static final long serialVersionUID = 1L;
       
    
    @Inject 
    private CromossomoDao cromossomoDao;
    
    public String preprarNome(String nome){
        nome = nome.toLowerCase();
        String nulos[] = {"chr", "@", "#"};
        for (String n:nulos)
            nome = nome.replaceAll(n, "");
        return nome;
    }
    
    
    
    public Cromossomo buscaPorNome(String nome){
        return cromossomoDao.buscarPorNome(nome);
    }
    
    
    
    public Cromossomo criar(Cromossomo cromossomo){
        System.out.println("olha la: " + cromossomo.getNome());
        if(cromossomoDao == null){
            System.out.println("..................................puts");
        }else{
            cromossomoDao.adiciona(cromossomo);
        }
        //return cromossomoDao.adiciona(cromossomo);
        return null;
    }
    


    public CromossomoService() {
    }
    
    
    
    
}
