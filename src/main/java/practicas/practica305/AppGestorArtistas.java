package practicas.practica305;

import practicas.practica305.dao.DaoArtistas;
import practicas.practica305.dao.impl.DaoArtistasFichero;
import practicas.practica305.dao.impl.DaoArtistasMemoria;
import practicas.practica305.service.ServicioArtistas;
import practicas.practica305.exceptions.RegistroDuplicado;
import practicas.practica305.exceptions.ExcepcionGestorArtista;
import practicas.practica305.utils.PropertiesHandler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AppGestorArtistas {

    private static final String TIPO_IMPLEMENTACION_FICHERO ="fichero";
    private static final String TIPO_IMPLEMENTACION_MEMORIA="memoria";
    private static final int END_NUMBER = 99;
    private DaoArtistas daoArtistas;
    private ServicioArtistas servicioArtistas;



    public static void main(String[] args) throws IOException {
        // De esta manera evitamos que el resto de métodos sean estáticos
        AppGestorArtistas appGestorArtistas = new AppGestorArtistas();
        appGestorArtistas.run();
    }

    /**
     * Método que contiene la funcionalidad de mi aplicación.
     */
    private void run() {
        Scanner scanner = new Scanner(System.in);
        cfgApp();
        try {
            menuOpciones(scanner);
        } catch (RegistroDuplicado | ExcepcionGestorArtista e) {
            System.out.println("Error al realizar la operativa");
            System.out.println(e);
        } finally {
            scanner.close();
        }
    }

    /**
     * Instancia los componentes necesarios de negocio y de acceso a datos.
     */
    private void cfgApp() {
        PropertiesHandler propertiesHandler = new PropertiesHandler();
        String tipoImplementacion = propertiesHandler.getPropertyString("tipoImplementacion");
        if (tipoImplementacion.equals(TIPO_IMPLEMENTACION_FICHERO)) {
            daoArtistas = new DaoArtistasFichero(new File("src/main/resources/practicas/practica305/artistas.txt"));
        } else if (tipoImplementacion.equals(TIPO_IMPLEMENTACION_MEMORIA)) {
            daoArtistas = new DaoArtistasMemoria();
        } else {
            throw new IllegalStateException("Implementacion no indicada en el fichero de configuracion de la app. Revise la misma.");
        }
        servicioArtistas = new ServicioArtistas(daoArtistas);
    }

    /**
     * Contiene un menú con todas las opciones sugeridas al usuario para que pueda interactuar con la app.
     *
     * @param scanner
     * @throws RegistroDuplicado
     * @throws ExcepcionGestorArtista
     */
    private void menuOpciones(Scanner scanner) throws RegistroDuplicado, ExcepcionGestorArtista {
        int opcion;
        do {
            System.out.println("1. Agregar artista");
            System.out.println("2. Consultar artistas");
            System.out.println("3. Tiene artista");
            System.out.println("4. Obtener artista");
            System.out.println("5. Actualizar artista");
            System.out.println("6. Eliminar artista");
            System.out.println("7. Eliminar todos los artistas");
            System.out.println("99. Salir del programa");
            System.out.print("Introduzca una opción: ");
            opcion = scanner.nextInt();

            scanner.nextLine(); // Limpiar el buffer después de leer un entero
            String artista = "";
            boolean existeArtista = false;
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del artista nuevo:");
                    artista = scanner.nextLine();
                    existeArtista = servicioArtistas.tieneArtista(artista);
                    if (existeArtista) {
                        System.out.println("El artista indica ya existe");
                    } else {
                        servicioArtistas.agregarArtista(artista);
                        System.out.println("Artista agregado correctamente.");
                    }
                    break;
                case 2:
                    System.out.println("Artistas guardados en la agenda:");
                    List<String> artistas = servicioArtistas.mostrarArtistas();
                    for (String a : artistas) {
                        System.out.println(a);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del artista para saber si existe:");
                    artista = scanner.nextLine(); // Leer el nombre del artista
                    System.out.println(servicioArtistas.tieneArtista(artista));
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del artista para obtener su registro:");
                    artista = scanner.nextLine(); // Leer el nombre del artista
                    String artistaEncontrado = servicioArtistas.getArtista(artista);
                    if (artistaEncontrado != null) {
                        System.out.println(artistaEncontrado);
                    } else {
                        System.out.println("No hay registro para ese artista.");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del artista que desea actualizar:");
                    artista = scanner.nextLine(); // Leer el nombre del artista
                    if (servicioArtistas.tieneArtista(artista)) {
                        System.out.println("Ingrese el nuevo nombre del artista:");
                        String nuevoArtista = scanner.nextLine(); // Leer el nuevo nombre del artista
                        servicioArtistas.actualizarArtista(artista, nuevoArtista);
                        System.out.println("Artista actualizado correctamente.");
                    } else {
                        System.out.println("No hay registro para ese artista. No se puede actualizar.");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el nombre del artista que desea eliminar:");
                    artista = scanner.nextLine(); // Leer el nombre del artista a eliminar
                    if (servicioArtistas.tieneArtista(artista)) {
                        boolean artistaEliminado = servicioArtistas.eliminarArtista(artista);
                        if (artistaEliminado) {
                            System.out.println("Artista eliminado correctamente.");
                        } else {
                            System.out.println("No se pudo eliminar el artista.");
                        }
                    } else {
                        System.out.println("No hay registro para ese artista. No se puede eliminar.");
                    }
                    break;
                case 7:
                    System.out.println("Se procede a eliminar todos los registros.");
                    servicioArtistas.eliminarTodosArtistas();
                    System.out.println("Todos los artistas han sido eliminados.");
                    break;
                case 99:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != END_NUMBER);
    }
}