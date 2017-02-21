/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;



import converter.ConverterGenerico;
import entidades.Compra;
import entidades.ItensCompra;
import entidades.ItensVenda;
import entidades.Pessoa;
import entidades.Produto;
import entidades.Venda;
import facade.CompraFacade;
import facade.PessoaFacade;
import facade.ProdutoFacade;
import facade.VendaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aluno
 */
@ManagedBean
@SessionScoped
public class CompraControle {

    private Compra compra;
    private ItensCompra itensCompra;
    @EJB
    private CompraFacade compraFacade;
    @EJB
    private PessoaFacade pessoaFacade;
    @EJB
    private ProdutoFacade produtoFacade;
    private ConverterGenerico pessoaConverter;
    private ConverterGenerico produtoConverter;

    public ConverterGenerico getPessoaConverter() {
        if (pessoaConverter == null) {
            pessoaConverter = new ConverterGenerico(pessoaFacade);
        }
        return pessoaConverter;
    }

    public void setPessoaConverter(ConverterGenerico pessoaConverter) {
        this.pessoaConverter = pessoaConverter;
    }

    public ConverterGenerico getProdutoConverter() {
        if (produtoConverter == null) {
            produtoConverter = new ConverterGenerico(produtoFacade);
        }
        return produtoConverter;
    }

    public void setProdutoConverter(ConverterGenerico produtoConverter) {
        this.produtoConverter = produtoConverter;
    }

    public void novo() {
        compra = new Compra();
        itensCompra = new ItensCompra();
    }

    public void editar(Compra c) {
        compra = c;
    }

    public void remover(Compra c) {
        compra = c;
        compraFacade.remover(compra);
    }

    public void salvar() {
        compraFacade.salvar(compra);
    }

    public List<Compra> listaTodos() {
        return compraFacade.listaTodos();
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public List<Pessoa> listaPessoas(String parte) {
        return pessoaFacade.listaFiltrando(parte, "nome");
    }

    public List<Produto> listaProdutos(String parte) {
        return produtoFacade.listaFiltrando(parte, "nome");
    }

    public ItensCompra getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(ItensCompra itensCompra) {
        this.itensCompra = itensCompra;
    }

    public void addItem() {
        /*
        Double estoque = itensCompra.getProduto().getEstoque();
        if (itensCompra.getQuantidade() > estoque) {
            FacesContext.getCurrentInstance().addMessage(
                    null, 
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, 
                            "Estoque insuficiente!", 
                            "Restam apenas "+estoque+" unidades!"
                    ));
        } else {
            itensVenda.setPreco(itensVenda.getProduto().getPreco());
            itensVenda.setVenda(compra);
            compra.getItensVendas().add(itensVenda);
            itensVenda = new ItensVenda();
        }*/
        
            itensCompra.setPreco(itensCompra.getProduto().getPreco());
            itensCompra.setCompra(compra);
            compra.getItensCompra().add(itensCompra);
            itensCompra = new ItensCompra();

    }

    public void removerItem(ItensCompra ic) {
        compra.getItensCompra().remove(ic);
    }

}
