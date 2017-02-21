/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.PessoaFisica;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aluno
 */
@Stateless
public class PessoaFisicaFacade extends AbstractFacade<PessoaFisica>{

    @PersistenceContext(unitName = "webMobileJsfPU")
    private EntityManager em;

    public PessoaFisicaFacade() {
        super(PessoaFisica.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}