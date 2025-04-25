package practicas.practica10;

import practicas.practica10.model.PredConcello;
import practicas.practica10.service.PredConcelloService;

import java.io.IOException;

public class AppPrediccion {

    PredConcelloService predConcelloService = new PredConcelloService();

    public static void main(String[] args) {

        AppPrediccion appPrediccion = new AppPrediccion();
        //appPrediccion.getPredConcelloFromJsonFile();
        //appPrediccion.escribirJsonTemperaturasMedias();
    }

    private  void escribirJsonTemperaturasMedias() {
        throw new UnsupportedOperationException("A completar por el alumno");
    }

    private  void getPredConcelloFromJsonFile() {
        throw new UnsupportedOperationException("A completar por el alumno");
    }
}
