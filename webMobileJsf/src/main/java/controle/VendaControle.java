/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;



import converter.ConverterGenerico;
import entidades.ItensVenda;
import entidades.Pessoa;
import entidades.Produto;
import entidades.Venda;
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
public class VendaControle {

    private Venda venda;
    private ItensVenda itensVenda;
    @EJB
    private VendaFacade vendaFacade;
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
        venda = new Venda();
        itensVenda = new ItensVenda();
    }

    public void editar(Venda c) {
        venda = c;
    }

    public void remover(Venda c) {
        venda = c;
        vendaFacade.remover(venda);
    }

    public void salvar() {
        vendaFacade.salvar(venda);
    }

    public List<Venda> listaTodos() {
        return vendaFacade.listaTodos();
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public List<Pessoa> listaPessoas(String parte) {
        return pessoaFacade.listaFiltrando(parte, "nome");
    }

    public List<Produto> listaProdutos(String parte) {
        return produtoFacade.listaFiltrando(parte, "nome");
    }

    public ItensVenda getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ItensVenda itensVenda) {
        this.itensVenda = itensVenda;
    }

    public void addItem() {
        Double estoque = itensVenda.getProduto().getEstoque();
        if (itensVenda.getQuantidade() > estoque) {
            FacesContext.getCurrentInstance().addMessage(
                    null, 
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, 
                            "Estoque insuficiente!", 
                            "Restam apenas "+estoque+" unidades!"
                    ));
        } else {
            itensVenda.setPreco(itensVenda.getProduto().getPreco());
            itensVenda.setVenda(venda);
            venda.getItensVendas().add(itensVenda);
            itensVenda = new ItensVenda();
        }

    }

    public void removerItem(ItensVenda it) {
        venda.getItensVendas().remove(it);
    }

}
