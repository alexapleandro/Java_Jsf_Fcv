/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.ItensVenda;
import entidades.Produto;
import entidades.Venda;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aluno
 */
@Stateless
public class VendaFacade extends AbstractFacade<Venda>{

    @PersistenceContext(unitName = "webMobileJsfPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendaFacade() {
        super(Venda.class);
    }

    @Override
    public List<Venda> listaTodos() {
        List<Venda> lista = em.createQuery("from Venda").getResultList();
        for(Venda v : lista){
            v.getItensVendas().size();
        }
        return lista;
    }
    
    

    @Override
    public void salvar(Venda entity) {
        baixaEstoque(entity);
        em.merge(entity);
    }

    private void baixaEstoque(Venda entity) {
        for (ItensVenda iv : entity.getItensVendas()) {
            Produto p = iv.getProduto();
            p.setEstoque(p.getEstoque() - iv.getQuantidade());
            em.merge(p);
        }
    }
    
    
    
}
