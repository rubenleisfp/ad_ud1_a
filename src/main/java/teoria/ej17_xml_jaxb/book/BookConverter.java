package teoria.ej17_xml_jaxb.book;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BookConverter {

    public void marshallBook(Book book, File file) throws JAXBException, IOException {

        JAXBContext context = JAXBContext.newInstance(Book.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(book,  file);
    }

    public void marshallBookStore(Bookstore bookstore, File file) throws JAXBException, IOException {

        JAXBContext context = JAXBContext.newInstance(Bookstore.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(bookstore, file);
    }

    public Book unmarshallBook(File file) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Book.class);
        return (Book) context.createUnmarshaller()
                .unmarshal(file);
    }
}
