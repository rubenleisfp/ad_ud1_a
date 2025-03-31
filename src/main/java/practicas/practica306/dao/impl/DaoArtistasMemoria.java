package practicas.practica306.dao.impl;

import practicas.practica306.dao.DaoArtistas;
import practicas.practica306.exceptions.ExcepcionGestorArtista;
import practicas.practica306.exceptions.RegistroDuplicado;
import practicas.practica306.model.Artista;

import java.util.ArrayList;
import java.util.List;

public class DaoArtistasMemoria implements DaoArtistas {

    private List<Artista> listaArtistas;

    public DaoArtistasMemoria() {
        this.listaArtistas = new ArrayList<>();
    }

    @Override
    public void agregarArtista(Artista artista) throws RegistroDuplicado, ExcepcionGestorArtista {
        if (tieneArtista(artista.getNombre())) {
            throw new RegistroDuplicado("El artista " + artista + " ya existe en la agenda.");
        }
        listaArtistas.add(artista);
    }

    @Override
    public List<Artista> mostrarArtistas() throws ExcepcionGestorArtista {
        return new ArrayList<>(listaArtistas);
    }

    @Override
    public boolean tieneArtista(String nombre) throws ExcepcionGestorArtista {
        boolean tieneArtista = false;
        for (Artista artista : listaArtistas) {
            if (artista.getNombre().equals(nombre)) {
                tieneArtista = true;
            }
        }
        return tieneArtista;
    }

    @Override
    public Artista getArtista(String nombre) throws ExcepcionGestorArtista {
        Artista artistaEncontrado = null;
        for (Artista artista : listaArtistas) {
            if (artista.getNombre().equals(nombre)) {
                artistaEncontrado = artista;
            }
        }
         return artistaEncontrado;
    }

    @Override
    public boolean eliminarArtista(String nombre) throws ExcepcionGestorArtista {
        Artista artista = getArtista(nombre);
        if (artista != null) {
             listaArtistas.remove(artista);
             return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean actualizarArtista(String nombre, Artista nuevoArtista) throws ExcepcionGestorArtista {
        int i=0;
        for (Artista artista : listaArtistas) {
            if (artista.getNombre().equals(nombre)) {
                listaArtistas.set(i, nuevoArtista);
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public void eliminarTodosArtistas() throws ExcepcionGestorArtista {
        listaArtistas.clear();
    }
}
