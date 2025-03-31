package teoria.ej18_exceptions;

import java.io.IOException;

public class EjercicioExcepciones {

    // Método que lanza una checked exception
    public static void metodoChecked() throws IOException {
        throw new IOException("Error de E/S (checked exception)");
    }

    // Método que lanza una unchecked exception
    public static void metodoUnchecked() {
        throw new ArithmeticException("Error aritmético (unchecked exception)");
    }

    public static void main(String[] args) {
        // 1. Intenta llamar a ambos métodos sin capturar las excepciones
        // metodoChecked();
        // metodoUnchecked();
        
        // 2. Ahora envuelve las llamadas en bloques try-catch
        try {
            metodoChecked();
        } catch (IOException e) {
            System.out.println("Capturada excepción checked: " + e.getMessage());
        }

        try {
            metodoUnchecked();
        } catch (ArithmeticException e) {
            System.out.println("Capturada excepción unchecked: " + e.getMessage());
        }
    }
}
