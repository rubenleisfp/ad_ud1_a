package practicas.practica303.dao.impl;

import practicas.practica303.dao.PizzeriaDao;

import java.util.ArrayList;
import java.util.List;

public class PizzaDaoMemoria implements PizzeriaDao {
    private List<String> pizzas = new ArrayList<>();

    @Override
    public void agregarPizza(String pizza) {
        pizzas.add(pizza);
    }

    @Override
    public List<String> obtenerPizzas() {
        return new ArrayList<>(pizzas);
    }

    @Override
    public boolean eliminarPizza(String pizza) {
        return pizzas.remove(pizza);
    }
}
