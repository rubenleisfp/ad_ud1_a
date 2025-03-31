package teoria.ej1423_csv;

import java.util.Objects;

public class Alumno {

    private String nombre;
    private int edad;
    private String correo;

    public Alumno(String nombre, int edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return edad == alumno.edad && Objects.equals(nombre, alumno.nombre) && Objects.equals(correo, alumno.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, correo);
    }
}
