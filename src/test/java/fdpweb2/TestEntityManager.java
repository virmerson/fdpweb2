package fdpweb2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fabricadeprogramador.entidade.Usuario;

public class TestEntityManager {

	public static void main(String[] args) {
		
		//Criação de EntityManager Factory
		//Aqui criamos o banco
		//DDL
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaweb2");
		//insert, update, delete, select
		
		EntityManager em = emf.createEntityManager();
		Usuario usuario =  new Usuario();
		usuario.setNome("Jão");
		usuario.setLogin("jj");
		usuario.setSenha("123");
		
		//Abrir uma transacao
		em.getTransaction().begin();
		//Gera o SQL insert into ...
		em.persist(usuario);
		//Executa a transacao
		em.getTransaction().commit();
		//encerra a transacao
		em.close();
		
			
	}

}
