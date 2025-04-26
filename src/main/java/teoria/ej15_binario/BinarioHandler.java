package teoria.ej15_binario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinarioHandler {

	public void escribirBinario(File fichero, List<Producto> productos) {
		try (ObjectOutputStream serializador = new ObjectOutputStream(new FileOutputStream(fichero))) {
			serializador.writeObject(productos);
		} catch (IOException ioe) {
			System.out.println("Error escribiendo en el fichero"+ ioe);
		}
	}

	public List<Producto> leerBinario(File fichero) {
		List<Producto> listaProductos = null;
		try (ObjectInputStream deserializador = new ObjectInputStream(new FileInputStream(fichero))) {
			listaProductos = (ArrayList<Producto>) deserializador.readObject();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error leyendo el fichero. Fichero no encontrado"+ fnfe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error leyendo el fichero. Problema con la clase a deserializar"+ cnfe);
		} catch (IOException ioe) {
			System.out.println("Error leyendo el fichero. r"+ ioe);

		}
		return listaProductos;
	}
}
