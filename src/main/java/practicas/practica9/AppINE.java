package practicas.practica9;

import practicas.practica306.utils.GestorFicheroBuffered;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppINE {
	
	
	private static File INE_PATH = new File("src/main/resources/practicas/practica9/provincias.csv");
	private static String CSV_SEPARATOR = ";";
	private static int PRIMERAS_PROVINCIAS = 5;

	public static void main(String[] args) {
		
		try {
			List<String> lineas=getLineasFichero(INE_PATH);
			List<Provincia> provincias = parsearLineas(lineas);
			ordenar(provincias);
			mostrarNPrimerasProvincias(provincias);
			
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private static void mostrarNPrimerasProvincias(List<Provincia> provincias) {
		for (int i=0;i<PRIMERAS_PROVINCIAS;i++) {
			System.out.println(provincias.get(i).toString());
		}
	}

	private static void  ordenar(List<Provincia> provincias) {
		Collections.sort(provincias, Comparator.comparing(Provincia::getPoblacion).reversed());
	}

	public static List<String> getLineasFichero(File file) throws IOException {
		List<String> lines = GestorFicheroBuffered.readLines(file);
		return lines;
	}
	
	public static List<Provincia> parsearLineas(List<String> lineas) {
		List<Provincia> provincias = new ArrayList<Provincia>();
		for (int i=1;i<lineas.size();i++) {
			String[] camposCsv = lineas.get(i).split(CSV_SEPARATOR);
			String nombre = camposCsv[0];
			String poblacionAsString = camposCsv[1];
			int poblacion = Integer.valueOf(poblacionAsString);
			
			Provincia provincia = new Provincia(nombre,poblacion);
			provincias.add(provincia);
		}
		return provincias;
		
	}
	
	

}
