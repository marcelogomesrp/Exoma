/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.usp.exoma.service;

import br.usp.exoma.dao.FiltroDao;
import br.usp.exoma.model.Filtro;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author marcelo
 */
@RequestScoped
public class FiltroService {
    @Inject
    private FiltroDao filtroDao;

    public FiltroService() {
    }
    
    public Filtro salvar(Filtro filtro){
        System.out.println("Salvado...." + filtro.toString());
        if(filtro.getId() == null){
            System.out.println("null");
            filtro = filtroDao.adiciona(filtro);
        }else{
            System.out.println("nao null");
            filtro = filtroDao.atualiza(filtro);
        }
        return filtro;        
    }
}
