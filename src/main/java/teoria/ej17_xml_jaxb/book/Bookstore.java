package teoria.ej17_xml_jaxb.book;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "name", "bookList" })
public class Bookstore {
	
	private List<Book> bookList;
	private String name;
	
	public List<Book> getBookList() {
		return bookList;
	}
	
	@XmlElement(name = "books")
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
