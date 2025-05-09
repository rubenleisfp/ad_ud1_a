package teoria.ej1423_csv;

import java.util.ArrayList;
import java.util.List;

public class Utilidades {

    /**
     * Transforma alumnos en lineas
     *
     * @param alumnos
     * @return Juan, 28, juan@example.com
     * María,32,maria@example.com
     */
    public List<String> getLineasAlumnos(List<Alumno> alumnos) {

        List<String> lineas = new ArrayList<>();
        lineas.add("Nombre,Edad,Correo");
        for (Alumno alumno : alumnos) {
            String linea = getLineaAlumno(alumno); //Juan, 28, juan@example.com
            lineas.add(linea);
        }
        return lineas;
    }

    /**
     * Transforma un alumno en una linea
     *
     * @param alumno
     * @return Juan, 28, juan@example.com
     */
    public String getLineaAlumno(Alumno alumno) {
        StringBuilder sb = new StringBuilder();
        sb.append(alumno.getNombre());
        sb.append(",");
        sb.append(alumno.getEdad());
        sb.append(",");
        sb.append(alumno.getCorreo());
        return sb.toString();
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
        List<Alumno> alumnos = new ArrayList<>();
        //Quitamos la cabecera
        lineas.remove(0);
        for (String linea: lineas) {
            alumnos.add(getAlumnoFromLine(linea));
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
        Alumno alumno = new Alumno();
        String[] camposAlumno = lineaAlumno.split(","); // ["Maria", 32, "maria@example.com"]
        alumno.setNombre(camposAlumno[0]);
        alumno.setEdad(Integer.valueOf(camposAlumno[1]));
        alumno.setCorreo(camposAlumno[2]);
        return alumno;

    }
}
