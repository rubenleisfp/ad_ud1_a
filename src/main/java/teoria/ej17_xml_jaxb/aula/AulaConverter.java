package teoria.ej17_xml_jaxb.aula;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AulaConverter {

    /**
     * Escribe un aula en un fichero XML
     * @param aula
     * @param file
     * @throws JAXBException
     * @throws IOException
     */
    public void marshallAula(Aula aula, File file) throws JAXBException, IOException {
        throw new UnsupportedOperationException("A implementar por el alumno");
    }


    /**
     *
     * Recupera un aula de un fichero XML
     * @param file
     * @return
     * @throws JAXBException
     * @throws IOException
     */
    public Aula unmarshallAula(File file) throws JAXBException, IOException {
        throw new UnsupportedOperationException("A implementar por el alumno");
    }
}
