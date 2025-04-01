package teoria.ej17_xml_jaxb.book;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BookConverter {

    public void marshallBook(Book book, String filePath) throws JAXBException, IOException {
        throw new UnsupportedOperationException("A implementar por el alumno");
    }

    public void marshallBookStore(Bookstore bookstore, String filePath) throws JAXBException, IOException {
        throw new UnsupportedOperationException("A implementar por el alumno");

    }

    public Book unmarshallBook(String filePath) throws JAXBException, IOException {
        throw new UnsupportedOperationException("A implementar por el alumno");

    }
}
