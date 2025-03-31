package teoria.ej16_aleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("estudiantes.dat", "rw")) {
            // Permitir al usuario ingresar información de estudiantes
            Estudiante estudiante1 = new Estudiante("Juan Perez", 20, 85.5);
            Estudiante estudiante2 = new Estudiante("Maria Gonzalez", 22, 90.2);

            // Escribir registros en el archivo
            estudiante1.escribirRegistro(file);
            estudiante2.escribirRegistro(file);

            // Mover el puntero al inicio del archivo para leer los estudiantes
            file.seek(0);

            // Leer y mostrar información de estudiantes
            Estudiante estudianteLeido1 = new Estudiante("", 0, 0);
            Estudiante estudianteLeido2 = new Estudiante("", 0, 0);

            estudianteLeido1.leerRegistro(file);
            estudianteLeido2.leerRegistro(file);

            System.out.println("Estudiante 1:");
            System.out.println("Nombre: " + estudianteLeido1.getNombre());
            System.out.println("Edad: " + estudianteLeido1.getEdad());
            System.out.println("Calificación: " + estudianteLeido1.getCalificacion());

            System.out.println("Estudiante 2:");
            System.out.println("Nombre: " + estudianteLeido2.getNombre());
            System.out.println("Edad: " + estudianteLeido2.getEdad());
            System.out.println("Calificación: " + estudianteLeido2.getCalificacion());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
