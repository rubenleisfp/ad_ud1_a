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
     * @param filePath ruta del fichero de alumnos
     * @return
     * @throws IOException
     */
    public List<Alumno> getAlumnos(String filePath) throws IOException {
        List<String> lineas = GestorFicheroBuffered.readLines(new File(filePath));
        return utilidades.getAlumnosFromLineas(lineas);
    }

    /**
     * Dada la ruta de un fichero recibida por parametro, la cual enlaza un fichero
     * de alumnos, devolverá la nota media de los mismos.
     *
     * @param filePath ruta del fichero de alumnos
     * @return
     * @throws IOException
     */
    public double getEdadMedia(String filePath) throws IOException {
        List<Alumno> alumnos = this.getAlumnos(filePath);
        double edadMedia = 0;
        for (Alumno alumno: alumnos) {
            edadMedia = edadMedia + alumno.getEdad();

        }
        edadMedia = edadMedia /alumnos.size();
        return edadMedia;
    }

    public List<Alumno> getAlumnosMayores(String filePath, int edadCriba) throws IOException {
        List<Alumno> alumnosMayores = new ArrayList<>();
        List<Alumno> alumnosFichero = this.getAlumnos(filePath);
        for (Alumno alumnoFichero: alumnosFichero) {
            if (alumnoFichero.getEdad() > edadCriba) {
                alumnosMayores.add(alumnoFichero);
            }
        }
        alumnosMayores.sort(new AlumnoComparator());
        return alumnosMayores;

    }

    /**
     * Recibe una lista de alumnos y la ruta del fichero, y los escribe como CSV.
     *
     * @param alumnos Lista de alumnos a escribir en el fichero.
     * @param filePath Ruta del fichero donde se va a guardar el CSV.
     * @throws IOException
     */
    public void escribirAlumnosCsv(List<Alumno> alumnos, String filePath) throws IOException {
        //TODO
        //1. Transformar un alumno en una linea de texto, dónde campo se separa por ,. Repetir el proceso para todos los alumnos
        //2.-Llama al GestorFicheroBuffered para pasarle la lista de lineas
        List<String> lineas = utilidades.getLineasAlumnos(alumnos);
        GestorFicheroBuffered.writeLines(new File(filePath), false, lineas);
    }
}
