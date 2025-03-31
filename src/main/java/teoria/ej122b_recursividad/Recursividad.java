package teoria.ej122b_recursividad;

import java.io.File;
import java.io.IOException;

public class Recursividad {
	public static void main(String[] args) throws IOException {
		File fichero = new File("src/main/resources/1_1_recursividad");
		mostrarCarpeta(fichero);
	}

	// una funcion recursiva que se llame a si misma
	public static void mostrarCarpeta(File fichero) {
		throw new UnsupportedOperationException("A completar por el alumno");
	}
}