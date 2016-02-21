package br.com.fabricadeprogramador.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmFactory {
	
	static EntityManager em;
	
	public static EntityManager getEntityManager(){
		if (em==null){
			EntityManagerFactory emf =  Persistence.createEntityManagerFactory("javaweb2");
			em = emf.createEntityManager();
		}
		
		return em;
	}
	
}
