package br.edu.ifnmg.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import br.edu.ifnmg.model.Acrescimo;
import br.edu.ifnmg.model.Cliente;
import br.edu.ifnmg.model.Pedido;
import br.edu.ifnmg.model.ProdutoCustomizado;

public class PedidoBean {

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
