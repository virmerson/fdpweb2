package br.com.fabricadeprogramador.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fabricadeprogramador.entidade.Usuario;

public class UsuarioDAO {

	private EntityManager em;
	
	public UsuarioDAO() {
		EntityManagerFactory emf =  Persistence.createEntityManagerFactory("javaweb2");
		em = emf.createEntityManager();
	}
	
	public void salvar(Usuario usuario){
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
	
	
}
