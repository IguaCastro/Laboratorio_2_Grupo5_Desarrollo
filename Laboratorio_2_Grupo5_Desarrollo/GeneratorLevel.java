package Laboratorio_2_Grupo5_Desarrollo;

import java.util.Scanner;
import java.util.Random;

public class GeneratorLevel {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== Generador de Niveles ===");

        System.out.print("Elige un nivel (1-3): ");
        int level = scanner.nextInt();

        System.out.print("Ingrese la altura del mapa: ");
        int height = scanner.nextInt();

        System.out.print("Ingrese el ancho del mapa: ");
        int width = scanner.nextInt();

        System.out.println("\nMapa generado:\n");

        switch (level) {

            case 1:
                System.out.println("Nivel 1: Campo de estrellas");
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;

            case 2:
                System.out.println("Nivel 2: Bloques aleatorios");
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {

                        if (random.nextInt(2) == 0) {
                            System.out.print("# ");
                        } else {
                            System.out.print(". ");
                        }

                    }
                    System.out.println();
                }
                break;

            case 3:
                System.out.println("Nivel 3: Mapa con bordes");

                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {

                        if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                            System.out.print("# ");
                        } else {
                            System.out.print(". ");
                        }

                    }
                    System.out.println();
                }
                break;

            default:
                System.out.println("Nivel no válido.");
        }

        scanner.close();
    }
}