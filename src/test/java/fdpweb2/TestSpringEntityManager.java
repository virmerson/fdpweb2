package fdpweb2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fabricadeprogramador.entidade.Usuario;

public class TestSpringEntityManager {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context ;
		context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
		
		//Testando EntityManagerFactory pelo Spring
		EntityManagerFactory  emf = (EntityManagerFactory)context.getBean("entityManagerFactory");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = new Usuario();
		usuario.setNome("Jao do Spring");
		usuario.setSenha("spring123");
		usuario.setLogin("jaodospringkkk");
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
	}

}
