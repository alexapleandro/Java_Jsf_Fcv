/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;



import entidades.Produto;
import facade.ProdutoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aluno
 */
@ManagedBean
@SessionScoped
public class ProdutoControle {

    private Produto produto;
    @EJB
    private ProdutoFacade produtoFacade;

    public void novo(){
        produto = new Produto();
    }
    
    public void editar(Produto e){
        produto = e;
    }
    
    public void remover(Produto e){
        produto = e;
        produtoFacade.remover(produto);
    }
    
    public void salvar() {
        produtoFacade.salvar(produto);
    }
    
    public List<Produto> listaTodos(){
        return produtoFacade.listaTodos();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}