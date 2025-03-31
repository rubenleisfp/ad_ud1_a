package teoria.ej207_test_unitarios;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library(); // Instanciar la clase a probar
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("1984", "George Orwell"));
    }

    @Test
    public void testAddBook() {
        int initialSize = library.getTotalBooks();
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        assertEquals(initialSize + 1, library.getTotalBooks());
    }

    @Test
    public void testFindBooksByAuthor() {
        List<Book> booksByAuthor = library.findBooksByAuthor("Harper Lee");
        assertEquals(1, booksByAuthor.size());
        assertEquals("To Kill a Mockingbird", booksByAuthor.get(0).getTitle());
    }

    @Test
    public void testRemoveBook() {
        assertTrue(library.removeBook("1984"));
        assertFalse(library.removeBook("Nonexistent Book"));
    }
    
    @Test
    public void testGetTotalBooks() {
        assertEquals(3, library.getTotalBooks());
    }
}