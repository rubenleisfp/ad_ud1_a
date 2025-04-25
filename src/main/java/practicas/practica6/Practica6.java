package practicas.practica6;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Practica6 {

	public static void main(String[] args) throws IOException {

		System.out.println("Listar txt:");
		listarPorExtension(new File("src/main/resources/1_1_recursividad"));

		System.out.println("Listar csv:");
		listarPorExtension(new File("src/main/resources/1_1_recursividad"), ".xsd");

		System.out.println("Listar por csv y txt:");
		List<String> extensiones = new ArrayList<String>();
		extensiones.add(".csv");
		extensiones.add(".txt");
		listarPorExtension(new File("src/main/resources/1_1_recursividad"),extensiones);

	}
	
	/**
	 * 
	 * Mostrar todos los archivos cuya extension coincida con alguna de las
	 * recibidas como argumento
	 * 
	 * 
	 * 
	 * @param fichero
	 * @param extensiones List<String> Ej: csv, txt
	 */
	public static void listarPorExtension(File fichero, List<String> extensiones) {
		throw new UnsupportedOperationException("A completar por el alumno");
	}

	public static void listarPorExtension(File fichero) {
		throw new UnsupportedOperationException("A completar por el alumno");
	}

	public static void listarPorExtension(File fichero, String extension) {
		throw new UnsupportedOperationException("A completar por el alumno");
	}

}
