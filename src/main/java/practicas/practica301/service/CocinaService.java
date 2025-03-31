package practicas.practica301.service;


import practicas.practica301.dao.InstalacionElectrica;

import java.util.ArrayList;
import java.util.List;

public class CocinaService {

    private InstalacionElectrica instalacionElectrica;

    public CocinaService(InstalacionElectrica instalacionElectrica) {
        this.instalacionElectrica = instalacionElectrica;
    }

    public void cocinar(String receta)  {
        List<String> ingredientes = obtenerIngredientes(receta);
        for (String ingrediente : ingredientes) {
            System.out.println("ingrediente: " + ingrediente);
        }

        try {
            System.out.println("¿Usaremos energia eco?: " + this.instalacionElectrica.esEcologica());
            instalacionElectrica.consumir(ingredientes.size());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> obtenerIngredientes(String receta) {
        List<String> ingredientes = new ArrayList<>();

        switch (receta) {
            case "TORTILLA":
                ingredientes.add("patatas");
                ingredientes.add("aceite");
                ingredientes.add("sal");
                ingredientes.add("huevos");
                ingredientes.add("cebolla");
                break;
            case "PAELLA":
                ingredientes.add("arroz");
                ingredientes.add("pollo");
                ingredientes.add("tomate");
                ingredientes.add("aceite");
                ingredientes.add("pimiento");
                break;
            default:
                throw new IllegalArgumentException("Receta no encontrada");

        }
        return ingredientes;
    }

}
