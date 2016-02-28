package fdpweb2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fabricadeprogramador.dao.DAO;
import br.com.fabricadeprogramador.dao.UsuarioDAO;
import br.com.fabricadeprogramador.entidade.Usuario;

public class TestSpringEntityManager2 {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context ;
		context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
		
		DAO<Usuario> usuarioDAO =  (DAO<Usuario>)context.getBean("usuarioDAO");
		
		Usuario usuario = new Usuario();
		usuario.setNome("Jao do Spring 2");
		usuario.setSenha("ssss");
		usuario.setLogin("xxxx");
		
		usuarioDAO.salvar(usuario);
		
	}

}
