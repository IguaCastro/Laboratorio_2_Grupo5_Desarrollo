package Laboratorio_2_Grupo5_Desarrollo;

import java.util.Scanner;
import java.util.Random;

public class GeneratorLevel {

    public static void main(String[] args) {

        // Scanner permite leer datos que escribe el usuario
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("=== Generador de Niveles ===");

            // MEJORA 1: El usuario puede elegir el nivel
            System.out.print("Elige un nivel (1-3): ");
            int level = scanner.nextInt();

            // MEJORA 2: Validación para evitar niveles incorrectos
            if (level < 1 || level > 3) {
                System.out.println("Error: Debes elegir un nivel entre 1 y 3.");
                return;
            }

            // MEJORA 3: El usuario puede elegir la altura del mapa
            System.out.print("Escribe la altura del mapa: ");
            int height = scanner.nextInt();

            // MEJORA 4: El usuario puede elegir la anchura del mapa
            System.out.print("Escribe la anchura del mapa: ");
            int width = scanner.nextInt();

            // MEJORA 5: Validación para evitar mapas demasiado pequeños
            if (height < 5 || width < 5) {
                System.out.println("El mapa debe ser al menos de tamaño 5x5.");
                return;
            }

            System.out.println("\nNivel seleccionado: " + level);
            System.out.println("Altura: " + height + " | Ancho: " + width);
            System.out.println("\nMapa generado:\n");

            // MEJORA 6: Se usa un método separado para generar el nivel
            generateLevel(height, width);

            System.out.println("\nNivel generado correctamente.");
        }
    }

    // Método que genera el mapa del nivel
    public static void generateLevel(int height, int width) {

        // MEJORA 7: Uso de Random para generar elementos aleatorios
        Random random = new Random();

        // MEJORA 8: Se agregó un jugador en la posición inicial
        int playerX = 1;
        int playerY = 1;

        // MEJORA 9: Se agregó una salida del nivel
        int exitX = height - 2;
        int exitY = width - 2;

        // MEJORA 10: Se agregó un tesoro en posición aleatoria
        int treasureX = random.nextInt(height - 2) + 1;
        int treasureY = random.nextInt(width - 2) + 1;

        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {

                // Bordes del mapa (paredes)
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

                    // MEJORA 11: Obstáculos aleatorios
                    if (chance == 1) {
                        System.out.print("O");
                    }

                    // MEJORA 12: Enemigos aleatorios
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

        // MEJORA 13: Leyenda para explicar los símbolos del mapa
        System.out.println("\nLeyenda:");
        System.out.println("# = Pared");
        System.out.println("P = Jugador");
        System.out.println("S = Salida");
        System.out.println("T = Tesoro");
        System.out.println("O = Obstáculo");
        System.out.println("E = Enemigo");
    }
}