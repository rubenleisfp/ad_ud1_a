package teoria.ej142_buffer;

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
		List<String> lineas = new ArrayList<String>();
		try (FileReader fr = new FileReader(fichero); BufferedReader br = new BufferedReader(fr)) {
			String linea;
			while ((linea = br.readLine()) != null) {
				
				lineas.add(linea);
			}
		}
		return lineas;
	}

	/**
	 * Recibe una lista de lineas que desea volcar a fichero
	 * 
	 * @param fichero ruta del fichero
	 * @param append TRUE si va a añadir lineas al final, FALSE si sobreescribe el fichero
	 * @param lines lista de lineas a volcar en fichero
	 * @throws IOException
	 */
	public static void writeLines(File fichero, boolean append, List<String> lines) throws IOException {
		// Con try resources no tenemos que cerrar los recursos, Java ya lo hace por
		// nosotros
		try (FileWriter fw = new FileWriter(fichero, append); BufferedWriter bw = new BufferedWriter(fw)) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		}
	}
	
	public static void printFileToConsole(File fichero) throws IOException {
		List<String> lines = readLines(fichero);
		for (String line: lines) {
			System.out.println(line);
		}
	}
}
