package Laboratorio_2_Grupo5_Desarrollo;
import java.util.Scanner;
public class ScoreBoard {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int point = 0;
        int option = 0;
        do{
            System.out.println("\n===========================================================");
            System.out.println("====                  MARCADOR DE PUNTOS                 ====");
            System.out.println("===========================================================");
            System.out.println("===                1. Sumar Puntos                      ===");
            System.out.println("===                2. Restar Puntos                     ===");
            System.out.println("===                3. Ver Marcador                        ===");
            System.out.println("===                4. Salir                             ===");
            System.out.println("===========================================================\n");
            option=sc.nextInt();

            switch (option) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }
        }while (option!=4);

    sc.close();
    }
}
