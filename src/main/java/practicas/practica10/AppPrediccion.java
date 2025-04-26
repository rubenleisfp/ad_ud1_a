package practicas.practica10;

import practicas.practica10.model.PredConcello;
import practicas.practica10.service.PredConcelloService;

import java.io.File;
import java.io.IOException;

public class AppPrediccion {

    PredConcelloService predConcelloService = new PredConcelloService();

    public static void main(String[] args) {

        AppPrediccion appPrediccion = new AppPrediccion();
        //appPrediccion.getPredConcelloFromJsonFile();
        appPrediccion.escribirJsonTemperaturasMedias();
    }

    private  void escribirJsonTemperaturasMedias() {
        try {
            predConcelloService.escribirTemperaturaMediaEnFichero(new File("src/main/resources/practicas/practica10/prediccioncoruna.json"),new File("src/main/resources/practica10/tmedia.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private  void getPredConcelloFromJsonFile() {

        try {
            PredConcello predConcello = predConcelloService.getPredConcelloFromJsonFile(new File("src/main/resources/practicas/practica10/prediccioncoruna.json"));

            System.out.println(predConcello);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
