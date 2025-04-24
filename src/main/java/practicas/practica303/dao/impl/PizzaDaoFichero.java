package practicas.practica303.dao.impl;

import teoria.ej142_buffer.GestorFicheroBuffered;
import practicas.practica303.dao.PizzeriaDao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaDaoFichero implements PizzeriaDao {
    private String rutaFichero;

    public PizzaDaoFichero(String rutaFichero) {
        this.rutaFichero = rutaFichero;
    }

    @Override
    public void agregarPizza(String pizza) {
        List<String> pizzas = new ArrayList<>();
        pizzas.add(pizza);
        try {
            GestorFicheroBuffered.writeLines(new File(rutaFichero),true,pizzas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> obtenerPizzas() {

        try {
            List<String> pizzaLines = GestorFicheroBuffered.readLines(new File(rutaFichero));
            return pizzaLines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean eliminarPizza(String pizza) {
        List<String> pizzas = obtenerPizzas();
        if (pizzas.remove(pizza)) {
            try {
                GestorFicheroBuffered.writeLines(new File(rutaFichero),false,pizzas);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }
}
