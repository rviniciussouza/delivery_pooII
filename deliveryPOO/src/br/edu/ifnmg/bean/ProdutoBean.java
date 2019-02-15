package br.edu.ifnmg.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.ifnmg.dao.ProdutoDao;
import br.edu.ifnmg.model.Cliente;
import br.edu.ifnmg.model.Produto;

@ManagedBean
public class ProdutoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ProdutoDao produtoDao;
	
	private Produto produto;
	private List<Produto> produtos;
	private List<Produto> produtosFilter;
	
	@PostConstruct
	public void init() {
		produto = new Produto();
		produtos = produtoDao.getProdutos();
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}
	
	public void onRowEdit(RowEditEvent event) {
		addMessage("Produto editado com sucesso", null);
		produtoDao.salvar((Produto)event.getObject());
	}
	
	public void salvar() {
		produtoDao.salvar(produto);
		addMessage("Produto cadastrado com sucesso", null);
	}
	
	public void remove() {
		produto.setAtivo(false);
		produtoDao.salvar(produto);
		produtos = produtoDao.getProdutos();
		produtosFilter = produtos;
		addMessage("Produto removido com sucesso", null);
	}
	
	public void addMessage(String info, String detail ) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, info, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutosFilter() {
		return produtosFilter;
	}

	public void setProdutosFilter(List<Produto> produtosFilter) {
		this.produtosFilter = produtosFilter;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
}
