package teoria.ej142_buffer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
		String linea1 = "Hola Mundo \n";
		try (FileWriter fileWriter = new FileWriter(fichero, append)) {
			fileWriter.write(linea1);
		}
	}

	/**
	 * Metodo que escribe la frase "Hola Mundo" en un fichero
	 *
	 * @param fichero
	 * @param append
	 * @throws IOException
	 */
	public static void printWrite(String fichero, boolean append) throws IOException {
		String linea1 = "Hola Mundo";
		try (FileWriter fileWriter = new FileWriter(fichero, append); PrintWriter printWriter = new PrintWriter(fileWriter)) {
			printWriter.write(linea1);
		}
	}

	/**
	 * Metodo que sirve para devolver un String con el contenido del fichero
	 *
	 * @param fichero ruta relativa o absoluta del fichero
	 * @return String con el contenido del fichero
	 * @throws IOException
	 */
	public static String read(String fichero) throws IOException {
		StringBuilder sb = new StringBuilder();
		try (FileReader fileReader = new FileReader(fichero)) {
			// leer y mostrar el contenido del archivo
			int caracter;
			while ((caracter = fileReader.read()) != -1) {
				//System.out.print((char) caracter);
				sb.append((char) caracter);
			}
		}
		return sb.toString();
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
		try (FileWriter fileWriter = new FileWriter(fichero, append)) {
			for (String line : lines) {
				fileWriter.write(line + "\n");
			}
		}
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
		try (FileWriter fileWriter = new FileWriter(fichero, append);
				PrintWriter printWriter = new PrintWriter(fileWriter)) {
			for (String line : lines) {
				//printWriter.write(line + "\n");
				printWriter.println(line);
			}
		}

	}

}
