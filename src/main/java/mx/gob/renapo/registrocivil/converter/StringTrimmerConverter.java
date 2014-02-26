package mx.gob.renapo.registrocivil.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=String.class, value = "stringTrimmerConverter")
public class StringTrimmerConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent toValidate, String valor) {
		 return valor != null ? valor.trim() : null;
	}

	@Override
	public String getAsString(FacesContext context, 
			UIComponent toValidate, Object valor) {
		return (String) valor;
	}

}
