package fdpweb2;

import calc.Calculadora;

public class TestCalculadora {

	public static void main(String[] args) {
		TestCalculadora tc = new TestCalculadora();
		tc.testSomar();
		tc.testSubtrair();
	}
	
	public void testSomar(){
		try {
			Calculadora c = new Calculadora();
			int r = c.somar(10, 20);
			// Qual é o resultado esperado?
			if (r == 30) {
				System.out.println("Método calculadora.somar()  Deu certo");
			} else {
				System.out.println("Método calculadora.somar() Deu errado");
			}
		} catch (Exception e) {
			System.out.println("Método calculadora.somar()  Deu errado");
		}
	}
	
	
	
	public void testSubtrair(){
		try {
			Calculadora c = new Calculadora();
			int r = c.subtrair(10, 20);
			// Qual é o resultado esperado?
			if (r == -10) {
				System.out.println("Método calculadora.subtrair()  Deu certo");
			} else {
				System.out.println("Método calculadora.subtrair() Deu errado");
			}
		} catch (Exception e) {
			System.out.println("Método calculadora.subtrair()  Deu errado");
		}
	}
}
