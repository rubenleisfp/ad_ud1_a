package teoria.ej17_xml_dom.basica_sample;

import java.io.File;
import java.sql.SQLOutput;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReaderApp {

	public static void main(String[] args) {
		ReaderApp readerApp = new ReaderApp();
		readerApp.readCoches();
		readerApp.readProductos();
	}

	public void readProductos() {
		File file = new File("src\\main\\resources\\1_7_xml_dom\\productos.xml");
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("producto");
			System.out.println("Número de productos: " + nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					System.out.println("Nombre: " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
					System.out.println("Precio: " + eElement.getElementsByTagName("precio").item(0).getTextContent());

				}
			}

		} catch (Exception e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
			System.err.println("Causa: " + e.getCause());
		}
	}

	
	public void readCoches() {
		File file = new File("src\\main\\resources\\1_7_xml_dom\\coches.xml");
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

					System.out.println("\nCoche id: " + eElement.getAttribute("id"));
					System.out.println("Marca: " + eElement.getElementsByTagName("marca").item(0).getTextContent());
					System.out.println("Modelo: " + eElement.getElementsByTagName("modelo").item(0).getTextContent());
					System.out.println(
							"Cilindrada: " + eElement.getElementsByTagName("cilindrada").item(0).getTextContent());
				}
			}

		} catch (Exception e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
			System.err.println("Causa: " + e.getCause());
		}
	}

}
