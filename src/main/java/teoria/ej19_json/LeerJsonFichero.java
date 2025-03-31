package teoria.ej19_json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class LeerJsonFichero {
	public static void main(String[] args) {
		escribirJson();
		leerJson();
	}

	private static void escribirJson() {
		// Crear un objeto Ciudad
		Ciudad ciudad = new Ciudad("EjemploCity", 10000);

		// Convertir el objeto a formato JSON
		Gson gson = new Gson();
		String json = gson.toJson(ciudad);

		// Escribir el JSON en un archivo
		try (FileWriter writer = new FileWriter("ciudad.json")) {
			writer.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void leerJson() {
		try (FileReader reader = new FileReader("ciudad.json")) {
			// Convertir el JSON de vuelta a un objeto Java
			Gson gson = new Gson();
			Ciudad ciudad = gson.fromJson(reader, Ciudad.class);

			// Imprimir la ciudad
			System.out.println("Nombre de la ciudad: " + ciudad.nombre);
			System.out.println("Número de habitantes: " + ciudad.habitantes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
