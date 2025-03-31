package teoria.ej142_writer_solid_configuration;

public class StdoutWriter implements ITextoWriter {

	public void write(String filePath, String line) {
		System.out.println(line);
	}

	@Override
	public String whoAmI() {
		return "I am StdoutWriter";
	}

}
