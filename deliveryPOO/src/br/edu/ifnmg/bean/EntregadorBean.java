package br.edu.ifnmg.bean;


import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.edu.ifnmg.dao.EntregadorDao;
import br.edu.ifnmg.model.Entregador;
import br.edu.ifnmg.model.Endereco;
import br.edu.ifnmg.model.Telefone;
import br.edu.ifnmg.model.Veiculo;

@ManagedBean
public class EntregadorBean {
	
	private Entregador entregador;
	private Telefone telefone;
	private Endereco endereco;
	private Veiculo veiculo;
	private List<Entregador> entregadores;
	private List<Entregador> entregadoresFilter;
	
	@PostConstruct
	public void init() {
		entregador = new Entregador();
		telefone = new Telefone();
		endereco = new Endereco();
		veiculo = new Veiculo();
		entregadores = entregadorDao.getEntregadores();
	}
	
	@EJB
	private EntregadorDao entregadorDao;
	
	public void salvar() {
		entregador.setTelefone(telefone);
		entregador.setEndereco(endereco);
		entregador.setVeiculo(veiculo);
		entregadorDao.salvar(this.entregador);
		addMessage("Cadastrado com sucesso", null);
		entregador = new Entregador();
	}
	
	public List<Entregador> getEntregadores() {
		return this.entregadores;
	}
	
	public void addMessage(String info, String detail ) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, info, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public Entregador getEntregador() {
		return entregador;
	}
	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Entregador> getEntregadoresFilter() {
		return entregadoresFilter;
	}

	public void setEntregadoresFilter(List<Entregador> entregadoresFilter) {
		this.entregadoresFilter = entregadoresFilter;
	}

	public void setEntregadores(List<Entregador> entregadores) {
		this.entregadores = entregadores;
	}
	
	
	
}
