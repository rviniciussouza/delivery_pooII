package br.edu.ifnmg.bean;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.edu.ifnmg.dao.ProdutoDao;
import br.edu.ifnmg.model.Produto;

@ManagedBean
public class ProdutoBean {

	@EJB
	private ProdutoDao produtoDao;
	
	private Produto produto;
	
	@PostConstruct
	public void init() {
		produto = new Produto();
	}
	
	public void salvar() {
		produtoDao.salvar(produto);
		addMessage("Produto cadastrado com sucesso", null);
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
	
	
	
}
