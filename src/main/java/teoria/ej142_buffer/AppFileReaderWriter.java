package teoria.ej142_buffer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppFileReaderWriter {

    public static void main(String[] args) {
        ejercicioA();
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
        boolean append = false;
        String ficheroWriter = "file_sample_writer.txt";
        String ficheroPrint = "file_sample_print.txt";


        //Escribimos los numero impares existentes entre 1 y 10 en una lista
        List<String> lines = new ArrayList<String>();
        for (int i =0;i<10;i++ ) {
            if (i %2 ==1) {
                lines.add("Numero impar:" + String.valueOf(i));
            }
        }

        try {
            GestorFichero.write(ficheroWriter, append, lines);
           // GestorFichero.printWrite(ficheroPrint, append, lines);

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e);
        }

        try {
            GestorFichero.read(ficheroWriter);
        } catch (IOException e) {
            System.out.println("Error al leer del fichero: " + e);
        }
    }

    /**
     * Escribir una lista de animales en fichero
     *
     */
    private static void ejercicioC() {
        List<Animal> animales = new ArrayList<Animal>();

        animales.add(new Animal("vaca", 15, 4, false));
        animales.add(new Animal("garza", 50, 2, true));
        animales.add(new Animal("erizo", 7, 4, false));
        animales.add(new Animal("pingüino", 20, 2, false));
        animales.add(new Animal("cerdo", 15, 4, false));

        List<String> lines = new ArrayList<String>();
        lines = getLinesFromAnimals(animales);

        try {
            GestorFichero.printWrite("C:\\DEV\\animals.txt", false, lines);
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e);
        }

    }
    private static List<String> getLinesFromAnimals(List<Animal> animales) {
        List<String> lines = new ArrayList<>();
		for (Animal animal : animales) {
            String line = getLineFromAnimal(animal);
            lines.add(line);

        }
        return lines;
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
