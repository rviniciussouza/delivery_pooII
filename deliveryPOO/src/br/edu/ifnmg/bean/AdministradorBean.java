package br.edu.ifnmg.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.ifnmg.dao.AdministradorDao;
import br.edu.ifnmg.dao.EnderecoDao;
import br.edu.ifnmg.dao.TelefoneDao;
import br.edu.ifnmg.model.Administrador;
import br.edu.ifnmg.model.Endereco;
import br.edu.ifnmg.model.Telefone;

@ManagedBean
public class AdministradorBean implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Administrador administrador;
	private Telefone telefone;
	private Endereco endereco;
	private List<Administrador> administradores;
	private List<Administrador> administradoresFilter;
	
	@PostConstruct
	public void init() {
		administrador = new Administrador();
		telefone = new Telefone();
		endereco = new Endereco();
		administradores = administradorDao.getAdministradores();
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
	
	public void onRowEdit(RowEditEvent event) {
		addMessage("Administrador editado com sucesso", null);
		administradorDao.salvar((Administrador)event.getObject());
	}
	
	public void remove() {
		administrador.setAtivo(false);
		administradorDao.salvar(administrador);
		administradores = administradorDao.getAdministradores();
		administradoresFilter = administradores;
		addMessage("Administrador removido com sucesso", null);
	}
	
	public void addMessage(String info, String detail ) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, info, detail);
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

	public List<Administrador> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}

	public List<Administrador> getAdministradoresFilter() {
		return administradoresFilter;
	}

	public void setAdministradoresFilter(List<Administrador> administradoresFilter) {
		this.administradoresFilter = administradoresFilter;
	}

	public EnderecoDao getEnderecoDao() {
		return enderecoDao;
	}

	public void setEnderecoDao(EnderecoDao enderecoDao) {
		this.enderecoDao = enderecoDao;
	}
	
}
