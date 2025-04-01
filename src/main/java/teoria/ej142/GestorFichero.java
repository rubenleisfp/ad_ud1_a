package teoria.ej142;

import java.io.*;
import java.util.List;

/**
 * Trabaja con FileReader y FileWriter
 */
public class GestorFichero {

	/**
	 * Metodo que escribe la frase "Hola Mundo" en un fichero. Incluye el \n
	 *
	 * @param fichero
	 * @param append
	 * @throws IOException
	 */
	public static void write(String fichero, boolean append) throws IOException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	/**
	 * Metodo que escribe la frase "Hola Mundo" en un fichero
	 *
	 * @param fichero
	 * @param append
	 * @throws IOException
	 */
	public static void printWrite(String fichero, boolean append) throws IOException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	/**
	 * Metodo que sirve para devolver un String con el contenido del fichero
	 *
	 * @param fichero ruta relativa o absoluta del fichero
	 * @return String con el contenido del fichero
	 * @throws IOException
	 */
	public static String read(String fichero) throws IOException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	/**
	 * Metodo que sirve para escribir una serie de lineas en fichero
	 *
	 * Podemos anadirlas o sobreescribir el fichero.
	 * Es necesario agregar el /n para hacer salto de linea
	 *
	 * @param fichero ruta relativa o absoluta del fichero
	 * @param append true anhade mas filas al final, false sobreescribe el fichero
	 * @param lines lista de lineas que quiero escribir en el fichero
	 * @throws IOException
	 */
	public static void write(String fichero, boolean append, List<String> lines) throws IOException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	public static void writeBeforeJava8(String fichero, boolean append, List<String> lines) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fichero, append);
			for (String line : lines) {
				fileWriter.write(line + "\n");
			}
		} catch (IOException e) {
			System.out.println("Error consultando el fichero: " + e);
        } finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					System.out.println("Error cerrando el fichero: " + e);
				}
			}
		}
	}

	/**
	 * Metodo que sirve para escribir una serie de lineas en fichero
	 *
	 * Podemos anadirlas o sobreescribir el fichero.
	 *
	 * @param fichero ruta relativa o absoluta del fichero
	 * @param append true anhade mas filas al final, false sobreescribe el fichero
	 * @param lines lista de lineas que quiero escribir en el fichero
	 * @throws IOException
	 */
	public static void printWrite(String fichero, boolean append, List<String> lines) throws IOException {
		throw new UnsupportedOperationException("A implementar por el alumno");

	}

}
