package teoria.ej17_xml_dom.coche;

import java.io.File;
import java.util.List;

public class CocheDao {

	// src\\main\\resources\\1_7_xml_dom\\coches.xml
	/**
	 * Lee una lista de coches desde un archivo XML.
	 *
	 * @param  fichero XML desde el cual se leen los coches.
	 * @return La lista de coches leídos del archivo XML.
	 */
	public List<Coche> readFromXml(File fichero) {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}
	/**
	 * Escribe una lista de coches en un archivo XML.
	 *
	 * @param fichero La ruta del archivo donde se guardará el XML.
	 * @param coches La lista de coches a escribir en el archivo XML.
	 */
	public void writeToXml(File fichero, List<Coche> coches) {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

}
