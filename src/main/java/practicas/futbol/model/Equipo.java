package practicas.futbol.model;

import java.util.List;

public class Equipo {
    private String nombre;
    private List<Titulo> titulos;

    public Equipo(String nombre, List<Titulo> titulos) {
        this.nombre = nombre;
        this.titulos = titulos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Titulo> getTitulos() {
        return titulos;
    }

    public void setTitulos(List<Titulo> titulos) {
        this.titulos = titulos;
    }


    public int getTotalTitulos() {
        int numTitulos = 0;
        for (Titulo titulo : titulos) {
            numTitulos += titulo.getCantidad();
        }
        return numTitulos;
    }
}
