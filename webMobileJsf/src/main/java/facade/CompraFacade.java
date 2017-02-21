/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.Compra;
import entidades.ItensCompra;
import entidades.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aluno
 */
@Stateless
public class CompraFacade extends AbstractFacade<Compra>{

    @PersistenceContext(unitName = "webMobileJsfPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompraFacade() {
        super(Compra.class);
    }

    @Override
    public List<Compra> listaTodos() {
        List<Compra> lista = em.createQuery("from Compra").getResultList();
        for(Compra c : lista){
            c.getItensCompra().size();
        }
        return lista;
    }
    
    

    @Override
    public void salvar(Compra entity) {
        baixaEstoque(entity);
        em.merge(entity);
    }

    private void baixaEstoque(Compra entity) {
        for (ItensCompra ic : entity.getItensCompra()) {
            Produto p = ic.getProduto();
            p.setEstoque(p.getEstoque() + ic.getQuantidade());
            em.merge(p);
        }
    }
    
    
    
}
