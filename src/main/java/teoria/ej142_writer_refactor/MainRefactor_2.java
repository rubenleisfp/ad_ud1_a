package teoria.ej142_writer_refactor;

import java.util.Scanner;

/**
 * Usamos las clases nuevas que se han creado para cumplir la responsabilidad unica
 * 
 */
public class MainRefactor_2 {

	
	//private static final String tipoImplementacion = "B";
	private static final String filePath = "hola_mundo.txt";
			
	public static void main(String[] args) {
		MainRefactor_2 main2 = new MainRefactor_2();
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
		TextoPlanoBufferedWriter bufferWriter = new TextoPlanoBufferedWriter();
		for (int numLinea = 0; numLinea <= numLineas; numLinea++) {
			bufferWriter.write(filePath, getMessageLine(numLinea));
		}
	}
	
	private void printWriter(Integer numLineas) {
		TextoPlanoPrintWriter printWriter = new TextoPlanoPrintWriter();
		for (int numLinea = 0; numLinea <= numLineas; numLinea++) {
			printWriter.write(filePath, getMessageLine(numLinea));
		}
	}

	private String getMessageLine(int i) {
		return String.valueOf(i) + " " +getMensajeEsPar(i);
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
