package br.com.fabricadeprogramador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fabricadeprogramador.entidade.Estado;

public class EstadoDAO implements DAO<Estado> {

	private EntityManager em;
	
	public EstadoDAO() {
		em = EmFactory.getEntityManager();
	}
	
	public void salvar(Estado estado){
		em.getTransaction().begin();
		em.merge(estado);
		em.getTransaction().commit();
		
	}
	
	public void excluir (Estado estado){
		em.getTransaction().begin();
		em.remove(estado);
		em.getTransaction().commit();
	}
	
	public Estado buscarPorId(int id){
		return em.find(Estado.class,id);// Select * from estado where id=?
	}
	
	@SuppressWarnings("unchecked")
	public List<Estado> buscarTodos (){
		//JPQL
		Query query = em.createQuery("select u from Estado u");
		return query.getResultList();
	}
	
	public List<Object[]> buscarTodos2 (){
		//JPQL
		Query query = em.createQuery("select u.id, u.nome from Estado u");
		return query.getResultList();
	}
	
	
}
