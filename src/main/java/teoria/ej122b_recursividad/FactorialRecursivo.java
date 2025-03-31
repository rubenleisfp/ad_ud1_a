package teoria.ej122b_recursividad;

public class FactorialRecursivo {

    public static int factorial(int n) {
        // Caso base: factorial(0) = 1
        if (n == 0) {
            return 1;
        }
        // Caso recursivo: factorial(n) = n * factorial(n-1)
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 5; // Ejemplo, calcular el factorial de 5
        int resultado = factorial(n);
        System.out.println("Factorial de " + n + " es: " + resultado);
    }
}