package br.edu.ifnmg.bean;


import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import br.edu.ifnmg.dao.AdministradorDao;
import br.edu.ifnmg.dao.EnderecoDao;
import br.edu.ifnmg.dao.TelefoneDao;
import br.edu.ifnmg.model.Administrador;
import br.edu.ifnmg.model.Endereco;
import br.edu.ifnmg.model.Telefone;

@ManagedBean
public class AdministradorBean {
	
	private Administrador administrador = new Administrador();
	private Telefone telefone = new Telefone();
	private Endereco endereco = new Endereco();
	
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
