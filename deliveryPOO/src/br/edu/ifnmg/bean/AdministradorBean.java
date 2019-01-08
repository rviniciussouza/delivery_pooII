package br.edu.ifnmg.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
//import javax.persistence.EntityManager;

import br.edu.ifnmg.dao.AdministradorDao;
import br.edu.ifnmg.dao.EnderecoDao;
import br.edu.ifnmg.dao.TelefoneDao;
import br.edu.ifnmg.model.Administrador;
import br.edu.ifnmg.model.Endereco;
import br.edu.ifnmg.model.Telefone;

@SuppressWarnings("deprecation")
@ManagedBean
public class AdministradorBean {
	
	private Administrador administrador = new Administrador();
	private Telefone telefone = new Telefone();
	private Endereco endereco = new Endereco();
	private List<Telefone> telefones = new ArrayList<>();
	private List<Endereco> enderecos = new ArrayList<>();
	
	@EJB
	private AdministradorDao administradorDao;
	
	@EJB
	private TelefoneDao telefoneDao;
	
	@EJB
	private EnderecoDao enderecoDao;
	
	public void salvar() {
		
		this.telefone.setPessoa(this.getAdministrador());
		this.endereco.setPessoa(this.getAdministrador());
		this.telefones.add(this.telefone);
		this.enderecos.add(this.endereco);
		this.administrador.setTelefones(this.telefones);
		this.administrador.setEnderecos(this.enderecos);
		this.administradorDao.salvar(this.administrador);
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
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}
