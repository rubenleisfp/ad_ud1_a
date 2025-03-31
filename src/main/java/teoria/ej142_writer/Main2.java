package teoria.ej142_writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 */
public class Main2 {

	
	private static final String tipoImplementacion = "B";
	private static final String filePath = "par_impar.txt";
			
	public static void main(String[] args) {
		Main2 main2 = new Main2();
		main2.escribirNumerosEnFichero();
	}
	
	public void escribirNumerosEnFichero() {
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("¿Hasta que número quiere escribir si es par o impar?:");
			Integer numLineas = s.nextInt();

			
			long start = System.currentTimeMillis();

			if ("P".equals(tipoImplementacion)) {
				System.out.println("using PrintWriter");
				try (FileWriter fileWriter = new FileWriter(filePath);
						PrintWriter printWriter = new PrintWriter(fileWriter);) {

					for (int i = 0; i <= numLineas; i++) {
						String esParStr = "es impar";
						
						if (i % 2 == 0) {
							esParStr = "es par";
						}
						
						printWriter.println(String.valueOf(i) + " " + esParStr);
					}
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			} else if ("B".equals(tipoImplementacion)) {
				System.out.println("using BufferedWriter");
				try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));) {
					for (int i = 0; i <= numLineas; i++) {
						String esParStr = "es impar";
						
						if (i % 2 == 0) {
							esParStr = "es par";
						}
						writer.append(String.valueOf(i) + " " +esParStr + "\n");
					}
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			} else {
				throw new RuntimeException("Tipo de implementacion no contemplada");
			}
			long finish = System.currentTimeMillis();
			long timeElapsed = finish - start;
			System.out.println("timeElapsed:" + timeElapsed);
		}
	}

}
