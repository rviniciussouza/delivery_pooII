package br.edu.ifnmg.convert;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import br.edu.ifnmg.dao.AcrescimoDao;
import br.edu.ifnmg.model.Acrescimo;

@ManagedBean
public class InputAcrescimo implements Converter {

	@EJB
	private AcrescimoDao acrescimoDao;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Acrescimo acrescimo = null;
		
		if(value != null && !value.isEmpty()) {
		
			acrescimo = acrescimoDao.findById(Long.parseLong(value));
			
			if(acrescimo == null) {
				FacesMessage msg = new FacesMessage("Codigo do acrescimo inválido");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ConverterException(msg);
			}
		}
		
		return acrescimo;
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return value.toString();
	}
}
