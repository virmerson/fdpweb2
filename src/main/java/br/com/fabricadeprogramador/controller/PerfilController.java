package br.com.fabricadeprogramador.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fabricadeprogramador.entidade.Perfil;
import br.com.fabricadeprogramador.service.ServiceException;
import br.com.fabricadeprogramador.service.PerfilService;

@ManagedBean(name="perfilController")
@Controller(value="perfilController")
public class PerfilController {
	
	private List<Perfil> perfils ;
	
	private Perfil perfil= new Perfil();
	@Autowired
	private PerfilService perfilService;
	
	@PostConstruct
	public void init() {
		perfils = perfilService.buscarTodos();
	}
	
	public void salvar(){
		//
		try {
			perfil = perfilService.salvar(perfil);
			if (perfil.getId()==null){
				perfils.add(perfil);
			}
			perfil =  new Perfil();
			MensagemUtil.mensagemSalvoSucesso();
		} catch (ServiceException e) {
			MensagemUtil.mensagemErro(e.getMessage());
		}
	}

	public void excluir(Perfil perfil){
		try{
			perfilService.excluir(perfil);
			perfils.remove(perfil);
			MensagemUtil.mensagemExcluidoSucesso();
		}catch(Exception e){
			MensagemUtil.mensagemErro(e.getMessage());
		}
	}
	
	public void editar(Perfil perfil){
		this.perfil=perfil;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Perfil> getPerfils() {
		return perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}
	

	
}
