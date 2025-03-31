package teoria.ej142_writer_solid;

public class StdoutWriter implements ITextoWriter {

	public void write(String filePath, String line) {
		System.out.println(line);
	}

	@Override
	public String whoAmI() {
		return "I am TextoPlanoBufferedWriter";
	}

}
