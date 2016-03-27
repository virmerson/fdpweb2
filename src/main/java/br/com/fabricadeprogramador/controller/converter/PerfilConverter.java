package br.com.fabricadeprogramador.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fabricadeprogramador.entidade.Perfil;
import br.com.fabricadeprogramador.service.PerfilService;

@Component("perfilConverter")
public class PerfilConverter implements Converter {
	@Autowired
	private PerfilService perfilService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value==null ||  value.isEmpty())  return null;
		int id = Integer.parseInt(value);
		Perfil p = perfilService.buscarPorId(id);
		return p;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value==null ||  !(value instanceof Perfil) ) return "";
		Perfil p = (Perfil) value;
		
		return p.getId().toString();
	}


}