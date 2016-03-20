package br.com.fabricadeprogramador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fabricadeprogramador.entidade.Usuario;

@Repository(value="usuarioDAO")
public class UsuarioDAO implements DAO<Usuario> {
	
	@PersistenceContext
	private EntityManager em;
	
	public UsuarioDAO() {
		System.out.println("Instanciando...");
	}
	
	@Transactional
	public Usuario salvar(Usuario usuario) throws DAOException{
		try{
			return em.merge(usuario);
		}catch (Exception e ){
			//Lancando exception encapsulando a causa
			throw new DAOException(e);
		}
	}
	
	@Transactional
	public void excluir (Usuario usuario){
		//Tornando Managed
		usuario = em.find(Usuario.class, usuario.getId());
		em.remove(usuario);
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
