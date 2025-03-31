package teoria.ej142_writer;

import teoria.ej142_writer_refactor.TextoPlanoBufferedWriter;

public class Main {

	public static void main(String[] args) {
		writeLinesBuffered();
		writeLinesPrintWriter();
	}
	
	public static void writeLinesBuffered() {
		String nombreFichero = "hola_mundo.txt";
		TextoPlanoBufferedWriter writer = new TextoPlanoBufferedWriter();
		for (int i=0; i<=3;i++) {
			writer.write(nombreFichero, String.valueOf(i));
		}
		System.out.println("Done!");
	}
	
	public static void writeLinesPrintWriter() {
		String nombreFichero = "hola_mundo.txt";
		TextoPlanoBufferedWriter writer = new TextoPlanoBufferedWriter();
		for (int i=4; i<=7;i++) {
			writer.write(nombreFichero, String.valueOf(i));
		}
		System.out.println("Done!");
	}

}
