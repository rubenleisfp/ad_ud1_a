package teoria.ej142_writer_solid_configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {
	

	private static Properties configuracion = new Properties();
	
	public PropertiesHandler() {
		loadProperties();
	}
	
	public void loadProperties() {
		try {
			configuracion.load(new FileInputStream("src/main/resources/configuracion.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getPropertyString(String prop) {
		  return configuracion.getProperty(prop);
	}
	
	

}
