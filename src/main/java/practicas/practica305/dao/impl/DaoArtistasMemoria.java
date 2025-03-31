package practicas.practica305.dao.impl;

import practicas.practica305.dao.DaoArtistas;
import practicas.practica305.exceptions.ExcepcionGestorArtista;
import practicas.practica305.exceptions.RegistroDuplicado;

import java.util.ArrayList;
import java.util.List;

public class DaoArtistasMemoria implements DaoArtistas {

    private List<String> listaArtistas;

    public DaoArtistasMemoria() {
        this.listaArtistas = new ArrayList<>();
    }

    @Override
    public void agregarArtista(String artista) throws RegistroDuplicado, ExcepcionGestorArtista {
        if (tieneArtista(artista)) {
            throw new RegistroDuplicado("El artista " + artista + " ya existe en la agenda.");
        }
        listaArtistas.add(artista);
    }

    @Override
    public List<String> mostrarArtistas() throws ExcepcionGestorArtista {
        return new ArrayList<>(listaArtistas);
    }

    @Override
    public boolean tieneArtista(String nombre) throws ExcepcionGestorArtista {
        return listaArtistas.contains(nombre);
    }

    @Override
    public String getArtista(String nombre) throws ExcepcionGestorArtista {
        if (tieneArtista(nombre)) {
            return nombre;
        }
        throw new ExcepcionGestorArtista("No se ha encontrado el artista: " + nombre);
    }

    @Override
    public boolean eliminarArtista(String nombre) throws ExcepcionGestorArtista {
        if (tieneArtista(nombre)) {
            return listaArtistas.remove(nombre);
        }
        throw new ExcepcionGestorArtista("No se ha encontrado el artista para eliminar: " + nombre);
    }

    @Override
    public boolean actualizarArtista(String nombre, String nuevoNombre) throws ExcepcionGestorArtista {
        int index = listaArtistas.indexOf(nombre);
        if (index != -1) {
            listaArtistas.set(index, nuevoNombre);
            return true;
        }
        throw new ExcepcionGestorArtista("No se ha encontrado el artista: " + nombre);
    }

    @Override
    public void eliminarTodosArtistas() throws ExcepcionGestorArtista {
        listaArtistas.clear();
    }
}
