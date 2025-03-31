package practicas.practica12;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class Adivinanza {
    public static void main(String[] args) {
        String fileName = "numeros.dat";
        int cantidadNumeros = 10;  // Cantidad de números aleatorios que se generarán
        int maxNumero = 100;  // Máximo número aleatorio posible
        Random random = new Random();

        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
            // Generar y escribir números aleatorios en el archivo
            for (int i = 0; i < cantidadNumeros; i++) {
                int numeroAleatorio = random.nextInt(maxNumero) + 1;  // Genera números entre 1 y maxNumero
                file.writeInt(numeroAleatorio);
            }

            // Permitir al usuario ingresar un número para adivinar
            Scanner scanner = new Scanner(System.in);
            System.out.print("Adivina un número entre 1 y " + maxNumero + ": ");
            int numeroAdivinado = scanner.nextInt();

            // Mover el puntero al inicio del archivo para leer los números
            file.seek(0);
            boolean encontrado = false;

            // Leer los números del archivo y verificar si el número ingresado está en la lista
            for (int i = 0; i < cantidadNumeros; i++) {
                int numeroLeido = file.readInt();
                if (numeroLeido == numeroAdivinado) {
                    encontrado = true;
                    break;
                }
            }

            // Mostrar el resultado
            if (encontrado) {
                System.out.println("¡Felicidades! Adivinaste el número.");
            } else {
                System.out.println("Lo siento, el número no está en la lista.");
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error al manejar el archivo: " + e.getMessage());
        }
    }
}
