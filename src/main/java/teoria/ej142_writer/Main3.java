package teoria.ej142_writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 */
public class Main3 {

	
	private static final String tipoImplementacion = "B";
	private static final String filePath = "hola_mundo.txt";
			
	public static void main(String[] args) {
		Main3 main2 = new Main3();
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

						printWriter.println(String.valueOf(i) + " " + getMensajeEsPar(i));
					}
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			} else if ("B".equals(tipoImplementacion)) {
				System.out.println("using BufferedWriter");
				try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));) {
					for (int i = 0; i <= numLineas; i++) {
						
						writer.append(String.valueOf(i) + " " +getMensajeEsPar(i) );
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
	
	public boolean esPar(int i) {
		return i%2 == 0;
	}
	
	public String getMensajeEsPar(int i) {
		String mensaje = "";
		if (esPar(i)) {
			mensaje = "es par";
		} else {
			mensaje="es impar";
		}
		return mensaje;
	}

}
