package teoria.ej207_test_unitarios;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Buscar todo los libros del autor recibido como argumento
     *
     * @param author
     * @return
     */
    public List<Book> findBooksByAuthor(String author) {
        //TODO
        //1.- Crea una nueva lista con los libros del autor buscado
        //2.- Recorre los libros de mi biblioteca
        //3.- Si el libro es del autor buscado, añadirlo a la lista del punto 1
        //4.- Retorna la list del punto 1
        List<Book> booksAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                booksAuthor.add(book);
            }
        }
        return booksAuthor;
    }

    public boolean removeBook(String title) {
        Book foundBook = null;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                foundBook = book;
            }
        }
        return books.remove(foundBook);
    }

    public int getTotalBooks() {
        return this.books.size();
    }

    // Otros métodos relevantes para la gestión de libros en la biblioteca
}