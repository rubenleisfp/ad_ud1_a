package teoria.ej18_exceptions.inventario;

class Inventario {
    private int cantidadMaxima;
    private int cantidadActual;

    public Inventario(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadActual = 0;
    }

    // Método para agregar productos al inventario
    public void agregarProducto(int cantidad) throws InventarioLlenoException {
        if (cantidadActual + cantidad > cantidadMaxima) {
            throw new InventarioLlenoException("No se puede agregar más productos, el inventario está lleno.");
        } else {
            cantidadActual += cantidad;
            System.out.println("Producto agregado. Cantidad actual: " + cantidadActual);
        }
    }

    // Método para comprar productos del inventario
    public void comprarProducto(int cantidad) {
        if (cantidad > cantidadActual) {
            throw new StockInsuficienteException("No hay suficiente stock disponible para la compra.");
        }
        cantidadActual -= cantidad;
        System.out.println("Producto comprado. Cantidad restante: " + cantidadActual);
    }

    public int getCantidadActual() {
        return cantidadActual;
    }
}