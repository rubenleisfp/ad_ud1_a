package practicas.practica201;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BufferedReaderWriter {

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

	public static void write(String nombreFichero, boolean append, List<String> lines) throws IOException {
		// Con try resources no tenemos que cerrar los recursos, Java ya lo hace por
		// nosotros
		try (FileWriter fw = new FileWriter(nombreFichero); BufferedWriter bw = new BufferedWriter(fw)) {

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
