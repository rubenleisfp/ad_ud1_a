package practicas.futbol.service;



import practicas.futbol.dao.EquipoDao;
import practicas.futbol.model.Equipo;

import java.io.File;
import java.util.List;

public class EquipoService {
    private final EquipoDao dao;

    public EquipoService(EquipoDao equipoDao) {
        this.dao = equipoDao;
    }

    public void procesarJsonACsv(File sourceFile, File targetFile) {
        try {
            List<Equipo> equipos = dao.leerEquipos(sourceFile);
            dao.escribirCsv(targetFile,equipos);
            System.out.println("Fichero CSV generado con éxito.");
        } catch (Exception e) {
            System.err.println("Error al procesar el fichero: " + e);
        }

    }
}