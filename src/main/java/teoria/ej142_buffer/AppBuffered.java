package teoria.ej142_buffer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppBuffered {

	public static void main(String[] args) {
		String nombreFichero = "C:\\DEV\\buffered.txt";
		File fichero = new File(nombreFichero);
		ejemploBasico(fichero);
		imprimirPorConsola(fichero);
        try {
            escribirNumeros(fichero,5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

	private static void imprimirPorConsola(File fichero) {
        try {
            GestorFicheroBuffered.printFileToConsole(fichero);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

	private static void escribirNumeros(File fichero,int numeroMaximo) throws IOException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	private static List<String> obtenerListaNumeros(int numeroMaximo) {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	private static void ejemploBasico(File fichero) {
		
		List<String> lines = new ArrayList<String>();
		lines.add("UNO");
		lines.add("DOS");
		try {
			GestorFicheroBuffered.writeLines(fichero, false,lines);
		} catch (IOException e) {
			System.out.println("Error al escribir el fichero: " + lines);
		}
		
		try {
			lines = GestorFicheroBuffered.readLines(fichero);
			for (String line : lines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("Error al leer el fichero: " + lines);
		}
		
	}
	
	
	
	

	

	




}
