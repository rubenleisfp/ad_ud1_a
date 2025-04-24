package teoria.ej142;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppFileReaderWriter {

    public static void main(String[] args) {
        //ejercicioA();
        //ejercicioB();
        ejercicioC();
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
        List<String> lines = new ArrayList<>();
        lines.add("Linea1");
        lines.add("Linea2");
        lines.add("Linea3");


        boolean append = false;

        String ficheroWriter = "file_sample_writer.txt";
        String ficheroPrint = "file_sample_print.txt";

        try {
            GestorFichero.write(ficheroWriter, append,lines);
            GestorFichero.printWrite(ficheroPrint, append,lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            String contenidoFicheroWrite = GestorFichero.read(ficheroWriter);
            System.out.println("contenidoFicheroWriter:");
            System.out.println(contenidoFicheroWrite);

            String contenidoFicheroPrint = GestorFichero.read(ficheroPrint);
            System.out.println("contenidoFicheroPrint:");
            System.out.println(contenidoFicheroPrint);
        } catch (IOException e) {
            System.out.println("Error al leer del fichero: " + e);
        }
    }

    /**
     * Escribir una lista de animales en fichero
     *
     */
    private static void ejercicioC() {
        List<Animal> animales = new ArrayList<>();
        Animal lince = new Animal("lince", 58,4, false);
        Animal lobo = new Animal("lobo", 55,4, false);
        Animal wombat = new Animal("wombat", 40,4, false);
        Animal kakapo = new Animal("kakapo", 37,2, true);

        animales.add(lince);
        animales.add(lobo);
        animales.add(wombat);
        animales.add(kakapo);

        boolean append = false;
        List<String> lineas = getLinesFromAnimals(animales);

        try {
            GestorFichero.write("animales.txt", append,lineas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static List<String> getLinesFromAnimals(List<Animal> animales) {
        List<String> lineas = new ArrayList<>();
        for (Animal animal: animales) {
            String linea = getLineFromAnimal(animal);
            lineas.add(linea);
        }
        return lineas;
    }
    private static String getLineFromAnimal(Animal animal) {
        StringBuilder sb = new StringBuilder();
        sb.append(animal.getNombre());
        sb.append(";");
        sb.append(animal.getVelocidad());
        sb.append(";");
        sb.append(animal.getCantidadPatas());
        sb.append(";");
        sb.append(animal.isPuedeVolar());
        return sb.toString();
    }
}
