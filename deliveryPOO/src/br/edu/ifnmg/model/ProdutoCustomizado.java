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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class ProdutoCustomizado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer qtd;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.DETACH)
	@JoinColumn(name="produto_id", nullable=false)
	private Produto produto;
	
	@ManyToMany(cascade=CascadeType.DETACH)
	@JoinTable(name="acrescimo_produto", joinColumns= @JoinColumn(name="produtoCust_id"),
	inverseJoinColumns= @JoinColumn(name="acrescimo_id"))
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acrescimos == null) ? 0 : acrescimos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((qtd == null) ? 0 : qtd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoCustomizado other = (ProdutoCustomizado) obj;
		if (acrescimos == null) {
			if (other.acrescimos != null)
				return false;
		} else if (!acrescimos.equals(other.acrescimos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (qtd == null) {
			if (other.qtd != null)
				return false;
		} else if (!qtd.equals(other.qtd))
			return false;
		return true;
	}

	

}
