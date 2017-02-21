/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;



import converter.ConverterGenerico;
import entidades.Cidade;
import entidades.Estado;
import facade.CidadeFacade;
import facade.EstadoFacade;
import java.io.Serializable;
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
public class CidadeControle implements Serializable{

    private Cidade cidade;
    @EJB
    private CidadeFacade cidadeFacade;
    @EJB
    private EstadoFacade estadoFacade;
    
    private ConverterGenerico converterGenerico;    

    public ConverterGenerico getConverterGenerico() {
        if(converterGenerico == null){
            converterGenerico = new ConverterGenerico(estadoFacade);
        }
        return converterGenerico;
    }

    public void setConverterGenerico(ConverterGenerico converterGenerico) {
        this.converterGenerico = converterGenerico;
    }
   
    
    public List<Estado> listaEstados(){
        return estadoFacade.listaTodos();
    }

    public void novo(){
        cidade = new Cidade();
    }
    
    public void editar(Cidade c){
        cidade = c;
    }
    
    public void remover(Cidade c){
        cidade = c;
        cidadeFacade.remover(cidade);
    }
    
    public void salvar() {
        cidadeFacade.salvar(cidade);
    }
    
    public List<Cidade> listaTodos(){
        return cidadeFacade.listaTodos();
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
