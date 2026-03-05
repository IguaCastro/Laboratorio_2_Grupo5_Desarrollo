package Laboratorio_2_Grupo5_Desarrollo;

import java.util.Scanner;

import java.util.Random;

public class GeneratorLevel {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("=== Generador de Niveles ===");

            // Elegir nivel
            System.out.print("Elige un nivel (1-3): ");
            int level = scanner.nextInt();

            // Validación del nivel
            if (level < 1 || level > 3) {
                System.out.println("Error: Debes elegir un nivel entre 1 y 3.");
                return;
            }

            // Usuario define tamaño del mapa
            System.out.print("Escribe la altura del mapa: ");
            int height = scanner.nextInt();

            System.out.print("Escribe la anchura del mapa: ");
            int width = scanner.nextInt();

            // Validación mínima del tamaño
            if (height < 5 || width < 5) {
                System.out.println("El mapa debe ser al menos de tamaño 5x5.");
                return;
            }

            System.out.println("\nNivel seleccionado: " + level);
            System.out.println("Altura: " + height + " | Ancho: " + width);
            System.out.println("\nMapa generado:\n");

            generateLevel(height, width);

            System.out.println("\nNivel generado correctamente.");
        }
    }

    // Método que genera el mapa
    public static void generateLevel(int height, int width) {

        Random random = new Random();

        // Posiciones especiales
        int playerX = 1;
        int playerY = 1;

        int exitX = height - 2;
        int exitY = width - 2;

        int treasureX = random.nextInt(height - 2) + 1;
        int treasureY = random.nextInt(width - 2) + 1;

        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {

                // Bordes
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.print("#");
                }

                // Jugador
                else if (i == playerX && j == playerY) {
                    System.out.print("P");
                }

                // Salida
                else if (i == exitX && j == exitY) {
                    System.out.print("S");
                }

                // Tesoro
                else if (i == treasureX && j == treasureY) {
                    System.out.print("T");
                }

                else {

                    int chance = random.nextInt(10);

                    // Obstáculo
                    if (chance == 1) {
                        System.out.print("O");
                    }

                    // Enemigo
                    else if (chance == 2) {
                        System.out.print("E");
                    }

                    // Espacio libre
                    else {
                        System.out.print(" ");
                    }
                }
            }

            System.out.println();
        }

        // Leyenda
        System.out.println("\nLeyenda:");
        System.out.println("# = Pared");
        System.out.println("P = Jugador");
        System.out.println("S = Salida");
        System.out.println("T = Tesoro");
        System.out.println("O = Obstáculo");
        System.out.println("E = Enemigo");
    }
}