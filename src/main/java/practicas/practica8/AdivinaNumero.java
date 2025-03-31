package practicas.practica8;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class AdivinaNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroAdivinar = random.nextInt(500) + 1;  // Genera un número entre 1 y 500
        int intentos = 0;
        int numeroUsuario = 0;
        boolean haAdivinado = false;

        System.out.println("¡Bienvenido al juego de adivinanza de números!");

        do {
            boolean entradaValida = false;

            // Este bucle controla la validación del input del usuario
            do {
                System.out.print("Introduce un número entre 1 y 500: ");
                try {
                    numeroUsuario = scanner.nextInt();
                    entradaValida = true; // Si llega aquí, la entrada es válida
                } catch (InputMismatchException e) {
                    System.out.println("Eso no es un número válido. Por favor, introduce un número entero.");
                    scanner.next(); // Limpiar la entrada no válida
                    intentos++; // Contar como un intento fallido
                }
            } while (!entradaValida);

            intentos++;

            if (numeroUsuario < numeroAdivinar) {
                System.out.println("El número a adivinar es mayor.");
            } else if (numeroUsuario > numeroAdivinar) {
                System.out.println("El número a adivinar es menor.");
            } else {
                System.out.println("¡Felicidades! Has adivinado el número.");
                haAdivinado = true;
            }

        } while (!haAdivinado);

        System.out.println("Has necesitado " + intentos + " intentos para adivinar el número.");
    }
}
