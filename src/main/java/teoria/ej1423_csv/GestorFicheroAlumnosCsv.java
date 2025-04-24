package teoria.ej1423_csv;

import teoria.ej142_buffer.GestorFicheroBuffered;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorFicheroAlumnosCsv {

    Utilidades utilidades = new Utilidades();

    /**
     *  Dada la ruta de un fichero recibida por parametro, la cual enlaza un fichero
     *  de alumnos, devolverá la una lista de Alumnos
     *
     * @param fichero
     * @return
     * @throws IOException
     */
    public List<Alumno> getAlumnos(File fichero) throws IOException {
        List<String> lineasAlumnos = GestorFicheroBuffered.readLines(fichero);
        List<Alumno> alumnos = utilidades.getAlumnosFromLineas(lineasAlumnos);
        return alumnos;
    }

    /**
     * Dada la ruta de un fichero recibida por parametro, la cual enlaza un fichero
     * de alumnos, devolverá la nota media de los mismos.
     *
     * @param fichero
     * @return
     * @throws IOException
     */
    public double getEdadMedia(File fichero) throws IOException {
        //TODO
        //1.Llamar a GestorFiheroBuffered para obtener una list<String> con el contenido del fichero
        //2.Transformar la linea en un alumno. Repetir el proceso para todas las lineas del fichero
        List<Alumno> alumnos = getAlumnos(fichero);
        double edadMedia = 0;
        for (Alumno alumno : alumnos) {
            edadMedia += alumno.getEdad();
        }
        edadMedia = edadMedia / alumnos.size();
        return edadMedia;
    }

    /**
     * Recibe una lista de alumnos y la ruta del fichero, y los escribe como CSV.
     *
     * @param alumnos Lista de alumnos a escribir en el fichero.
     * @param fichero donde se va a guardar el CSV.
     * @throws IOException
     */
    public void escribirAlumnosCsv(List<Alumno> alumnos, File fichero) throws IOException {
        //TODO
        //1. Transformar un alumno en una linea de texto, dónde campo se separa por ,. Repetir el proceso para todos los alumnos
        //2.-Llama al GestorFicheroBuffered para pasarle la lista de lineas
        List<String> lines = new ArrayList<>();

        // Añadir la cabecera
        lines.add("Nombre,Edad,Correo");
        lines.addAll(utilidades.getLineasAlumnos(alumnos));

        // Escribir las líneas en el fichero CSV usando GestorFicheroBuffered
        GestorFicheroBuffered.writeLines(fichero, false, lines);
    }
}
