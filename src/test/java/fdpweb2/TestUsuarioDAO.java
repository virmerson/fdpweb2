package fdpweb2;

import java.util.List;

import br.com.fabricadeprogramador.dao.DAO;
import br.com.fabricadeprogramador.dao.DAOFactory;
import br.com.fabricadeprogramador.dao.EstadoDAO;
import br.com.fabricadeprogramador.dao.UsuarioDAO;
import br.com.fabricadeprogramador.entidade.Estado;
import br.com.fabricadeprogramador.entidade.Usuario;

public class TestUsuarioDAO {
	
	static DAO<Usuario> usuarioDAO ;
	static DAO<Estado> estadoDAO = DAOFactory.getDAO("estadodao");
	
	public static void main(String[] args) {
		//testInserir();
		
		//testBuscarPorId();
		
		//testAlterar();
		//testBuscarTodos();
		testBuscarTodos2();
		//testExcluir();
	}
	
	public static void testInserir(){
		usuarioDAO.salvar(new Usuario("Virmerson","vir", "123"));
	}
	
	
	public static void testBuscarPorId(){
		Usuario usuBuscado = usuarioDAO.buscarPorId(1);
		System.out.println(usuBuscado.getId() +  " " + usuBuscado.getNome() );
	}
	
	public static void testAlterar(){
		Usuario usuBuscado = usuarioDAO.buscarPorId(1);
		usuBuscado.setNome("Zé");
		usuarioDAO.salvar(usuBuscado);
	}
	
	public static void testBuscarTodos(){
		List<Usuario> buscarTodos = usuarioDAO.buscarTodos();
		for(Usuario u: buscarTodos){
			System.out.println(u.getId() + " "+ u.getNome());
		}
	}
	
	
	public static void testBuscarTodos2(){
		List<Object[]> buscarTodos = usuarioDAO.buscarTodos2();
		for(Object[] u: buscarTodos){
			System.out.println(u[0]+ " "+ u[1]);
		}
	}
	
	public static void testExcluir (){
		Usuario usuBuscado = usuarioDAO.buscarPorId(1);
		usuarioDAO.excluir(usuBuscado);
	}
}
