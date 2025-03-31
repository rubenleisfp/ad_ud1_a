package practicas.practica9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Trabaja con BufferedReader y BufferedWriter
 */
public class GestorBuffered {

	/**
	 * Lee un fichero y vuelva las lineas en una lista
	 * @param nombreFichero 
	 * @return
	 * @throws IOException
	 */
	public static List<String> read(String nombreFichero) throws IOException {
		// Con try resources no tenemos que cerrar los recursos, Java ya lo hace por
		// nosotros
		List<String> lineas = new ArrayList<String>();
		try (FileReader fr = new FileReader(nombreFichero); BufferedReader br = new BufferedReader(fr)) {
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
	 * @param nombreFichero 
	 * @param append TRUE si va a añadir lineas al final, FALSE si sobreescribe el fichero
	 * @param lines lista de lineas a volcar en fichero
	 * @throws IOException
	 */
	public static void writeLines(String nombreFichero, boolean append, List<String> lines) throws IOException {
		// Con try resources no tenemos que cerrar los recursos, Java ya lo hace por
		// nosotros
		try (FileWriter fw = new FileWriter(nombreFichero, append); BufferedWriter bw = new BufferedWriter(fw)) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		}
	}
	
	public static void printFileToConsole(String nombreFichero) throws IOException {
		List<String> lines = read(nombreFichero);
		for (String line: lines) {
			System.out.println(line);
		}
		
	}
}
