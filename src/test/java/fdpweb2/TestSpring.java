package fdpweb2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fabricadeprogramador.entidade.Usuario;

public class TestSpring {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext context ;
		context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
		
		Usuario usu1 = (Usuario) context.getBean("usu");
		Usuario usu2 = (Usuario) context.getBean("usu");
		
		
		System.out.println(usu1==usu2);
	}

}
