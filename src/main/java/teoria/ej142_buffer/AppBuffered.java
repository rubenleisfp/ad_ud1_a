package teoria.ej142_buffer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppBuffered {

	public static void main(String[] args) {
		String nombreFichero = "C:\\DEV\\buffered.txt";
		//ejemploBasico(nombreFichero);
		//imprimirPorConsola(nombreFichero);
        try {
            escribirNumeros(nombreFichero,5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

	private static void imprimirPorConsola(String nombreFichero) {
		try {
			GestorFicheroBuffered.printFileToConsole(nombreFichero);
		} catch (IOException e) {
			System.out.println("Error al escribir fichero: " + e);
		}
	}




	private static void escribirNumeros(String nombreFichero,int numeroMaximo) throws IOException {
		List<String> lines = obtenerListaNumeros(numeroMaximo);
		GestorFicheroBuffered.writeLines(nombreFichero, false,lines);
		imprimirPorConsola(nombreFichero);
	}


	private static List<String> obtenerListaNumeros(int numeroMaximo) {
		List<String> lines = new ArrayList<String>();
		for (int i=1; i<numeroMaximo;i++) {
			if (i%2==0) {
				lines.add(i + " es un número par");
			} else {
				lines.add(i + " es un número impar");
			}
		}
		return lines;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private static void ejemploBasico(String nombreFichero) {
		
		List<String> lines = new ArrayList<String>();
		lines.add("UNO");
		lines.add("DOS");
		try {
			GestorFicheroBuffered.writeLines(nombreFichero, false,lines);
		} catch (IOException e) {
			System.out.println("Error al escribir el fichero: " + lines);
		}
		
		try {
			lines = GestorFicheroBuffered.readLines(nombreFichero);
			for (String line : lines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("Error al leer el fichero: " + lines);
		}
		
	}
	
	
	
	

	

	




}
