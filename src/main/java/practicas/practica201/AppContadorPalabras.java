package practicas.practica201;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppContadorPalabras {

	public static void main(String[] args) {
		String nombreFichero = "src/main/resources/practica202/contador_palabras.txt";
		String nombreFicheroResultado = "contador_resultado.txt";
		try {
			int numPalabras = contarPalabras(nombreFichero);
			escribirNumPalabras(nombreFicheroResultado,numPalabras);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}
	
	public static int contarPalabras(String nombreFichero) throws IOException {
		int numPalabras = 0;
		List<String> lines = BufferedReaderWriter.read(nombreFichero);
		for (String line: lines) {
			String[] palabras = line.split(" ");
			numPalabras += palabras.length;
		}
		
		return numPalabras;
	}
	
	public static void escribirNumPalabras(String nombreFichero, int numPalabras) throws IOException {
		List<String> lines = new ArrayList<String>();
		lines.add("El numero de palabras del fichero es: " + numPalabras);
		BufferedReaderWriter.write(nombreFichero, false, lines);
	}

}
