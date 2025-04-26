package teoria.ej17_xml_dom.producto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao {

    public List<Producto> readFromXml(String filePath) {
        List<Producto> productos = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("producto");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
                    double precio = Double.parseDouble(eElement.getElementsByTagName("precio").item(0).getTextContent());

                    Producto producto = new Producto(nombre, precio);
                    productos.add(producto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productos;
    }
}
