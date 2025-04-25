package teoria.ej17_xml_dom.coche;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AppCoche {

	
	private CocheDao cocheRepository = new CocheDao();
	
	public static void main(String[] args) {
		AppCoche appCoche = new AppCoche();
		appCoche.readXML();
		appCoche.writeXML();
	}
	
	public void readXML() {
		List<Coche> coches = cocheRepository.readFromXml(new File("src/main/resources/1_7_xml_dom/coches.xml"));
		for (Coche c : coches ) {
			System.out.println(c.toString());
		}
	}

	public void writeXML() {
		List<Coche> coches = new ArrayList<>();
		Coche coche1 = new Coche(1,"Honda","Civic",125);
		Coche coche2 = new Coche(2,"Kia","Ceed",100);
		coches.add(coche1);
		coches.add(coche2);

		cocheRepository.writeToXml(new File("src/main/resources/1_7_xml_dom/coches_wrote.xml"),coches);
	}

}
