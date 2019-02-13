package br.edu.ifnmg.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.edu.ifnmg.dao.PedidoDao;
import br.edu.ifnmg.model.Acrescimo;
import br.edu.ifnmg.model.Administrador;
import br.edu.ifnmg.model.Cliente;
import br.edu.ifnmg.model.Pedido;
import br.edu.ifnmg.model.ProdutoCustomizado;

@ManagedBean
public class PedidoBean {

	@EJB
	private PedidoDao pedidoDao;
	
	private Pedido pedido;
	private List<ProdutoCustomizado> itens;
	private ProdutoCustomizado produtoCustomizado;
	private Acrescimo acrescimo; 
	private Cliente cliente;
	
	Long idx = 0L;
	
	@PostConstruct
	public void init() {
		pedido = new Pedido();
		itens = new ArrayList<>();
		produtoCustomizado = new ProdutoCustomizado();
		cliente = new Cliente();
	}
	
	public void salvar() {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		pedido.setAdministrador((Administrador)session.getAttribute("admin"));
		
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		Date date = new Date();
		
		for(ProdutoCustomizado p : itens) {
			p.setId(null);
		}
		
		pedido.setProdutos(itens);
		pedido.setData(date);
		pedidoDao.salvar(pedido);
	}
	
	public void addProduto() {
		produtoCustomizado.setId(idx++);
		itens.add(produtoCustomizado);
		produtoCustomizado = new ProdutoCustomizado();
	}
	
	public void addAcrescimo() {
		
		for(ProdutoCustomizado p : itens) {
			if(p.getId() == produtoCustomizado.getId()) {
				p.getAcrescimos().add(acrescimo);
			}
		}
		acrescimo = null;
	}

	public void excluirProdutoCarrinho() {
		System.out.println("aqui" + produtoCustomizado.getId());
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<ProdutoCustomizado> getItens() {
		return itens;
	}

	public void setItens(List<ProdutoCustomizado> itens) {
		this.itens = itens;
	}

	public ProdutoCustomizado getProdutoCustomizado() {
		return produtoCustomizado;
	}

	public void setProdutoCustomizado(ProdutoCustomizado produtoCustomizado) {
		this.produtoCustomizado = produtoCustomizado;
	}

	public Acrescimo getAcrescimo() {
		return acrescimo;
	}

	public void setAcrescimo(Acrescimo acrescimo) {
		this.acrescimo = acrescimo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
