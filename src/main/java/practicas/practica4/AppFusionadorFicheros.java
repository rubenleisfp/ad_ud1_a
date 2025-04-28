package practicas.practica4;

import java.io.*;

public class AppFusionadorFicheros {

    public static void main(String[] args) {
        String ruta1 = "src/main/resources/practicas/practica4/fich1.txt";
        File fichero1 = new File(ruta1);

        String ruta2 = "src/main/resources/practicas/practica4/fich2.txt";
        File fichero2 = new File(ruta2);

        try {
            fusionarFicheros(fichero1, fichero2);
            System.out.println("Fichero fusionado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al fusionar ficheros: " + e.getMessage());
        }
    }

    /**
     * Fusiona dos archivos en uno nuevo.
     *
     * <p>
     *     El nombre del archivo resultante se crea concatenando el nombre sin extensión
     *     de los dos archivos, y se le coloca la extensión .txt.
     * </p>
     * <p>
     *     El archivo resultante se crea en el mismo directorio que el primer archivo.
     * </p>
     *
     * @param fichero1 el primer archivo a fusionar
     * @param fichero2 el segundo archivo a fusionar
     * @throws IOException si ocurre un error al leer o escribir en los archivos
     */
    public static void fusionarFicheros(File fichero1, File fichero2) throws IOException {
        throw new UnsupportedOperationException("A implementar por el alumno");
    }

    /**
     * Obtiene el nombre de un archivo sin su extensión.
     *
     * @param file el archivo del cual se desea obtener el nombre sin extensión
     * @return el nombre del archivo sin la extensión, o el nombre completo si no tiene extensión
     */
    private static String obtenerNombreSinExtension(File file) {
        String nombre = file.getName();
        int punto = nombre.lastIndexOf('.');
        return (punto > 0) ? nombre.substring(0, punto) : nombre;
    }
}
