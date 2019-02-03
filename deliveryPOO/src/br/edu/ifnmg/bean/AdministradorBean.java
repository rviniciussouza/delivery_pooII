package br.edu.ifnmg.bean;


import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.edu.ifnmg.dao.AdministradorDao;
import br.edu.ifnmg.dao.EnderecoDao;
import br.edu.ifnmg.dao.TelefoneDao;
import br.edu.ifnmg.model.Administrador;
import br.edu.ifnmg.model.Endereco;
import br.edu.ifnmg.model.Telefone;

@ManagedBean
public class AdministradorBean {
	
	private Administrador administrador;
	private Telefone telefone;
	private Endereco endereco;
	
	@PostConstruct
	public void init() {
		administrador = new Administrador();
		telefone = new Telefone();
		endereco = new Endereco();
	}
	
	@EJB
	private AdministradorDao administradorDao;
	
	@EJB
	private TelefoneDao telefoneDao;
	
	@EJB
	private EnderecoDao enderecoDao;
	
	public void salvar() {
		
		administrador.setTelefone(telefone);
		administrador.setEndereco(endereco);
		administradorDao.salvar(this.administrador);
		addMessage("Cadastrado com sucesso", null);
	}
	
	public void addMessage(String info, String detail ) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	
	public Administrador getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
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
