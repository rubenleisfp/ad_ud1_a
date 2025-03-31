package teoria.ej207_test_unitarios;

public class ConversorTemperatura {
	public double celsiusAFahrenheit(double celsius) {
		//(100 °C × 9 / 5) + 32 = 212 °F
		double f = (celsius *9 /5) + 32;
		return f;
	}

	public double fahrenheitACelsius(double fahrenheit) {
		double c = (fahrenheit-32) * 5 /9;
		return c;
	}
}