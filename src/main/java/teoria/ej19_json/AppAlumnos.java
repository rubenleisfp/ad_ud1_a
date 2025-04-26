package teoria.ej19_json;

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
		List<Alumno> alumnos = leerJson(new File("src/main/resources/json/alumnos.json"));

		// Parte 2: Generar y escribir en el archivo alumnos_output.json
		escribirJson("src/main/resources/json/alumnos_new_output.json");

		// Parte 3: Generar y escribir en el archivo alumnos_estadisticas.json
		escribirEstadisticasAlumnos(alumnos);
		
		System.out.println("Done!");
	}
	
	
	
	private static void escribirJson(String filePath) {
		List<Alumno> alumnos = crearAlumnosFicticios();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writer = new FileWriter(filePath)) {
			gson.toJson(alumnos, writer);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	

	private static List<Alumno> leerJson(File file) {
		Gson gson = new Gson();
		List<Alumno> alumnos = new ArrayList<>();
		try (Reader reader = new FileReader(file)) {
			Type tipoListaAlumnos = new TypeToken<List<Alumno>>() {
			}.getType();
			alumnos = gson.fromJson(reader, tipoListaAlumnos);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("Alumnos:" + alumnos);
		return alumnos;

	}
	


	private static void escribirEstadisticasAlumnos(List<Alumno> alumnos) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		List<Asignatura> calcularMediaAsignaturas = calcularMediaAsignaturas(alumnos);
		try (Writer writer = new FileWriter("src/main/resources/json/alumnos_estadisticas.json")) {
			gson.toJson(calcularMediaAsignaturas, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<Asignatura> calcularMediaAsignaturas(List<Alumno> alumnos) {
		Map<String, List<Double>> asignaturasCalificaciones = new HashMap<>();

		// Calcular el promedio de calificaciones para cada asignatura
		for (Alumno alumno : alumnos) {
			for (Asignatura asignatura : alumno.getAsignaturas()) {
				asignaturasCalificaciones.putIfAbsent(asignatura.getNombre(), new ArrayList<>());
				asignaturasCalificaciones.get(asignatura.getNombre()).add(asignatura.getCalificacion());
			}
		}

		// Calcular la media para cada asignatura
		List<Asignatura> estadisticas = new ArrayList<>();
		for (Map.Entry<String, List<Double>> entry : asignaturasCalificaciones.entrySet()) {
			String nombreAsignatura = entry.getKey();
			List<Double> calificaciones = entry.getValue();
			double suma = 0;
			for (double calificacion : calificaciones) {
				suma += calificacion;
			}
			double media = calificaciones.isEmpty() ? 0 : suma / calificaciones.size();
			estadisticas.add(new Asignatura(nombreAsignatura, media));
		}
		return estadisticas;
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
