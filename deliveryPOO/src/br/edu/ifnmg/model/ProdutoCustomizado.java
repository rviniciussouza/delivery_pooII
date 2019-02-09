package br.edu.ifnmg.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class ProdutoCustomizado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer qtd;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="produto_id", nullable=false)
	private Produto produto;
	
	@ManyToMany(mappedBy="produtosCust")
	private List<Acrescimo> acrescimos = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Acrescimo> getAcrescimos() {
		return acrescimos;
	}

	public void setAcrescimos(List<Acrescimo> acrescimos) {
		this.acrescimos = acrescimos;
	}
}
