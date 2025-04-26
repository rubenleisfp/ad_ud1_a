package practicas.futbol;

import practicas.futbol.dao.EquipoDao;
import practicas.futbol.service.EquipoService;

import java.io.File;

public class AppFutbol {

    private static final File SOURCE_PATH = new File("src/main/resources/practicas/practica11/source.json");
    private static final File TARGET_PATH = new File("src/main/resources/practicas/practica11/target.csv");

    private EquipoDao equipoDao;
    private EquipoService equipoService;

    public static void main(String[] args) {
        AppFutbol appFutbol = new AppFutbol();
        appFutbol.cfg();
        appFutbol.run();
    }

    public void cfg()
    {
        equipoDao  = new EquipoDao();
        equipoService = new EquipoService(equipoDao);
    }

    public void run() {
        equipoService.procesarJsonACsv(SOURCE_PATH, TARGET_PATH);
    }


}
