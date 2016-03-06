package fdpweb2;

import org.junit.Test;

import calc.Calculadora;
import org.junit.Assert;

public class TestCalculadoraJunit {
	
	@Test
	public void testSomar(){
			Calculadora c = new Calculadora();
			int r = c.somar(10, 20);
			// Qual é o resultado esperado?
			Assert.assertTrue( r == 30 );
	}
	@Test
	public void testSubtrair(){
			Calculadora c = new Calculadora();
			int r = c.subtrair(10, 20);
			// Qual é o resultado esperado?
			Assert.assertTrue(r==-10);
	}
}
