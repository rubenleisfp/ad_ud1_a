package ad.practica11.futbol.dao;

import practicas.futbol.dao.EquipoDao;
import practicas.futbol.model.Equipo;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EquipoDaoTest {

    private static final File TEST_SOURCE = new File("src/test/resources/practica11/source.json");
    private static final File TEST_TARGET = new File("src/test/resources/practica11/target.csv");
    private static final File EXPECTED_CSV = new File("src/test/resources/practica11/expected.csv");

    @Test
    public void testLeerEquipos() throws Exception {
        EquipoDao dao = new EquipoDao();
        List<Equipo> equipos = dao.leerEquipos(TEST_SOURCE);

        assertNotNull(equipos);
        assertEquals(2, equipos.size());
        assertEquals("Barcelona", equipos.get(0).getNombre());
        assertEquals("Real Madrid", equipos.get(1).getNombre());
    }

    @Test
    public void testEscribirCsv() throws Exception {
        EquipoDao dao = new EquipoDao();
        List<Equipo> equipos = dao.leerEquipos(TEST_SOURCE);
        dao.escribirCsv(TEST_TARGET, equipos);

        // Leer el archivo generado
        List<String> actualLines = Files.readAllLines(Path.of(TEST_TARGET));

        // Validar las cabeceras
        assertEquals("equipo;total_titulos", actualLines.get(0));

        // Validar el contenido
        assertEquals("Barcelona;31", actualLines.get(1));
        assertEquals("Real Madrid;47", actualLines.get(2));
    }

    @Test
    public void testEscribirCsvConArchivoEsperado() throws Exception {
        EquipoDao dao = new EquipoDao();
        List<Equipo> equipos = dao.leerEquipos(TEST_SOURCE);
        dao.escribirCsv(TEST_TARGET, equipos);

        // Leer el archivo generado y el archivo esperado
        List<String> actualLines = Files.readAllLines(Path.of(TEST_TARGET));
        List<String> expectedLines = Files.readAllLines(Path.of(EXPECTED_CSV));

        // Validar que ambos archivos son iguales
        assertEquals(expectedLines, actualLines);
    }
}
