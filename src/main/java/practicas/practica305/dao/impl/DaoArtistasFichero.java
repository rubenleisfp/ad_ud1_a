package practicas.practica305.dao.impl;

import practicas.practica305.dao.DaoArtistas;
import practicas.practica305.exceptions.ExcepcionGestorArtista;
import practicas.practica305.exceptions.RegistroDuplicado;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaoArtistasFichero implements DaoArtistas {

	private File fichero;

	public DaoArtistasFichero(File fichero) {
		this.fichero = fichero;
	}

	/**
	 * Agrega un artista a la agenda.
	 *
	 * @param artista nombre del artista que se quiere agregar
	 * @throws RegistroDuplicado en caso de que exista un artista con el mismo nombre
	 * @throws ExcepcionGestorArtista en caso de que surge un error con el origen de datos
	 */
	@Override
	public void agregarArtista(String artista) throws RegistroDuplicado, ExcepcionGestorArtista {

			//TODO
			//1.- Crear una lista vacia
			//2.- Si el registro ya existe, lanzar la excepcion registro duplicado
			//3.- Añadir el artista recibido como argumento a la lista
			//4.- Volcar la lista a fichero mediante GestorBuffered
			//5.- Capturar la excepcion y generar una ExcepcionGestorArtista

			throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}

	/**
	 * Muestra todos los artistas guardados.
	 *
	 * @return lista de nombres de artistas
	 * @throws ExcepcionGestorArtista en caso de que surge un error con el origen de datos
	 */
	@Override
	public List<String> mostrarArtistas() throws ExcepcionGestorArtista {
		//TODO
		//1.- Leer el fichero mediante GestorBuffered
		//2.- Capturar la excepcion y generar una ExcepcionGestorArtista
		throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}

	/**
	 * Indica si existe algún artista con el nombre recibido como argumento.
	 *
	 * @param nombre nombre del artista
	 * @return true si existe el artista, false si no
	 * @throws ExcepcionGestorArtista en caso de que surge un error con el origen de datos
	 */
	@Override
	public boolean tieneArtista(String nombre) throws ExcepcionGestorArtista {
		//TODO
		//1.- Leer el fichero mediante GestorBuffered
		//2.- Comprobar si en la lista anterior esta el nombre buscado
		//3.- Capturar la excepcion y generar una ExcepcionGestorArtista
		throw new UnsupportedOperationException("Operacion a implementar por el alumno");

	}

	/**
	 * Obtiene un artista por su nombre.
	 *
	 * @param nombre nombre del artista
	 * @return el nombre del artista si existe
	 * @throws ExcepcionGestorArtista en caso de que surge un error con el origen de datos
	 */
	@Override
	public String getArtista(String nombre) throws ExcepcionGestorArtista {
		//TODO
		//1.- Leer el fichero mediante GestorBuffered
		//2.- Comprobar si en la lista anterior esta el nombre buscado.
		// 	  Si esta devolver el artista
		//	  Sino esta devolver la excepcion indicando que el artista no esta registrado
		//3.- Capturar la excepcion y generar una ExcepcionGestorArtista

		throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}

	/**
	 * Elimina el artista indicado por su nombre.
	 *
	 * @param nombre nombre del artista
	 * @return true si el artista fue eliminado, false si no
	 * @throws ExcepcionGestorArtista en caso de que surge un error con el origen de datos
	 */
	@Override
	public boolean eliminarArtista(String nombre) throws ExcepcionGestorArtista {
		//TODO
		//1.- Leer el fichero mediante GestorBuffered
		//2.- Borrar el artista de la lista
		//3.- Volcar la lista a fichero
		//4.- Capturar la excepcion y generar una ExcepcionGestorArtista

		throw new UnsupportedOperationException("Operacion sin completar");
	}

	/**
	 * Actualiza el nombre de un artista.
	 *
	 * @param nombre nombre actual del artista
	 * @param nuevoNombre nuevo nombre para el artista
	 * @return true si el artista fue actualizado, false si no
	 * @throws ExcepcionGestorArtista en caso de que surge un error con el origen de datos
	 */
	@Override
	public boolean actualizarArtista(String nombre, String nuevoNombre) throws ExcepcionGestorArtista {
		//TODO
		//1.- Crear una lista con todos los artistas del fichero
		//2.- Si existe el artista en la lista, quitar el viejo y añadir el nuevo
		//3.- Volcar la lista a fichero mediante GestorBuffered
		//4.- Capturar la excepcion y generar una ExcepcionGestorArtista

		throw new UnsupportedOperationException("Operacion sin completar");
	}

	/**
	 * Elimina todos los artistas de la agenda.
	 *
	 * @throws ExcepcionGestorArtista en caso de que surge un error con el origen de datos
	 */
	@Override
	public void eliminarTodosArtistas() throws ExcepcionGestorArtista {
		//TODO
		//1.- Borrar la lista mediante GestorBuffered pasandole una lista vacia
		//2.- Capturar la excepcion y generar una ExcepcionGestorArtista

		throw new UnsupportedOperationException("Operacion sin completar");
	}
}
