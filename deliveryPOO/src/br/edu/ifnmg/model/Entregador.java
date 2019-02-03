package br.edu.ifnmg.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value="entregador")
public class Entregador extends Pessoa{
	
	private static final long serialVersionUID = 1L;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="veiculo_fk")
	private Veiculo veiculo;

	@OneToMany(mappedBy="entregador", fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Pedido> pedidos;
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
}
