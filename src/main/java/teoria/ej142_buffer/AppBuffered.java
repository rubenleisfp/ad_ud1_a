package teoria.ej142_buffer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppBuffered {

    public static void main(String[] args) {
        String nombreFichero = "src/main/resources/buffered.txt";
        File fichero = new File(nombreFichero);

        try {
            ejemploBasico(fichero);
            //imprimirPorConsola(fichero);
            //escribirNumeros(fichero,5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void imprimirPorConsola(File fichero) throws IOException {
        GestorFicheroBuffered.printFileToConsole(fichero);
    }

    private static void escribirNumeros(File fichero, int numeroMaximo) throws IOException {

    }

    private static void ejemploBasico(File fichero) throws IOException {
        List<String> lines = new ArrayList<String>();
        lines.add("UNO");
        lines.add("DOS");
        GestorFicheroBuffered.writeLines(fichero, false, lines);
        lines = GestorFicheroBuffered.readLines(fichero);
        for (String line : lines) {
            System.out.println(line);
        }

    }


}
