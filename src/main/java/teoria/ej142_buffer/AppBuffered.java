package teoria.ej142_buffer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppBuffered {

	public static void main(String[] args) {
		String nombreFichero = "C:\\DEV\\buffered.txt";
		//ejemploBasico(nombreFichero);
		//imprimirPorConsola(nombreFichero);
        try {
            escribirNumeros(new File(nombreFichero),5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

	private static void imprimirPorConsola(File fichero) {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	private static void escribirNumeros(File fichero,int numeroMaximo) throws IOException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	private static List<String> obtenerListaNumeros(int numeroMaximo) {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	private static void ejemploBasico(File fichero) {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}
}
