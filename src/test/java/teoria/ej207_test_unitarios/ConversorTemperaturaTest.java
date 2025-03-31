package teoria.ej207_test_unitarios;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConversorTemperaturaTest {

    @Test
    public void testCelsiusAFahrenheit() {
        ConversorTemperatura conversor = new ConversorTemperatura();
        double resultado = conversor.celsiusAFahrenheit(100);
        assertEquals(212, resultado, 0.001);
    }

    @Test
    public void testFahrenheitACelsius() {
        ConversorTemperatura conversor = new ConversorTemperatura();
        double resultado = conversor.fahrenheitACelsius(212);
        assertEquals(100, resultado, 0.001);
    }

    @Test
    public void testCelsiusAFahrenheitNegativo() {
        ConversorTemperatura conversor = new ConversorTemperatura();
        double resultado = conversor.celsiusAFahrenheit(-40);
        assertEquals(-40, resultado, 0.001);
    }

    @Test
    public void testFahrenheitACelsiusNegativo() {
        ConversorTemperatura conversor = new ConversorTemperatura();
        double resultado = conversor.fahrenheitACelsius(-40);
        assertEquals(-40, resultado, 0.001);
    }
}