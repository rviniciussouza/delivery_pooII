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
public class Acrescimo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double preco;

	@ManyToMany
	@JoinTable(name="acrescimo_produto", joinColumns= @JoinColumn(name="acrescimo_id"),
	inverseJoinColumns= @JoinColumn(name="produto_id"))
	private List<ProdutoCustomizado> produtosCust;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<ProdutoCustomizado> getProdutosCust() {
		return produtosCust;
	}

	public void setProdutosCust(List<ProdutoCustomizado> produtosCust) {
		this.produtosCust = produtosCust;
	}
	
}
