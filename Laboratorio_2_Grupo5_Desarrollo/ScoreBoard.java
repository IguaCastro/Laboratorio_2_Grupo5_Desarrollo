package Laboratorio_2_Grupo5_Desarrollo;
import java.util.Scanner;
public class ScoreBoard {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int point = 0;
        int option = 0;
        do{
            System.out.println("\n===========================================================");
            System.out.println("====                  MARCADOR DE PUNTOS               ====");
            System.out.println("===========================================================");
            System.out.println("===                1. Sumar Puntos                      ===");
            System.out.println("===                2. Restar Puntos                     ===");
            System.out.println("===                3. Ver Marcador                      ===");
            System.out.println("===                4. Salir                             ===");
            System.out.println("===========================================================\n");
            option=sc.nextInt();

            switch (option) {
                case 1: 
                    point++;
                    System.out.println("Has sumado 1 punto");
                    break;
                case 2:
                    if (point > 0){
                        point--;
                        System.out.println("Has restado 1 punto");
                    }else{
                        System.out.println("No puedes tener numeros negativos");
                    }
                    break;
                case 3:
                    System.out.println("Tu puntuación actual es: " + point);
                    break;
                case 4:
                    System.out.println("Saliendo del Menú");
                    break;
                default:
                    System.out.println("Opción incorrecta, vuelve a elegir una de las opciones que se muestra");
                    break;
            }
        }while (option!=4);

    sc.close();
    }
}
