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
		throw new UnsupportedOperationException("Test a completar por el alumno");
	}

	@Test
	public void testMultiplicar() {
		throw new UnsupportedOperationException("Test a completar por el alumno");
	}

	@Test
	public void testDividir() {
		throw new UnsupportedOperationException("Test a completar por el alumno");
	}

	@Test
	public void testDividirPorCero() {
		throw new UnsupportedOperationException("Test a completar por el alumno");
	}
}