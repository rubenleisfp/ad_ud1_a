package teoria.ej142_writer_refactor;

import java.util.Scanner;

/**
 * Utilizamos el patron factoria para escoger una implementacion
 * 
 */
public class MainRefactor_3 {

	
	//private static final String tipoImplementacion = "B";
	private static final String filePath = "hola_mundo.txt";
			
	public static void main(String[] args) {
		MainRefactor_3 main2 = new MainRefactor_3();
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
			writeToFile(tipoImplementacionStr, numLineas);
			long finish = System.currentTimeMillis();
			long timeElapsed = finish - start;
			System.out.println("timeElapsed:" + timeElapsed);
		}
	}

	/**
	 * A partir de la clave escogemos la implementacion de writer a utilizar 
	 * 
	 * @param tipoImplementacionStr
	 * @return
	 */
	public ITextoWriter getTextoWriter(String tipoImplementacionStr) {
		//Obtenemos el enumerado para escoger el tipo de implementacion que queremos utilizar
		TipoImplementacion tipoImplementacion = TipoImplementacion.findByClave(tipoImplementacionStr);
		
		//Ambas implementaciones, comparten la misma interfaz. Obtenemos la implementacion deseada y la guardamos en un objeto de la interfaz ITextoWriter
		ITextoWriter textoWriter = null;
		if (TipoImplementacion.PRINT_WRITER == tipoImplementacion) {
			textoWriter = new TextoPlanoPrintWriter();
		} else if (TipoImplementacion.BUFFERED_WRITER == tipoImplementacion) {
			textoWriter = new TextoPlanoBufferedWriter();
		} else {
			throw new RuntimeException("Tipo de implementacion no contemplada");
		}
		//Devolvemos el objeto generico interfaz
		return textoWriter;
	}
	
	/**
	 * Escoge la implementacion del writer deseado y escribe en fichero un numLineas indicando si es par o no 
	 * 
	 * @param tipoImplementacionStr clave para escoger implementacion del writer
	 * @param numLineas numero de lineas a escibir en nuestro fichero
	 */
	public void writeToFile(String tipoImplementacionStr, int numLineas) {;
		ITextoWriter textoWriter = getTextoWriter(tipoImplementacionStr);
		System.out.println("Who am I:" + textoWriter.whoAmI());
		for (int numLinea = 0; numLinea <= numLineas; numLinea++) {
			textoWriter.write(filePath, getMessageLine(numLinea));
		}
	}

	/**
	 * Mensaje que mostraremos en el fichero de salida
	 * @param i
	 * @return
	 */
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
