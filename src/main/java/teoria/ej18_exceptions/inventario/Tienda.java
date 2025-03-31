package teoria.ej18_exceptions.inventario;

public class Tienda {
    public static void main(String[] args) {
        Inventario inventario = new Inventario(100);

        try {
            inventario.agregarProducto(50);  // Añadir 50 productos
            inventario.agregarProducto(60);  // Intentar agregar más productos de los que caben
        } catch (InventarioLlenoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            inventario.comprarProducto(30);  // Comprar 30 productos
            inventario.comprarProducto(25);  // Intentar comprar más productos de los que hay
        } catch (StockInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
