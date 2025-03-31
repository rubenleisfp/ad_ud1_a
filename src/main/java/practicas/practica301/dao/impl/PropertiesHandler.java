package practicas.practica301.dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {
	

	private static Properties configuracion = new Properties();

	public PropertiesHandler() {
		this("src/main/resources/mi.properties");
	}

	public PropertiesHandler(String rutaFichero) {
		loadProperties(rutaFichero);
	}
	
	public void loadProperties(String rutaFichero) {
		try {
			configuracion.load(new FileInputStream(rutaFichero));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getPropertyString(String clave) {
		  return configuracion.getProperty(clave);
	}
	
	

}
