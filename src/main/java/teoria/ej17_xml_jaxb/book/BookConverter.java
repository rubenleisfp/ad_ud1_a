package teoria.ej17_xml_jaxb.book;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BookConverter {

    public void marshallBook(Book book, String filePath) throws JAXBException, IOException {

        JAXBContext context = JAXBContext.newInstance(Book.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(book, new File(filePath));
    }

    public void marshallBookStore(Bookstore bookstore, String filePath) throws JAXBException, IOException {

        JAXBContext context = JAXBContext.newInstance(Bookstore.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(bookstore, new File(filePath));
    }

    public Book unmarshallBook(String filePath) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Book.class);
        return (Book) context.createUnmarshaller()
                .unmarshal(new FileReader(filePath));
    }
}
