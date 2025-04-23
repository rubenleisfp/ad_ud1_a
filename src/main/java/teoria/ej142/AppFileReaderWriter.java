package teoria.ej142;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppFileReaderWriter {

    public static void main(String[] args) {
        //ejercicioA();
        ejercicioB();
        //ejercicioC();
    }

    private static void ejercicioA() {
        boolean append = false;

        String ficheroWriter = "file_sample_writer.txt";
        String ficheroPrint = "file_sample_print.txt";

        try {
            GestorFichero.write(ficheroWriter, append);
            GestorFichero.printWrite(ficheroPrint, append);
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e);
        }

        try {
            String contenidoFichero = GestorFichero.read(ficheroWriter);
            System.out.println("contenidoFichero:");
            System.out.println(contenidoFichero);
        } catch (IOException e) {
            System.out.println("Error al leer del fichero: " + e);
        }
    }

    /**
     * Escribir los impares del 1 al 10 en un fichero
     *
     * Leer el fichero y mostrar por consola
     *
     */
    private static void ejercicioB() {

    }

    /**
     * Escribir una lista de animales en fichero
     *
     */
    private static void ejercicioC() {
        throw new UnsupportedOperationException("A implementar por el alumno");
    }
    private static List<String> getLinesFromAnimals(List<Animal> animales) {
        throw new UnsupportedOperationException("A implementar por el alumno");
    }
    private static String getLineFromAnimal(Animal animal) {
        throw new UnsupportedOperationException("A implementar por el alumno");
    }
}
