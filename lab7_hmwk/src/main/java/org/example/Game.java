package org.example;

public class Game {
    public static void main(String[] args) {
        BagOfTokens bag = new BagOfTokens(5);
        Player player1 = new Player("John", bag);
        Player player2 = new Player("Serby", bag);
        Timekeeper timekeeper = new Timekeeper(20000);

        player1.start();
        player2.start();
        timekeeper.start();

        try {
            player1.join();
            player2.join();
            timekeeper.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int pointsPlayer1 = player1.getPoints();
        int pointsPlayer2 = player2.getPoints();
        if (pointsPlayer1 > pointsPlayer2) {
            System.out.println( player1.getName()+" wins with " + pointsPlayer1 + " points.");
            System.out.println(player2.getName()+ " had " + pointsPlayer2 + " points.");
        } else if (pointsPlayer2 > pointsPlayer1) {
            System.out.println(player2.getName()+ " wins with " + pointsPlayer2 + " points.");
            System.out.println(player1.getName()+" had " + pointsPlayer1 + " points.");
        } else {
            System.out.println("It's a tie!");
            System.out.println(player1.getName()+" had " + pointsPlayer1 + " points.");
            System.out.println(player2.getName()+ " had " + pointsPlayer2 + " points.");
        }
    }
}
