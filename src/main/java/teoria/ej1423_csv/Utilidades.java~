package teoria.ej1423_csv;

import java.util.ArrayList;
import java.util.List;

public class Utilidades {

    /**
     * Transforma alumnos en lineas
     * @param alumnos
     * @return Juan, 28, juan@example.com
     *         María,32,maria@example.com
     */
    public List<String> getLineasAlumnos(List<Alumno> alumnos) {
        List<String> lineas = new ArrayList<>();
        for (Alumno alumno: alumnos) {
            String linea = getLineaAlumno(alumno);
            lineas.add(linea);
        }
        return lineas;
    }

    /**
     * Transforma un alumno en una linea
     * @param alumno
     * @return Juan,28,juan@example.com
     */
    public String getLineaAlumno(Alumno alumno) {
        String linea = alumno.getNombre() + "," + alumno.getEdad() + "," + alumno.getCorreo();
        return linea;
    }

    /**
     * Transforma lineas en alumnos
     *
     * @param lineas Nombre,Edad,Correo
     *               Juan,28,juan@example.com
     *               María,32,maria@example.com
     * @return
     */
    public List<Alumno> getAlumnosFromLineas(List<String> lineas) {
        //Quitamos la cabecera
        lineas.remove(0);
        List<Alumno> alumnos = new ArrayList<>();
        for (String linea : lineas) {
            Alumno alumno = getAlumnoFromLine(linea);
            alumnos.add(alumno);
        }
        return alumnos;
    }

    /**
     * Transforma una linea en alumno
     *
     * @param lineaAlumno María,32,maria@example.com
     * @return
     */
    private Alumno getAlumnoFromLine(String lineaAlumno) {
        String[] lineaAlumnoArray = lineaAlumno.split(",");
        Alumno alumno = new Alumno(lineaAlumnoArray[0],Integer.valueOf(lineaAlumnoArray[1]),lineaAlumnoArray[2]);
        return alumno;
    }
}
