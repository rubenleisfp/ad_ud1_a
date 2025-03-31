package teoria.ej17_xml_jaxb.aula;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlRootElement(name = "alumno")
@XmlType(propOrder = { "id","nombre", "apellido1", "apellido2","edad","calificaciones" })
public class Alumno {

    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private List<Calificacion> calificaciones;

    public Alumno() {

    }

    public Alumno(int id,String nombre, String apellido1, String apellido2, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    @XmlElement(name = "calificacion")
    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

}
