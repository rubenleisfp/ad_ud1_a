package practicas.practica305.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Trabaja con BufferedReader y BufferedWriter
 */
public class GestorFicheroBuffered {

	/**
	 * Lee un fichero y vuelca las lineas en una lista.
	 * Si el fichero no existe lo crea y devuelve una lista vacía.
	 *
	 * @param fichero
	 * @return lista de líneas leídas
	 * @throws IOException
	 */
	public static List<String> readLines(File fichero) throws IOException {
		//TODO
		// 1.- Si el fichero no existe crearlo y devolvere una lista vacia
		// 2.- Leer el fichero y volcarlo en una lista de String
		throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}

	/**
	 * Si el fichero no existe, lo crea
	 *
	 * Vuelca las lineas recibidas como argumento al fichero, teniendo en cuenta
	 * el append para saber si tiene que sobreescribir o escribir desde cero.
	 *
	 * @param fichero
	 * @param append TRUE si va a añadir lineas al final, FALSE si sobreescribe el fichero
	 * @param lines lista de lineas a volcar en fichero
	 * @throws IOException
	 */
	public static void writeLines(File fichero, boolean append, List<String> lines) throws IOException {
		//TODO
		// 1.- Si el fichero no existe crearlo
		// 2.- Volcar las lineas recibidas en el fichero, con el append recibido como argumento
		throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}
}