package teoria.ej17_xml_jaxb.book;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BookConverter {

    /**
     * Escribe un libro en un fichero
     * @param book
     * @param fichero
     * @throws JAXBException
     * @throws IOException
     */
    public void marshallBook(Book book, File fichero) throws JAXBException, IOException {
        throw new UnsupportedOperationException("A implementar por el alumno");
    }

    /**
     * Escribe una libreria (conjunto de libros) en un fichero
     * @param bookstore
     * @param file
     * @throws JAXBException
     * @throws IOException
     */
    public void marshallBookStore(Bookstore bookstore, File file) throws JAXBException, IOException {
        throw new UnsupportedOperationException("A implementar por el alumno");

    }

    /**
     * Obtiene un libro de un fichero XML
     * @param file
     * @return
     * @throws JAXBException
     * @throws IOException
     */
    public Book unmarshallBook(File file) throws JAXBException, IOException {
        throw new UnsupportedOperationException("A implementar por el alumno");

    }
}
