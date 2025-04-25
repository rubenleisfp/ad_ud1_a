package teoria.ej17_xml_jaxb.aula;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AulaApp {

	AulaConverter aulaConverter = new AulaConverter();

	public static void main(String[] args) throws JAXBException, IOException {
		AulaApp app = new AulaApp();
		app.marshallAula();

	}

	public void marshallAula() throws JAXBException, IOException {

//		Calificacion caAdRuben = new Calificacion("AD", 2);
//		Calificacion caPmRuben = new Calificacion("PM", 4);
//		List<Calificacion> casRuben = new ArrayList<>();
//		casRuben.add(caAdRuben);
//		casRuben.add(caPmRuben);
//
//		Alumno alumnoRuben = new Alumno();
//		alumnoRuben.setId(1);
//		alumnoRuben.setNombre("Ruben");
//		alumnoRuben.setApellido1("Leis");
//		alumnoRuben.setApellido1("Rodriguez");
//		alumnoRuben.setEdad(41);
//		alumnoRuben.setCalificaciones(casRuben);
//
//		Calificacion caAdAlberto = new Calificacion("AD", 8);
//		Calificacion caPmAlberto = new Calificacion("PM", 9);
//		List<Calificacion> casAlberto= new ArrayList<>();
//		casAlberto.add(caAdAlberto);
//		casAlberto.add(caPmAlberto);
//
//
//		Alumno alumnoAlberto = new Alumno();
//		alumnoAlberto.setId(1);
//		alumnoAlberto.setNombre("Alberto");
//		alumnoAlberto.setApellido1("Solla");
//		alumnoAlberto.setApellido1("Rubio");
//		alumnoAlberto.setEdad(60);
//		alumnoAlberto.setCalificaciones(casAlberto);
//
//		List<Alumno> alumnos = new ArrayList<>();
//		alumnos.add(alumnoRuben);
//		alumnos.add(alumnoAlberto);
//		Aula aula = new Aula();
//		aula.setNombreAula("DAM 2");
//		aula.setAlumnos(alumnos);

	//	aulaConverter.marshallAula(aula,new File("src\\main\\resources\\1_7_xml_jaxb\\aula.xml"));
	}

}
