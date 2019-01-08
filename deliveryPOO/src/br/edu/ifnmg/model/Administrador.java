package br.edu.ifnmg.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

@Entity
@DiscriminatorValue("Admin")
public class Administrador extends Pessoa{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String senha;
		
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
}