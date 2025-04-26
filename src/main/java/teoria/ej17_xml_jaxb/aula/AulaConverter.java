package teoria.ej17_xml_jaxb.aula;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AulaConverter {

    public void marshallAula(Aula aula, File file) throws JAXBException, IOException {

        JAXBContext context = JAXBContext.newInstance(Aula.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(aula, file);
    }


    public Aula unmarshallAula(File file) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Aula.class);
        return (Aula) context.createUnmarshaller()
                .unmarshal(new FileReader(file));
    }
}
