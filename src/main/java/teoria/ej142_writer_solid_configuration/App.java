package teoria.ej142_writer_solid_configuration;

import java.util.Scanner;



/**
 * App que se encarga de escribir en un fichero si un numero es par/impar
 * 
 */
public class App {

	
	private static final String FILE_PATH = "hola_mundo.txt";
	private static final String IMPLEMENTATION_KEY = "implementacionTextWriter";
	private TextoWriterFactory textoWriterFactory = new TextoWriterFactory();
	private PropertiesHandler propertiesHandler = new PropertiesHandler();
			
	public static void main(String[] args) {
		App app = new App();
		app.parImpar(args);
	}
	
	private void parImpar(String[] args) {
		//Recogemos los datos de entrada
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("¿Hasta que número quiere escribir si es par o impar?");
			Integer numLineas = s.nextInt();
			
			//Escogemos una de las implementacion que cumplen la firma de la interfaz ITextoWriter
			String tipoImplementacionStr = propertiesHandler.getPropertyString(IMPLEMENTATION_KEY);
			ITextoWriter textoWriter = textoWriterFactory.getTextoWriter(tipoImplementacionStr);
			//Inyectamos el objeto textoWriter en ParImparService. Le pasamos una instancia concreta
			ParImparService parImparService = new ParImparService(textoWriter);
			parImparService.writeToFile(FILE_PATH, numLineas);
		}
	}

}
