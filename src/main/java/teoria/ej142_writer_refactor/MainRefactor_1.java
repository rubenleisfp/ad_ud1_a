package teoria.ej142_writer_refactor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Usamos un enumerado para distinguir la operativa
 */
public class MainRefactor_1 {

	
	//private static final String tipoImplementacion = "B";
	private static final String filePath = "hola_mundo.txt";
			
	public static void main(String[] args) {
		MainRefactor_1 main2 = new MainRefactor_1();
		main2.escribirNumerosEnFichero();
	}
	
	public void escribirNumerosEnFichero() {
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("¿Hasta que número quiere escribir si es par o impar?");
			Integer numLineas = s.nextInt();
			//System.out.println("numLineas: " + numLineas);
			System.out.println("¿Que implementacion quieres usar?:");
			String tipoImplementacionStr = s.next();
			//System.out.println("tipoImplementacionStr: " + tipoImplementacionStr);
			
			long start = System.currentTimeMillis();
			TipoImplementacion tipoImplementacion = TipoImplementacion.findByClave(tipoImplementacionStr);
			if (TipoImplementacion.PRINT_WRITER == tipoImplementacion) {
				printWriter(numLineas);
			} else if (TipoImplementacion.BUFFERED_WRITER == tipoImplementacion) {
				bufferedWriter(numLineas);
			} else {
				throw new RuntimeException("Tipo de implementacion no contemplada");
			}
			long finish = System.currentTimeMillis();
			long timeElapsed = finish - start;
			System.out.println("timeElapsed:" + timeElapsed);
		}
	}

	private void bufferedWriter(Integer numLineas) {
		System.out.println("using BufferedWriter");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));) {
			for (int i = 0; i <= numLineas; i++) {
				
				writer.append(getMessageLine(i) );
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String getMessageLine(int i) {
		return String.valueOf(i) + " " +getMensajeEsPar(i);
	}

	private void printWriter(Integer numLineas) {
		System.out.println("using PrintWriter");
		try (FileWriter fileWriter = new FileWriter(filePath);
				PrintWriter printWriter = new PrintWriter(fileWriter);) {

			for (int i = 0; i <= numLineas; i++) {

				printWriter.println(getMessageLine(i));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
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
