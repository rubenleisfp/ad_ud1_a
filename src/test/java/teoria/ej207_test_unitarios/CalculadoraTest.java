package teoria.ej207_test_unitarios;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculadoraTest {

	@Test
	public void testSumar() {
		Calculadora calc = new Calculadora();
		int resultado = calc.sumar(3, 5);
		assertEquals(8, resultado);
	}

	@Test
	public void testRestar() {
		Calculadora calc = new Calculadora();
		int resultado = calc.restar(10, 4);
		assertEquals(6, resultado);
	}

	@Test
	public void testMultiplicar() {
		Calculadora calc = new Calculadora();
		int resultado = calc.multiplicar(2, 6);
		assertEquals(12, resultado);
	}

	@Test
	public void testDividir() {
		Calculadora calc = new Calculadora();
		int resultado = calc.dividir(10, 2);
		assertEquals(5, resultado);
	}

	@Test(expected = ArithmeticException.class)
	public void testDividirPorCero() {
		Calculadora calc = new Calculadora();
		calc.dividir(10, 0);
	}
}