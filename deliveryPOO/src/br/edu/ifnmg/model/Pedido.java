package br.edu.ifnmg.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Double total;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Administrador administrador;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Entregador entregador;
	
	@ManyToMany(mappedBy="pedidos", fetch=FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private List<FormaPagamento> formaPagamento;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(nullable=false, name="pedido_id")
	private List<ProdutoCustomizado> produtos;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	private String observacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Administrador getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	public Entregador getEntregador() {
		return entregador;
	}
	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}
	public List<FormaPagamento> getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(List<FormaPagamento> formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public List<ProdutoCustomizado> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<ProdutoCustomizado> produtos) {
		this.produtos = produtos;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}	
}
