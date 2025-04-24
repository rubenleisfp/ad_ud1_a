package practicas.practica4;

import teoria.ej142.GestorFichero;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FusionadorFicheros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String ruta1 = "src/main/resources/practicas/practica4/A.txt";
        String ruta2 = "src/main/resources/practicas/practica4/B.txt";

        try {
            fusionarFicheros(ruta1, ruta2);
            System.out.println("Fichero fusionado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al fusionar ficheros: " + e.getMessage());
        }
    }

    public static void fusionarFicheros(String ruta1, String ruta2) throws IOException {
        File fichero1 = new File(ruta1);
        File fichero2 = new File(ruta2);

        if (!fichero1.exists()) {
            throw new IOException("Fichero inexistente: " + fichero1.getAbsolutePath());
        }

        if (!fichero2.exists()) {
            throw new IOException("Fichero inexistente: " + fichero2.getAbsolutePath());
        }

        String nombreFusionado = obtenerNombreSinExtension(fichero1.getName()) + obtenerNombreSinExtension(fichero2.getName());

        String carpetaPadre = fichero1.getParent();
        String rutaFinal = carpetaPadre + File.separator +nombreFusionado + ".txt";
        File ficheroFinal = new File(rutaFinal);
        if (ficheroFinal.exists()) {
            ficheroFinal.delete();
        }

        List<String> lines1 = GestorFicheroBuffered.readLines(fichero1);
        List<String> lines2 = GestorFicheroBuffered.readLines(fichero2);

        List<String> linesMerged = new ArrayList<>();
        linesMerged.addAll(lines1);
        linesMerged.addAll(lines2);

        GestorFicheroBuffered.writeLines(ficheroFinal, false, linesMerged);
    }

    private static String obtenerNombreSinExtension(String ruta) {
        String nombre = Path.of(ruta).getFileName().toString();
        int punto = nombre.lastIndexOf('.');
        return (punto > 0) ? nombre.substring(0, punto) : nombre;
    }


}
