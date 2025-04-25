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
     * @param file
     * @return
     * @throws IOException
     */
    public List<Alumno> getAlumnos(File file) throws IOException {
        throw new UnsupportedOperationException("A implementar por el alumno");
    }

    /**
     * Dada la ruta de un fichero recibida por parametro, la cual enlaza un fichero
     * de alumnos, devolverá la nota media de los mismos.
     *
     * @param file
     * @return
     * @throws IOException
     */
    public double getEdadMedia(File file) throws IOException {
        //TODO
        //1.Llamar a GestorFiheroBuffered para obtener una list<String> con el contenido del fichero
        //2.Transformar la linea en un alumno. Repetir el proceso para todas las lineas del fichero
        throw new UnsupportedOperationException("A implementar por el alumno");
    }

    /**
     * Recibe una lista de alumnos y la ruta del fichero, y los escribe como CSV.
     *
     * @param alumnos Lista de alumnos a escribir en el fichero.
     * @param file
     * @throws IOException
     */
    public void escribirAlumnosCsv(List<Alumno> alumnos, File file) throws IOException {
        //TODO
        //1. Transformar un alumno en una linea de texto, dónde campo se separa por ,. Repetir el proceso para todos los alumnos
        //2.-Llama al GestorFicheroBuffered para pasarle la lista de lineas
        throw new UnsupportedOperationException("A implementar por el alumno");
    }
}
