package practicas.practica3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import teoria.ej142_buffer.GestorFicheroBuffered;

public class FileReverse {

	
	
	public void reverseFileV2(File original, File reversed) throws IOException {
		List<String> lineas = GestorFicheroBuffered.readLines(original);
		Collections.reverse(lineas);
		GestorFicheroBuffered.writeLines(reversed, true, lineas);
	}
	
	
	
	public void reverseFile(File original, File reversed) {

		List<String> lines = new ArrayList();
		try (FileReader fr = new FileReader(original); BufferedReader br = new BufferedReader(fr)) {
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println("Linea:" + linea);
				lines.add(linea);
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

		Collections.reverse(lines);

		try (FileWriter fw = new FileWriter(reversed); BufferedWriter bw = new BufferedWriter(fw)) {

			for (String line : lines) {
				System.out.println("Escribiendo en fichero la linea: " + line);
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error al escribir el fichero: " + e.getMessage());
		}

	}
}
