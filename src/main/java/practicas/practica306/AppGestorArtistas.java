package practicas.practica306;

import practicas.practica306.dao.DaoArtistas;
import practicas.practica306.dao.impl.DaoArtistasFichero;
import practicas.practica306.dao.impl.DaoArtistasMemoria;

import practicas.practica306.model.Artista;
import practicas.practica306.service.ServicioArtistas;
import practicas.practica306.exceptions.RegistroDuplicado;
import practicas.practica306.exceptions.ExcepcionGestorArtista;
import practicas.practica306.utils.PropertiesHandler;
import practicas.practica306.utils.UtilidadesArtista;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AppGestorArtistas {

    private static final String RUTA_FICHERO = "C:/DEV/artistas.txt";
    private static final String TIPO_IMPLEMENTACION_FICHERO ="fichero";
    private static final String TIPO_IMPLEMENTACION_MEMORIA="memoria";
    private static final int END_NUMBER = 99;
    private DaoArtistas daoArtistas;
    private ServicioArtistas servicioArtistas;

    private UtilidadesArtista utilidades = new UtilidadesArtista();



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
            //Mostramos informacion relevante al usuario final
            System.out.println("Error al realizar la operativa");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            //La excepcion solo la relanzamos mientras estamos depurando para ver toda la traza de error
            //Al usuario esto no hay que mostrarselo, no le aporta nada
            //throw new RuntimeException(e);
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
            daoArtistas = new DaoArtistasFichero(new File(RUTA_FICHERO));
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
            Artista artista = null;
            String nombre = "";
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los datos del nuevo artista:");
                    artista = getDatosArtista(scanner);
                    if (servicioArtistas.tieneArtista(artista.getNombre())) {
                        System.out.println("El artista indica ya existe");
                    } else {
                        servicioArtistas.agregarArtista(artista);
                        System.out.println("Artista agregado correctamente.");
                    }
                    break;
                case 2:
                    System.out.println("Artistas guardadas en la agenda:");
                    List<Artista> artistas = servicioArtistas.mostrarArtistas();
                    for (Artista art : artistas) {
                        System.out.println(art);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del artista para saber si existe:");
                    nombre = scanner.nextLine();
                    System.out.println(servicioArtistas.tieneArtista(nombre));
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del artista para obtenerlo:");
                    nombre = scanner.nextLine();
                    System.out.println(servicioArtistas.getArtista(nombre));
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del artista cuya informacion queremos actualizar:");
                    nombre = scanner.nextLine();
                    if (servicioArtistas.tieneArtista(nombre)) {
                        Artista nuevoArtista = getDatosArtista(scanner);
                        servicioArtistas.actualizarArtista(nombre,nuevoArtista);
                    } else {
                        System.out.println("No hay artistas con ese nombre. No se puede actualizar");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el nombre del artista que desea eliminar:");
                    nombre = scanner.nextLine(); // Leer el nombre del artista a eliminar
                    if (servicioArtistas.tieneArtista(nombre)) {
                        boolean artistaEliminado = servicioArtistas.eliminarArtista(nombre);
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

    /**
     * Codigo repetitivo para solicitar datos completos de un artista
     *
     * @param scanner
     * @return
     */
    private Artista getDatosArtista(Scanner scanner) {
        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine(); // Leer el nombre del artista
        System.out.println("Ingrese el salario :");
        String salario = scanner.nextLine(); // Leer el salario del artista
        System.out.println("Fecha/Hora de nacimiento (yyyy-MM-dd):");
        String fechaNacimiento = scanner.nextLine(); // Leer la fecha del artista

        Artista artista = new Artista();
        artista.setNombre(nombre);
        artista.setSalario(Double.parseDouble(salario));
        artista.setFechaNacimiento(utilidades.convertStringToLocalDate(fechaNacimiento));

        return artista;
    }
}