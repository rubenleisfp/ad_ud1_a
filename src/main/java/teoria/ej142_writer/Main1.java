package teoria.ej142_writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Main1 main1 = new Main1();
		main1.escribirNumerosEnFichero();
		System.out.println("Fichero escrito");
	}

	public void escribirNumerosEnFichero() {
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("¿Hasta que número quiere escribir si es par o impar?:");
			Integer numLineas = s.nextInt();

			try (FileWriter fileWriter = new FileWriter("par_impar.txt");
					PrintWriter printWriter = new PrintWriter(fileWriter);) {

				for (int i = 0; i <= numLineas; i++) {

					String esPar = "false";
					if (i % 2 == 0) {
						esPar = "true";
					}
					printWriter.println(String.valueOf(i) + " " + esPar);
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
