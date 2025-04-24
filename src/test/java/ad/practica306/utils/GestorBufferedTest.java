package ad.practica306.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import practicas.practica306.utils.GestorFicheroBuffered;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class GestorBufferedTest {

    private File testFilePath = new File("testFile.txt");
    private File testFile;

    @Before
    public void setUp() throws Exception {
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @After
    public void tearDown() throws Exception {
        // Eliminar el fichero después de cada test
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    public void testReadFileNoFileExists() throws IOException {
        // Test para leer cuando el fichero no existe
        List<String> result = GestorFicheroBuffered.readLines(testFilePath);

        assertTrue(result.isEmpty()); // Debe devolver una lista vacía
    }

    @Test
    public void testWriteLinesAppendFalse() throws IOException {
        // Test para escribir líneas en el fichero (sin append)
        List<String> lines = Arrays.asList("Línea 1", "Línea 2", "Línea 3");
        GestorFicheroBuffered.writeLines(testFilePath, false, lines);

        List<String> result = GestorFicheroBuffered.readLines(testFilePath);

        assertEquals(3, result.size());
        assertEquals("Línea 1", result.get(0));
        assertEquals("Línea 2", result.get(1));
        assertEquals("Línea 3", result.get(2));
    }

    @Test
    public void testWriteLinesAppendTrue() throws IOException {
        // Test para escribir líneas en el fichero (con append)
        List<String> lines1 = Arrays.asList("Línea 1", "Línea 2");
        List<String> lines2 = Arrays.asList("Línea 3", "Línea 4");

        // Primero escribe sin append
        GestorFicheroBuffered.writeLines(testFilePath, false, lines1);
        // Ahora escribe con append
        GestorFicheroBuffered.writeLines(testFilePath, true, lines2);

        List<String> result = GestorFicheroBuffered.readLines(testFilePath);

        assertEquals(4, result.size());
        assertEquals("Línea 1", result.get(0));
        assertEquals("Línea 2", result.get(1));
        assertEquals("Línea 3", result.get(2));
        assertEquals("Línea 4", result.get(3));
    }

    @Test
    public void testReadFileFileExists() throws IOException {
        // Test para leer líneas cuando el fichero ya tiene contenido
        List<String> lines = Arrays.asList("Línea 1", "Línea 2", "Línea 3");
        GestorFicheroBuffered.writeLines(testFilePath, false, lines);

        List<String> result = GestorFicheroBuffered.readLines(testFilePath);

        assertEquals(3, result.size());
        assertEquals("Línea 1", result.get(0));
        assertEquals("Línea 2", result.get(1));
        assertEquals("Línea 3", result.get(2));
    }
}