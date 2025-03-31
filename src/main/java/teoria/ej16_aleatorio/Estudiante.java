package teoria.ej16_aleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Estudiante {
    private String nombre;
    private int edad;
    private double calificacion;

    // Constructor
    public Estudiante(String nombre, int edad, double calificacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificacion = calificacion;
    }

    // Métodos getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getCalificacion() {
        return calificacion;
    }

    // Método para escribir el registro de un estudiante en el archivo
    public void escribirRegistro(RandomAccessFile file) throws IOException {
        file.writeUTF(String.format("%-20s", nombre)); // Escribir nombre (máximo 20 caracteres)
        file.writeInt(edad); // Escribir edad
        file.writeDouble(calificacion); // Escribir calificación
    }

    // Método para leer el registro de un estudiante desde el archivo
    public void leerRegistro(RandomAccessFile file) throws IOException {
        nombre = file.readUTF().trim(); // Leer nombre
        edad = file.readInt(); // Leer edad
        calificacion = file.readDouble(); // Leer calificación
    }
}
