package teoria.ej1423_csv;

import java.util.Comparator;

public class AlumnoComparator implements Comparator<Alumno> {
    @Override
    public int compare(Alumno a1, Alumno a2) {
      // return a2.getNombre().compareTo(a1.getNombre());
        return a1.getCorreo().compareTo(a2.getCorreo());
    }
}
