package practicas.practica303.service;

import practicas.practica303.dao.PizzeriaDao;

import java.util.List;


public class PizzeriaService {
    private PizzeriaDao pizzaDao;

    public PizzeriaService(PizzeriaDao pizzaDao) {
        this.pizzaDao = pizzaDao;
    }

    public void agregarPizza(String pizza) {
        System.out.println("Agregando pizza: " + pizza);
        pizzaDao.agregarPizza(pizza);
    }

    public List<String> obtenerPizzas() {
        return pizzaDao.obtenerPizzas();
    }

    public void eliminarPizza(String pizza) {
        if (pizzaDao.eliminarPizza(pizza)) {
            System.out.println("Pizza eliminada: " + pizza);
        } else {
            System.out.println("Pizza no encontrada: " + pizza);
        }
    }
}
