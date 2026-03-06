package Laboratorio_2_Grupo5_Desarrollo;

import java.util.Scanner;
import java.util.Random;

public class GeneratorLevel {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("=== Generador de Niveles ===");

            System.out.print("Elige un nivel (1-3): ");
            int level = scanner.nextInt();

            // Uso de SWITCH para seleccionar nivel
            int difficulty;

            switch (level) {
                case 1:
                    System.out.println("Nivel Fácil seleccionado.");
                    difficulty = 6;
                    break;

                case 2:
                    System.out.println("Nivel Medio seleccionado.");
                    difficulty = 10;
                    break;

                case 3:
                    System.out.println("Nivel Difícil seleccionado.");
                    difficulty =15;
                    break;

                default:
                    System.out.println("Error: Debes elegir un nivel entre 1 y 3.");
                    return;
            }

            System.out.print("Escribe la altura del mapa: ");
            int height = scanner.nextInt();

            System.out.print("Escribe la anchura del mapa: ");
            int width = scanner.nextInt();

            if (height < 5 || width < 5) {
                System.out.println("El mapa debe ser al menos de tamaño 5x5.");
                return;
            }

            System.out.println("\nNivel seleccionado: " + level);
            System.out.println("Altura: " + height + " | Ancho: " + width);
            System.out.println("\nMapa generado:\n");

            generateLevel(height, width, difficulty);

            System.out.println("\nNivel generado correctamente.");
        }
    }

    public static void generateLevel(int height, int width, int difficulty) {

        Random random = new Random();

        int playerX = 1;
        int playerY = 1;

        int exitX = height - 2;
        int exitY = width - 2;

        int treasureX = random.nextInt(height - 2) + 1;
        int treasureY = random.nextInt(width - 2) + 1;

        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {

                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.print("#");
                }

                else if (i == playerX && j == playerY) {
                    System.out.print("P");
                }

                else if (i == exitX && j == exitY) {
                    System.out.print("S");
                }

                else if (i == treasureX && j == treasureY) {
                    System.out.print("T");
                }

                else {

                    int chance = random.nextInt(difficulty);

                    if (chance == 1) {
                        System.out.print("O"); // Obstáculo
                    }

                    else if (chance == 2) {
                        System.out.print("E"); // Enemigo
                    }

                    else {
                        System.out.print(" ");
                    }
                }
            }

            System.out.println();
        }
    }
}