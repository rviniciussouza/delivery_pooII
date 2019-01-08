package br.edu.ifnmg.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class FormaPagamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	
	@ManyToMany
	@JoinTable(name="pedido_formaPagamento", joinColumns= @JoinColumn(name="formaPagamento_id"),
	inverseJoinColumns= @JoinColumn(name="pedido_id"))
	private List<Pedido> pedidos;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	

}
