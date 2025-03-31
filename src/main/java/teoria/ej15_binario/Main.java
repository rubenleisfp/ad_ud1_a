package teoria.ej15_binario;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final String FILE_PATH = "producto.dat";
	
	public static void main(String[] args) {
	
		BinarioHandler binarioHandler = new BinarioHandler();

		//1.- Creamos una lista de productos
		List<Producto> productos = new ArrayList<Producto>();
		productos.add(new Producto("A",20f));
		productos.add(new Producto("B",21f));
		//2.- La volcamos a fichero
		binarioHandler.escribirBinario(FILE_PATH, productos);
		//3.- Leemos el fichero y obtenemos la lista de productos
		List<Producto> productosLeidos = binarioHandler.leerBinario(FILE_PATH);
		for (Producto p : productosLeidos) {
			System.out.println(p);
		}
	}
}
