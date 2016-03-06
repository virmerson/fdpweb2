package fdpweb2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.fabricadeprogramador.dao.DAO;
import br.com.fabricadeprogramador.dao.DAOException;
import br.com.fabricadeprogramador.entidade.Usuario;

@ContextConfiguration("file:src/main/webapp/WEB-INF/springbeans.xml")
public class TestUsuarioDAOJunit extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired //Dependency Injection
	DAO<Usuario> usuarioDAO ;
	
	@Test
	public void testSalvar() throws DAOException {
		
		Usuario usuario = new Usuario();
		usuario.setNome("Jao do Spring 2");
		usuario.setSenha("ssss");
		usuario.setLogin("zz");
		
		usuarioDAO.salvar(usuario);
		
	}

}
