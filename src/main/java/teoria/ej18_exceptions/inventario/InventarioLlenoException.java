package teoria.ej18_exceptions.inventario;

class InventarioLlenoException extends Exception {
    public InventarioLlenoException(String mensaje) {
        super(mensaje);
    }
}