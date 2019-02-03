package br.edu.ifnmg.bean;


import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.edu.ifnmg.dao.ClienteDao;
import br.edu.ifnmg.dao.EnderecoDao;
import br.edu.ifnmg.dao.TelefoneDao;
import br.edu.ifnmg.model.Cliente;
import br.edu.ifnmg.model.Endereco;
import br.edu.ifnmg.model.Telefone;

@ManagedBean
public class ClienteBean {
	
	private Cliente cliente;
	private Telefone telefone;
	private Endereco endereco;
	
	@PostConstruct
	public void init() {
		cliente = new Cliente();
		telefone = new Telefone();
		endereco = new Endereco();
	}
	
	@EJB
	private ClienteDao clienteDao;
	
	@EJB
	private TelefoneDao telefoneDao;
	
	@EJB
	private EnderecoDao enderecoDao;
	
	public void salvar() {
		
		cliente.setTelefone(telefone);
		cliente.setEndereco(endereco);
		clienteDao.salvar(this.cliente);
		addMessage("Cadastrado com sucesso", null);
	}
	
	public void addMessage(String info, String detail ) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, info, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
}
