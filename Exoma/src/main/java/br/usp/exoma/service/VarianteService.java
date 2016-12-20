/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.usp.exoma.service;

import br.usp.exoma.dao.VarianteDao;
import br.usp.exoma.model.Analise;
import br.usp.exoma.model.Filtro;
import br.usp.exoma.model.Variante;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author marcelo
 */
@RequestScoped
public class VarianteService {
    
    @Inject
    private VarianteDao varianteDao;
    
    public List<Variante> buscaPorAnalise(Analise analise){
        return varianteDao.buscaPorAnalise(analise);
    }
    
    public List<Variante> buscaPorFiltro(Filtro filtro){
        return varianteDao.buscaPorFiltro(filtro);
    }
}
