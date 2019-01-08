package br.edu.ifnmg.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifnmg.model.Telefone;

@SuppressWarnings("rawtypes")
@FacesConverter("inputTelefone")
public class InputTelefone implements Converter{
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		if(valor != null || valor != "") {
			valor = valor.toString().replaceAll("[-() ]", "");
		}
		
		Telefone telefone = new Telefone();
		telefone.setDdd(Byte.parseByte(valor.substring(0, 3)));
		System.out.println(valor.substring(3, valor.length()));
		telefone.setNumero(Integer.parseInt(valor.substring(3, valor.length())));
		return telefone;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {
		return valor.toString();
	}
}
