package practicas.futbol.service;



import practicas.futbol.dao.EquipoDao;
import practicas.futbol.model.Equipo;

import java.util.List;

public class EquipoService {
    private final EquipoDao dao;

    public EquipoService(EquipoDao equipoDao) {
        this.dao = equipoDao;
    }

    public void procesarJsonACsv(String sourcePath, String targetPath) {
        try {
            List<Equipo> equipos = dao.leerEquipos(sourcePath);
            dao.escribirCsv(targetPath,equipos);
            System.out.println("Fichero CSV generado con éxito.");
        } catch (Exception e) {
            System.err.println("Error al procesar el fichero: " + e);
        }

    }
}