package teoria.ej142_writer_solid_configuration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextoPlanoBufferedWriter implements ITextoWriter {

	public void write(String filePath, String line) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));) {
			writer.append(line + "\n");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String whoAmI() {
		return "I am TextoPlanoBufferedWriter";
	}

}
