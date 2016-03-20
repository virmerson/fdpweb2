package br.com.fabricadeprogramador.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.service.ServiceException;
import br.com.fabricadeprogramador.service.UsuarioService;

@ManagedBean(name="usuarioController")
@Controller(value="usuarioController")
public class UsuarioController {
	
	private List<Usuario> usuarios ;
	
	private Usuario usuario= new Usuario();
	@Autowired
	private UsuarioService usuarioService;
	
	@PostConstruct
	public void init() {
		usuarios = usuarioService.buscarTodos();
	}
	
	public void salvar(){
		//
		try {
			usuario = usuarioService.salvar(usuario);
			if (usuario.getId()==null){
				usuarios.add(usuario);
			}
			usuario =  new Usuario();
			MensagemUtil.mensagemSalvoSucesso();
		} catch (ServiceException e) {
			MensagemUtil.mensagemErro(e.getMessage());
		}
	}

	public void excluir(Usuario usuario){
		try{
			usuarioService.excluir(usuario);
			usuarios.remove(usuario);
			MensagemUtil.mensagemExcluidoSucesso();
		}catch(Exception e){
			MensagemUtil.mensagemErro(e.getMessage());
		}
	}
	
	public void editar(Usuario usuario){
		this.usuario=usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void excluir(){
		
		
	}
	
}
