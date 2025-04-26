package practicas.practica201;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppContadorPalabras {

	public static void main(String[] args) {
		File fichero = new File("src/main/resources/practicas/practica201/contador_palabras.txt");
		String nombreFicheroResultado = "contador_resultado.txt";
		try {
			int numPalabras = contarPalabras(fichero);
			escribirNumPalabras(fichero,numPalabras);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}
	
	public static int contarPalabras(File fichero) throws IOException {
		int numPalabras = 0;
		List<String> lines = GestorFicheroBuffered.readLines(fichero);
		for (String line: lines) {
			String[] palabras = line.split(" ");
			numPalabras += palabras.length;
		}
		
		return numPalabras;
	}
	
	public static void escribirNumPalabras(File fichero, int numPalabras) throws IOException {
		List<String> lines = new ArrayList<String>();
		lines.add("El numero de palabras del fichero es: " + numPalabras);
		GestorFicheroBuffered.writeLines(fichero, false, lines);
	}

}
