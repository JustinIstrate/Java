package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int numPlayers = 3;

        BagOfTokens bag = new BagOfTokens(n);

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player("Player " + i, bag));
        }

        for (Player player : players) {
            player.start();
        }

        for (Player player : players) {
            try {
                player.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Player player : players) {
            System.out.println(player.getName() + " points: " + player.getPoints());
        }
    }
}