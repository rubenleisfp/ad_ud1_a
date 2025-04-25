package teoria.ej19_json.alumno;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class AppAlumnos {

	public static void main(String[] args) {

		// Parte1: Lee el fichero de alumnos, crear una lista de alumnos y mostrarlos
		// por consola
		//TODO Hacer por parte del alumno

		// Parte 2: Generar y escribir en el archivo alumnos_output.json
		//TODO Hacer por parte del alumno

		// Parte 3: Generar y escribir en el archivo alumnos_estadisticas.json
		//TODO Hacer por parte del alumno
		
		System.out.println("Done!");
	}
	
	
	
	private static void escribirJson(File fichero) {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	private static List<Alumno> leerJson(File fichero) {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	private static void escribirEstadisticasAlumnos(List<Alumno> alumnos) {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	private static List<Asignatura> calcularMediaAsignaturas(List<Alumno> alumnos) {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	private static List<Alumno> crearAlumnosFicticios() {
		List<Alumno> alumnos = new ArrayList<>();

		// Primer alumno
		List<Asignatura> asignaturas1 = new ArrayList<>();
		asignaturas1.add(new Asignatura("BBDD", 9));
		asignaturas1.add(new Asignatura("LM", 8));
		Alumno alumno1 = new Alumno("12345678-T", "Alicia", "Castro", "Lopez", asignaturas1);
		alumnos.add(alumno1);

		// Segundo alumno
		List<Asignatura> asignaturas2 = new ArrayList<>();
		asignaturas2.add(new Asignatura("Programación", 10));
		asignaturas2.add(new Asignatura("Redes", 7));
		Alumno alumno2 = new Alumno("22345678-T", "Borja", "Sanchez", "Lopez", asignaturas2);
		alumnos.add(alumno2);

		return alumnos;
	}

}
