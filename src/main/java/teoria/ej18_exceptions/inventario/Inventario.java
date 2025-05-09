package teoria.ej18_exceptions.inventario;

class Inventario {
    private int cantidadMaxima;
    private int cantidadActual;

    public Inventario(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadActual = 0;
    }

    // Método para agregar productos al inventario
    public void agregarProducto(int cantidad) throws InventarioLlenoException{
        throw new UnsupportedOperationException("A implementar por el alumno");
    }

    // Método para comprar productos del inventario
    public void comprarProducto(int cantidad) {
        throw new UnsupportedOperationException("A implementar por el alumno");
    }

    public int getCantidadActual() {
        return cantidadActual;
    }
}