package br.com.fabricadeprogramador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.fabricadeprogramador.entidade.Usuario;

public class UsuarioDAO implements DAO<Usuario> {

	private EntityManager em;
	
	public UsuarioDAO() {
		em = EmFactory.getEntityManager();
	}
	
	public void salvar(Usuario usuario){
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		
	}
	
	public void excluir (Usuario usuario){
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
	}
	
	public Usuario buscarPorId(int id){
		return em.find(Usuario.class,id);// Select * from usuario where id=?
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos (){
		//JPQL
		Query query = em.createQuery("select u from Usuario u");
		return query.getResultList();
	}
	
	public List<Object[]> buscarTodos2 (){
		//JPQL
		Query query = em.createQuery("select u.id, u.nome from Usuario u");
		return query.getResultList();
	}
	
	
}
