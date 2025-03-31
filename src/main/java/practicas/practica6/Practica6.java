package practicas.practica6;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Practica6 {

	public static void main(String[] args) throws IOException {

		System.out.println("Listar txt:");
		listarPorExtension("src/main/resources/1_1_recursividad");

		System.out.println("Listar csv:");
		listarPorExtension("src/main/resources/1_1_recursividad", ".xsd");

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
		if (fichero.isDirectory()) {
			File[] lista = fichero.listFiles();
			for (int i = 0; i < lista.length; i++) {
				if (lista[i].isFile()) {
					//Recorro todas las extensiones
					for (String extension : extensiones) {
						
		                // Verificar si la extensión del archivo coincide con alguna de las extensiones proporcionadas
		                if (lista[i].getName().toLowerCase().endsWith(extension.toLowerCase())) {
		                    System.out.println(lista[i].getName());
		                }
		            }
				}
				if (lista[i].isDirectory()) {
					listarPorExtension(lista[i], extensiones);
				}
			}
		}
	}

	
	public static void listarPorExtension(String ruta) {
		File fichero = new File(ruta);
		if (fichero.isDirectory()) {
			File[] lista = fichero.listFiles();

			for (int i = 0; i < lista.length; i++) {

				if (lista[i].getName().toLowerCase().endsWith(".txt")) {
					System.out.println(lista[i].getName());
				}

				if (lista[i].isDirectory()) {
					listarPorExtension(lista[i].getPath());
				}
			}

		}

	}

	public static void listarPorExtension(String ruta, String extension) {
		File fichero = new File(ruta);
		if (fichero.isDirectory()) {
			File[] lista = fichero.listFiles();

			for (int i = 0; i < lista.length; i++) {

				if (lista[i].getName().toLowerCase().endsWith(extension)) {
					System.out.println(lista[i].getName());
				}

				if (lista[i].isDirectory()) {
					listarPorExtension(lista[i].getPath(), extension);
				}
			}

		}

	}

}
