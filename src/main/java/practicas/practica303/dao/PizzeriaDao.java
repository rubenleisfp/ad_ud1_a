package practicas.practica303.dao;

import java.util.List;

public interface PizzeriaDao {
    void agregarPizza(String pizza);
    List<String> obtenerPizzas();
    boolean eliminarPizza(String pizza);
}
