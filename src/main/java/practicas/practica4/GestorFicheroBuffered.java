package practicas.practica4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Trabaja con BufferedReader y BufferedWriter
 */
public class GestorFicheroBuffered {

	/**
	 * Lee un fichero y vuelva las lineas en una lista
	 * @param fichero
	 * @return
	 * @throws IOException
	 */
	public static List<String> readLines(File fichero) throws IOException {
		// Con try resources no tenemos que cerrar los recursos, Java ya lo hace por
		// nosotros
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	/**
	 * Recibe una lista de lineas que desea volcar a fichero
	 *
	 * @param fichero
	 * @param append TRUE si va a añadir lineas al final, FALSE si sobreescribe el fichero
	 * @param lines lista de lineas a volcar en fichero
	 * @throws IOException
	 */
	public static void writeLines(File fichero, boolean append, List<String> lines) throws IOException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	public static void printFileToConsole(File fichero) throws IOException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}
}