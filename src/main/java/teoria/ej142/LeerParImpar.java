package teoria.ej142;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerParImpar {

	public static void main(String[] args) {
		read("par_impar.txt");
	}

	private static void read(String nombreFichero) {
		//Con try resources no tenemos que cerrar los recursos, Java ya lo hace por nosotros
		try (FileReader fr = new FileReader(nombreFichero);BufferedReader br = new BufferedReader(fr)){
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}
	}

}
