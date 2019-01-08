package br.edu.ifnmg.convert;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@SuppressWarnings("rawtypes")
@FacesConverter("inputSenha")
public class InputSenha implements Converter {
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		MessageDigest algorithm = null;
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte messageDigest[] = null;
		try {
			messageDigest = algorithm.digest(valor.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
		  hexString.append(String.format("%02X", 0xFF & b));
		}
		String senha = hexString.toString();
		return senha;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {
		return valor.toString();
	}
}
