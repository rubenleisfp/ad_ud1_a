package teoria.ej1423_csv;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppAlumnos {
    public static void main(String[] args) {
        // Crear una instancia de GestorFicheroALumnosCsv
        GestorFicheroAlumnosCsv gestor = new GestorFicheroAlumnosCsv();

        // Ruta del fichero CSV en la carpeta resources/1_4_2_3_csv
        String directoryPath = "src/main/resources/1_4_2_3_csv";
        String filePath = directoryPath + "/alumnos_output.csv";

        // Crear una lista de alumnos para escribir en el fichero
        List<Alumno> listaAlumnos = new ArrayList<>();
        listaAlumnos.add(new Alumno("Juan", 28, "juan@example.com"));
        listaAlumnos.add(new Alumno("María", 32, "maria@example.com"));
        listaAlumnos.add(new Alumno("Pedro", 22, "pedro@example.com"));

        try {
            // Escribir la lista de alumnos en un fichero CSV
            gestor.escribirAlumnosCsv(listaAlumnos, new File(filePath));
            System.out.println("Lista de alumnos escrita en el fichero CSV.");

            // Leer la lista de alumnos desde el fichero CSV
            List<Alumno> alumnosLeidos = gestor.getAlumnos(new File(filePath));
            System.out.println("Alumnos leídos desde el fichero CSV:");
            for (Alumno alumno : alumnosLeidos) {
                System.out.println(alumno);
            }

            // Calcular y mostrar la edad media de los alumnos
            double edadMedia = gestor.getEdadMedia(new File(filePath));
            System.out.println("Edad media de los alumnos: " + edadMedia);

        } catch (IOException e) {
            System.err.println("Error al manejar el fichero CSV: " + e.getMessage());
        }
    }
}
