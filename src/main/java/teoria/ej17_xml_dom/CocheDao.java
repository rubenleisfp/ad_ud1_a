package teoria.ej17_xml_dom;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CocheDao {

	// src\\main\\resources\\1_7_xml_dom\\coches.xml
	public List<Coche> readFromXml(String filePath) {
		List<Coche> coches = new ArrayList<Coche>();
		File file = new File(filePath);
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("coche");
			System.out.println("Número de coches: " + nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					int id = Integer.parseInt(eElement.getAttribute("id").toString());
					String marca = eElement.getElementsByTagName("marca").item(0).getTextContent();
					String modelo = eElement.getElementsByTagName("modelo").item(0).getTextContent();
					double cilindrada = Double
							.parseDouble(eElement.getElementsByTagName("cilindrada").item(0).getTextContent());

					Coche coche = new Coche(id, marca, modelo, cilindrada);
					coches.add(coche);
				}
			}

		} catch (Exception e) {
			System.out.println("Error leyendo fichero: " + e);
		}

		return coches;
	}

	public void writeToXml(String filePath, List<Coche> coches) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();

			// definimos el elemento raíz del documento
			Element eRaiz = doc.createElement("concesionario");
			doc.appendChild(eRaiz);

			int id = 0;
			// definimos el nodo que contendrá los elementos
			for (Coche coche : coches) {
				id++;
				Element eCoche = doc.createElement("coche");
				eRaiz.appendChild(eCoche);

				// atributo para el nodo coche
				Attr attr = doc.createAttribute("id");
				attr.setValue(String.valueOf(id));
				eCoche.setAttributeNode(attr);

				// definimos cada uno de los elementos y le asignamos un valor
				Element eMarca = doc.createElement("marca");
				eMarca.appendChild(doc.createTextNode(coche.getMarca()));
				eCoche.appendChild(eMarca);

				Element eModelo = doc.createElement("modelo");
				eModelo.appendChild(doc.createTextNode(coche.getModelo()));
				eCoche.appendChild(eModelo);

				Element eCilindrada = doc.createElement("cilindrada");
				eCilindrada.appendChild(doc.createTextNode(String.valueOf(coche.getCilindrada())));
				eCoche.appendChild(eCilindrada);
			}

			// clases necesarias finalizar la creación del archivo XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filePath));

			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
