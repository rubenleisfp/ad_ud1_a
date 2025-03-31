package teoria.ej17_xml_jaxb.aula;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AulaConverter {

    public void marshallAula(Aula aula, String filePath) throws JAXBException, IOException {

        JAXBContext context = JAXBContext.newInstance(Aula.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(aula, new File(filePath));
    }


    public Aula unmarshallAula(String filePath) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Aula.class);
        return (Aula) context.createUnmarshaller()
                .unmarshal(new FileReader(filePath));
    }
}
