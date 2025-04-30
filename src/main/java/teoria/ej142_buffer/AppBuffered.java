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
            //ejemploBasico(fichero);
            //imprimirPorConsola(fichero);
            escribirNumeros(fichero,5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void imprimirPorConsola(File fichero) throws IOException {
        GestorFicheroBuffered.printFileToConsole(fichero);
    }

    /**
     * Escribe lineas en un fichero hasta un entero dado.
     * Si la linea es impar: "linea 1 es impar"
     * Si la linea es par: "linea 2 es par"
     *
     *
     * @param fichero
     * @param numeroMaximo
     * @throws IOException
     */
    private static void escribirNumeros(File fichero, int numeroMaximo) throws IOException {
        List<String> lineas = new ArrayList<>();
        for (int i=1; i<numeroMaximo;i++) {
            String linea = "";
            if (i%2 ==0) {
                linea ="linea " + i + " es par";
            } else {
                linea ="linea " + i + " es imppar";
            }
            lineas.add(linea);
        }
        GestorFicheroBuffered.writeLines(fichero, false, lineas);
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
