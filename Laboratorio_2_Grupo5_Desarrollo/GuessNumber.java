package Laboratorio_2_Grupo5_Desarrollo;
import java.util.Scanner;
public class GuessNumber {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int secret = (int)(Math.random() * 50) +1;
        boolean success = false ;
        int attemps = 0;
        System.out.println("\n===ADIVINA EL NUMERO ARCADE===");
        while (!success ){
            System.out.println("\nIncerte el numero a adivinar");
            int number = sc.nextInt();
            attemps++;
         if (number == secret){
            System.out.println("ACERTASTE!!!");
            success = true;
        }else if (number < secret) {
            System.out.println("El numero es bajo");
        }else {
            System.out.println("El numero es Alto");
        }
    }
        System.out.println("El numero secreto es: " + secret);
        System.out.println("Lo lograste en " + attemps + " intentos ");
    sc.close();
    }
}
