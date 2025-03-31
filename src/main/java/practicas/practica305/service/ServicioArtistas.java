package practicas.practica305.service;

import practicas.practica305.dao.DaoArtistas;
import practicas.practica305.exceptions.ExcepcionGestorArtista;
import practicas.practica305.exceptions.RegistroDuplicado;


import java.util.List;

/**
 * Clase para gestionar una agenda de artistas.
 *
 * Un artista solo puede tener un registro.
 * Es decir, el nombre del artista se podría considerar clave única en el fichero para buscar, eliminar y actualizar.
 *
 */
public class ServicioArtistas {

	private DaoArtistas daoArtistas; 

	public ServicioArtistas(DaoArtistas daoArtistas) {
		this.daoArtistas = daoArtistas;
	}

	/**
	 * Agrega un artista a la agenda.
	 *
	 * @param artista Nombre del artista a agregar.
	 * @throws RegistroDuplicado en caso de que exista un registro con el mismo nombre.
	 * @throws ExcepcionGestorArtista en caso de que surge un error con el origen de datos.
	 */
	public void agregarArtista(String artista) throws RegistroDuplicado, ExcepcionGestorArtista {
		daoArtistas.agregarArtista(artista);  // Cambiado para trabajar con String
	}

	/**
	 * Muestra todos los artistas guardados.
	 *
	 * @return Lista de artistas.
	 * @throws ExcepcionGestorArtista en caso de que surge un error con el origen de datos.
	 */
	public List<String> mostrarArtistas() throws ExcepcionGestorArtista {
		return daoArtistas.mostrarArtistas();  // Devuelve la lista de artistas
	}

	/**
	 * Indica si el artista existe en la agenda.
	 *
	 * @param artista Nombre del artista.
	 * @return Verdadero si el artista tiene un registro.
	 * @throws ExcepcionGestorArtista en caso de que surge un error con el origen de datos.
	 */
	public boolean tieneArtista(String artista) throws ExcepcionGestorArtista {
		return daoArtistas.tieneArtista(artista);  // Verifica si el artista ya existe
	}

	/**
	 * Obtiene el registro del artista.
	 *
	 * @param artista Nombre del artista.
	 * @return El nombre del artista.
	 * @throws ExcepcionGestorArtista en caso de que surge un error con el origen de datos.
	 */
	public String getArtista(String artista) throws ExcepcionGestorArtista {
		return daoArtistas.getArtista(artista);  // Devuelve el nombre del artista
	}

	/**
	 * Elimina el registro de un artista.
	 *
	 * @param artista Nombre del artista a eliminar.
	 * @return Verdadero si se eliminó correctamente.
	 * @throws ExcepcionGestorArtista en caso de que surge un error con el origen de datos.
	 */
	public boolean eliminarArtista(String artista) throws ExcepcionGestorArtista {
		return daoArtistas.eliminarArtista(artista);  // Elimina el registro del artista
	}

	/**
	 * Actualiza el nombre del artista.
	 *
	 * @param artista Nombre actual del artista.
	 * @param nuevoArtista Nuevo nombre del artista.
	 * @return Verdadero si se actualizó correctamente.
	 * @throws ExcepcionGestorArtista en caso de que surge un error con el origen de datos.
	 */
	public boolean actualizarArtista(String artista, String nuevoArtista) throws ExcepcionGestorArtista {
		return daoArtistas.actualizarArtista(artista, nuevoArtista);  // Actualiza el nombre del artista
	}

	/**
	 * Elimina todos los registros de artistas.
	 *
	 * @throws ExcepcionGestorArtista en caso de que surge un error con el origen de datos.
	 */
	public void eliminarTodosArtistas() throws ExcepcionGestorArtista {
		daoArtistas.eliminarTodosArtistas();  // Elimina todos los registros
	}
}
