package teoria.ej17_xml_dom.producto;

import java.io.File;
import java.util.List;

public class AppProducto {
    public static void main(String[] args) {

      AppProducto appProducto = new AppProducto();
      appProducto.readProductosFromXml();
    }

    public void readProductosFromXml() {
        // Leer y mostrar productos (opcional)
        ProductoDao productoRepository = new ProductoDao();
        List<Producto> productos = productoRepository.readFromXml(new File("src/main/resources/1_7_xml_dom/productos.xml"));

        System.out.println("\nLista de Productos:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}
