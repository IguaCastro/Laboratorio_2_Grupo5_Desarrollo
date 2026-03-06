package Laboratorio_2_Grupo5_Desarrollo;

import java.util.Scanner;

public class GeneratorLevel {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Generador de Niveles");
            System.out.print("Elige un nivel (1-3): ");
            int level = scanner.nextInt();

            int height = 0;
            int width = 0;

            switch (level) {
                case 1:
                    height = 5;
                    width = 10;
                    break;
                case 2:
                    height = 7;
                    width = 15;
                    break;
                case 3:
                    height = 10;
                    width = 20;
                    break;
                default:
                    System.out.println("Nivel no válido");
                    return;
            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}