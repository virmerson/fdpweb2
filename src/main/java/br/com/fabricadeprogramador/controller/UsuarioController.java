package br.com.fabricadeprogramador.controller;

import javax.faces.bean.ManagedBean;

import br.com.fabricadeprogramador.entidade.Usuario;

@ManagedBean(name="usuarioController")
public class UsuarioController {
	private Usuario usuario= new Usuario();
	
	public void salvar(){
		//
		System.out.println("Salvando usuario:" + usuario.getNome() +" "+ usuario.getLogin() + " "+ usuario.getSenha() );
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
