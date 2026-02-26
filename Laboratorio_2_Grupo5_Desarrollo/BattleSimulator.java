package Laboratorio_2_Grupo5_Desarrollo;

import java.util.Scanner;
import java.util.Random;

public class BattleSimulator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean jugar = true;

        while (jugar) {

            System.out.println("\n== CONFIGURAR JUGADOR ==");

            System.out.print("Vida del jugador: ");
            int playerLife = scanner.nextInt();

            System.out.print("Ataque físico del jugador: ");
            int physicalAttackPlayer = scanner.nextInt();

            System.out.print("Ataque mágico del jugador: ");
            int magicalAttackPlayer = scanner.nextInt();

            System.out.print("Defensa (regeneración) del jugador: ");
            int playerDefense = scanner.nextInt();

            System.out.print("Crítico (% probabilidad y aumento): ");
            int playerCritical = scanner.nextInt();


            System.out.println("\n== CONFIGURAR ENEMIGO ==");

            System.out.print("Vida del enemigo: ");
            int enemyLife = scanner.nextInt();

            System.out.print("Ataque físico del enemigo: ");
            int physicalAttackEnemy = scanner.nextInt();

            System.out.print("Ataque mágico del enemigo: ");
            int magicalAttackEnemy = scanner.nextInt();

            System.out.print("Defensa (regeneración) del enemigo: ");
            int enemyDefense = scanner.nextInt();

            System.out.print("Crítico (% probabilidad y aumento): ");
            int enemyCritical = scanner.nextInt();


            System.out.println("\n=== INICIO DE LA BATALLA ===");

            int ronda = 1;
            int maxRondas = 10;

            while (playerLife > 0 && enemyLife > 0 && ronda <= maxRondas) {

                System.out.println("\n--- Ronda " + ronda + " ---");

                // ===== TURNO JUGADOR =====
                int tipoAtaqueJugador = random.nextInt(2);
                int playerDamage;

                if (tipoAtaqueJugador == 0) {
                    playerDamage = physicalAttackPlayer;
                    System.out.println("Jugador usa ataque físico.");
                } else {
                    playerDamage = magicalAttackPlayer;
                    System.out.println("Jugador usa ataque mágico.");
                }

                // CRÍTICO
                if (random.nextInt(100) < playerCritical) {
                    int aumento = playerDamage * playerCritical / 100;
                    playerDamage += aumento;
                    System.out.println("¡Golpe crítico del jugador!");
                }

                enemyLife -= playerDamage;

                System.out.println("Jugador causa " + playerDamage + " de daño.");
                System.out.println("Vida enemigo: " + Math.max(enemyLife, 0));


                // ===== TURNO ENEMIGO =====
                if (enemyLife > 0) {

                    int tipoAtaqueEnemigo = random.nextInt(2);
                    int enemyDamage;

                    if (tipoAtaqueEnemigo == 0) {
                        enemyDamage = physicalAttackEnemy;
                        System.out.println("Enemigo usa ataque físico.");
                    } else {
                        enemyDamage = magicalAttackEnemy;
                        System.out.println("Enemigo usa ataque mágico.");
                    }

                    // CRÍTICO
                    if (random.nextInt(100) < enemyCritical) {
                        int aumento = enemyDamage * enemyCritical / 100;
                        enemyDamage += aumento;
                        System.out.println("¡Golpe crítico del enemigo!");
                    }

                    playerLife -= enemyDamage;

                    System.out.println("Enemigo causa " + enemyDamage + " de daño.");
                    System.out.println("Vida jugador: " + Math.max(playerLife, 0));
                }

                // ===== REGENERACIÓN =====
                playerLife += playerDefense;
                enemyLife += enemyDefense;

                System.out.println("Jugador se regenera " + playerDefense + " puntos.");
                System.out.println("Enemigo se regenera " + enemyDefense + " puntos.");

                ronda++;
            }

            System.out.println("\n=== FIN DE LA BATALLA ===");

            if (playerLife > enemyLife) {
                System.out.println("El jugador gana.");
            } else if (enemyLife > playerLife) {
                System.out.println("El enemigo gana.");
            } else {
                System.out.println("Empate por límite de rondas.");
            }

            System.out.print("\n¿Quieres jugar otra vez? (s/n): ");
            String respuesta = scanner.next();

            if (!respuesta.equalsIgnoreCase("s")) {
                jugar = false;
            }
        }

        System.out.println("\nGracias por jugar.");
        scanner.close();
    }
} 

