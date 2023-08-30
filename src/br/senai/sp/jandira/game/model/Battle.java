package br.senai.sp.jandira.game.model;

import java.util.Scanner;

public class Battle {

    String scenarioBattle;


    Scanner teclado = new Scanner(System.in);

    /** Instancia Scenario */
    Scenario scenario = new Scenario();

    int chanceDefesa;

    public void ChoiceScenario(){

        System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
        System.out.println("Escolha um Cenario: ");
        System.out.println("1- Arabia  2- Grecia  3- Los Angeles 4- Toquio 5- Pequim 6- Las Vegas");
        System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");

        int userScenario = teclado.nextInt();

        scenarioBattle = scenario.Scenario(userScenario);

        System.out.println(scenarioBattle);

    }

    public void Battle(Player player, Enemy enemy) {

        while (true) {

            int lifePlayer = player.GetLife();
            int lifeEnemy = enemy.GetLife();

            if (lifePlayer == 0) {
                System.out.println("O Vencedor é o Enemy " + enemy.name);
                break;
            } else if (lifeEnemy == 0) {
                System.out.println("O Vencedor é o Player " + player.name);
                break;
            }


            System.out.println("---------------------------- Battle ---------------------------");
            System.out.println(" Ataque Player [ R ] - " + player.name + " life: " + lifePlayer);
            System.out.println(" Ataque Enemy  [ Q ] - " + enemy.name + " life: " + lifeEnemy);
            System.out.println("---------------------------------------------------------------");

            String attack = teclado.next();

            if (attack.equalsIgnoreCase("R")) {

                System.out.println("------------------------------------");
                System.out.println("-           Player Atacou          -");
                System.out.println("------------------------------------");

                System.out.print("Defesa Inimigo [ 1 a 5 ]: ");
                int defesa = teclado.nextInt();

                int danoPlayer = (int) (Math.random() * 20) + 1;
                int defesaInimigo = (int) (Math.random() * 20) + 1;
                chanceDefesa = (int) (Math.random() * 5) + 1;
                int danoReal = danoPlayer;

                if (defesa == chanceDefesa){

                    if (defesaInimigo > danoPlayer){
                        break;
                    }else if (defesaInimigo < danoPlayer){
                        danoReal = danoPlayer - defesaInimigo;
                        System.out.println("O inimigo defendeu " + defesaInimigo + " de dano");
                    }

                }else {
                    System.out.println("O inimigo falhou na defesa!");
                }

                enemy.SubtrairVida(danoReal);
                System.out.println("O ataque foi de: " + danoReal);

                enemy.SubtrairVida(danoPlayer);

                System.out.println("-----------------------------------");
                System.out.println("O ataque foi de: " + danoPlayer);
                System.out.println("-----------------------------------");

            } else if (attack.equalsIgnoreCase("Q")) {

                System.out.println("------------------------------------");
                System.out.println("-           Enemy Atacou          -");
                System.out.println("------------------------------------");
                System.out.print("Defesa Jogador [ 1 a 5 ]: ");
                int defesa = teclado.nextInt();

                int danoEnemy = (int) (Math.random() * 20) + 1;
                int defesaJogador = (int) (Math.random() * 20) + 1;
                chanceDefesa = (int) (Math.random() * 5) + 1;
                int danoReal = danoEnemy;

                if (defesa == chanceDefesa){

                    if (defesaJogador > danoEnemy){
                        break;
                    }else if (defesaJogador < danoEnemy){
                        danoReal = danoEnemy - defesaJogador;
                        System.out.println("O Jogador defendeu " + defesaJogador + " de dano");
                    }

                }else {
                    System.out.println("O inimigo falhou na defesa!");
                }

                enemy.SubtrairVida(danoReal);
                System.out.println("O ataque foi de: " + danoReal);


                player.SubtrairVida(danoEnemy);

                System.out.println("-----------------------------------");
                System.out.println("O ataque foi de: " + danoEnemy);
                System.out.println("-----------------------------------");

            } else {
                System.out.println("Tecla Invalida !!!!");
            }

        }

    }

    }
