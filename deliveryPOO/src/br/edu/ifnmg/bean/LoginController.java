package br.edu.ifnmg.bean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.edu.ifnmg.dao.AdministradorDao;
import br.edu.ifnmg.model.Administrador;
import java.io.Serializable;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class LoginController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Administrador administrador = new Administrador();
	
	@EJB
	AdministradorDao administradorDao;
	
	public String logarSistema() {
		
		administrador = administradorDao.findByUserKey(administrador.getUsuario(), administrador.getSenha());
		
		if(administrador != null) {
			
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("admin", administrador);
			
			System.out.println(administrador.getNome());
			
			return "app/index?faces-redirect=true";
		}
		
		else {
			return "/Login?faces-redirect=true";
		}
		
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/Login?faces-redirect=true";
	}
	
	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	
}
