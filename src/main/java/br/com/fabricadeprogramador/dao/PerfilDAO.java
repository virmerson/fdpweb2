package br.com.fabricadeprogramador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fabricadeprogramador.entidade.Perfil;

@Repository(value="perfilDAO")
public class PerfilDAO implements DAO<Perfil> {
	
	@PersistenceContext
	private EntityManager em;
	
	public PerfilDAO() {
		System.out.println("Instanciando...");
	}
	
	@Transactional
	public Perfil salvar(Perfil perfil) throws DAOException{
		try{
			return em.merge(perfil);
		}catch (Exception e ){
			//Lancando exception encapsulando a causa
			throw new DAOException(e);
		}
	}
	
	@Transactional
	public void excluir (Perfil perfil){
		//Tornando Managed
		perfil = em.find(Perfil.class, perfil.getId());
		em.remove(perfil);
	}
	
	public Perfil buscarPorId(int id){
		return em.find(Perfil.class,id);// Select * from perfil where id=?
	}
	
	@SuppressWarnings("unchecked")
	public List<Perfil> buscarTodos (){
		//JPQL
		Query query = em.createQuery("select u from Perfil u");
		return query.getResultList();
	}
	
	public List<Object[]> buscarTodos2 (){
		//JPQL
		Query query = em.createQuery("select u.id, u.nome from Perfil u");
		return query.getResultList();
	}
	
	
}
