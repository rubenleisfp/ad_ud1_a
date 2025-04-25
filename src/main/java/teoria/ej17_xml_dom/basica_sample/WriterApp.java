package teoria.ej17_xml_dom.basica_sample;

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
import teoria.ej17_xml_dom.coche.Coche;

public class WriterApp {

    public static void main(String[] args) {
        WriterApp writerApp = new WriterApp();
        writerApp.writeConcesionario2();

        List<Coche> coches = new ArrayList<Coche>();
        coches.add(new Coche(1, "Renault", "Megane", Double.parseDouble("1.5")));
        coches.add(new Coche(2, "Seat", "Leon", Double.parseDouble("1.6")));
        coches.add(new Coche(3, "Suzuki", "Vitara", Double.parseDouble("1.9")));

        writerApp.writeConcesionario3(coches);
        System.out.println("Done!");
    }

    public void writeConcesionario3(List<Coche> coches) {
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
            StreamResult result = new StreamResult(new File("concesionario3.xml"));

            transformer.transform(source, result);
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            System.err.println("Causa: " + e.getCause());
        }

    }

    public void writeConcesionario2() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            // definimos el elemento raíz del documento
            Element eRaiz = doc.createElement("concesionario");
            doc.appendChild(eRaiz);

            // definimos el nodo que contendrá los elementos
            Element eCoche = doc.createElement("coche");
            eRaiz.appendChild(eCoche);

            // atributo para el nodo coche
            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            eCoche.setAttributeNode(attr);

            // definimos cada uno de los elementos y le asignamos un valor
            Element eMarca = doc.createElement("marca");
            eMarca.appendChild(doc.createTextNode("Renault"));
            eCoche.appendChild(eMarca);

            Element eModelo = doc.createElement("modelo");
            eModelo.appendChild(doc.createTextNode("Megano"));
            eCoche.appendChild(eModelo);

            Element eCilindrada = doc.createElement("cilindrada");
            eCilindrada.appendChild(doc.createTextNode("1.5"));
            eCoche.appendChild(eCilindrada);

            // clases necesarias finalizar la creación del archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("concesionario2.xml"));

            transformer.transform(source, result);
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            System.err.println("Causa: " + e.getCause());
        }

    }

}
