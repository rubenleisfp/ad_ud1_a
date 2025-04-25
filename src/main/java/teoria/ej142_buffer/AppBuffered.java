package teoria.ej142_buffer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppBuffered {

	public static void main(String[] args) {
		File fichero = new File("src/main/resources/fichero_buffered.txt");
		//ejemploBasico(nombreFichero);
		//imprimirPorConsola(nombreFichero);
        try {
            escribirNumeros(fichero,5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

	/**
	 * LLamar al metodo printToConsole de GestorFicheroBuffered
	 * @param fichero
	 */
	private static void imprimirPorConsola(File fichero) {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	/**
	 * Escribir una lista de numeros hasta un numeroMaximo en fichero
	 * Si el numero es impar escribira: "El numero i es impar"
	 * Si el numero es par escribira: "El numero i es par"
	 *
	 * Despues de esccribirlo llamar al metodo printToConsole para mostrar su contenido por consola
	 *
	 * @param fichero
	 * @param numeroMaximo
	 * @throws IOException
	 */
	private static void escribirNumeros(File fichero,int numeroMaximo) throws IOException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}



	/**
	 * Escribir una lista de elementos en fichero
	 * Leer la lista de elementos del fichero
	 * La lista de elementos del fichero, mostrarla por consola
	 * @param fichero
	 */
	private static void ejemploBasico(File fichero) {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}
}
