package teoria.ej17_xml_jaxb.aula;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class Aula {

    private String nombreAula;

    private List<Alumno> alumnos;

    public Aula() {

    }

    public Aula(String nombreAula, List<Alumno> alumnos) {
        this.nombreAula = nombreAula;
        this.alumnos = alumnos;
    }

    public String getNombreAula() {
        return nombreAula;
    }

    public void setNombreAula(String nombreAula) {
        this.nombreAula = nombreAula;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }
    @XmlElement(name = "alumno")
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
