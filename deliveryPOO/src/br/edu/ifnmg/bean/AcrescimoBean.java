package br.edu.ifnmg.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.ifnmg.dao.AcrescimoDao;
import br.edu.ifnmg.model.Acrescimo;
@ManagedBean
public class AcrescimoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AcrescimoDao acrescimoDao;
	
	private Acrescimo acrescimo;
	private List<Acrescimo> acrescimos;
	private List<Acrescimo> acrescimosFilter;
	
	@PostConstruct
	public void init() {
		acrescimo = new Acrescimo();
		acrescimos = acrescimoDao.getAcrescimos();
	}
	
	public void salvar() {
		acrescimoDao.salvar(acrescimo);
		addMessage("Acrescimo cadastrado com sucesso", null);
	}
	
	public void onRowEdit(RowEditEvent event) {
		addMessage("Acrescimo editado com sucesso", null);
		acrescimoDao.salvar((Acrescimo)event.getObject());
	}
	
	public void remove() {
		acrescimo.setAtivo(false);
		acrescimoDao.salvar(acrescimo);
		acrescimos = acrescimoDao.getAcrescimos();
		acrescimosFilter = acrescimos;
		addMessage("Acréscimo removido com sucesso", null);
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

	public List<Acrescimo> getAcrescimos() {
		return acrescimos;
	}

	public void setAcrescimos(List<Acrescimo> acrescimos) {
		this.acrescimos = acrescimos;
	}

	public List<Acrescimo> getAcrescimosFilter() {
		return acrescimosFilter;
	}

	public void setAcrescimosFilter(List<Acrescimo> acrescimosFilter) {
		this.acrescimosFilter = acrescimosFilter;
	}	
	
	
	
}
