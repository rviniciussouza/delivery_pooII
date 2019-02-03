package br.edu.ifnmg.bean;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.edu.ifnmg.dao.AcrescimoDao;
import br.edu.ifnmg.model.Acrescimo;

@ManagedBean
public class AcrescimoBean {

	@EJB
	private AcrescimoDao acrescimoDao;
	
	private Acrescimo acrescimo;
	
	@PostConstruct
	public void init() {
		acrescimo = new Acrescimo();
	}
	
	public void salvar() {
		acrescimoDao.salvar(acrescimo);
		addMessage("Acrescimo cadastrado com sucesso", null);
	}
	
	public void addMessage(String info, String detail ) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, info, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public Acrescimo getAcrescimo() {
		return acrescimo;
	}

	public void setAcrescimo(Acrescimo acrescimo) {
		this.acrescimo = acrescimo;
	}	
	
}
