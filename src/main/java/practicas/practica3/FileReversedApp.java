package practicas.practica3;

import java.io.File;
import java.io.IOException;

public class FileReversedApp {

	public static void main(String[] args) {
		File original = new File("src/main/resources/practica3/original.txt");
		File reversed = new File("src/main/resources/practica3/reversed.txt");
		
		FileReverse fileReverse = new FileReverse();
		try {
			fileReverse.reverseFileV2(original, reversed);
		} catch (IOException e) {
			System.out.println("Error al hacer reverse del fichero: " + e);
		}
	}
}
