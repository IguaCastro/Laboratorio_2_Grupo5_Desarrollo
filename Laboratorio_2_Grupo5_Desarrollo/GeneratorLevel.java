package Laboratorio_2_Grupo5_Desarrollo;

import java.util.Scanner;

public class GeneratorLevel {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int level;
        int height;
        int width;

        System.out.println("=== Generador de Niveles ===");
        System.out.println("Elige un nivel:");
        System.out.println("1 - Mapa de Estrellas");
        System.out.println("2 - Mapa de Bloques");
        System.out.println("3 - Mapa con Bordes");

        System.out.print("Ingrese el nivel: ");
        level = scanner.nextInt();

        System.out.print("Ingrese la altura del mapa: ");
        height = scanner.nextInt();

        System.out.print("Ingrese el ancho del mapa: ");
        width = scanner.nextInt();

        System.out.println("\nMapa generado:\n");

        switch (level) {

            case 1:
                // Patrón de estrellas
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;

            case 2:
                // Patrón de bloques
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        System.out.print("# ");
                    }
                    System.out.println();
                }
                break;

            case 3:
                // Patrón con bordes
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {

                        if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }

                    }
                    System.out.println();
                }
                break;

            default:
                System.out.println("Nivel inválido.");
        }

        scanner.close();
    }
}