package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Player extends Thread {
    private final String name;
    private final BagOfTokens bag;
    private final List<Token> sequence;
    private int points;

    public Player(String name, BagOfTokens bag) {
        this.name = name;
        this.bag = bag;
        this.sequence = new ArrayList<>();
        this.points = 0;
    }
    public int getPoints() {
        return points;
    }
    public String getPlayerName() {
        return name;
    }
    @Override
    public void run() {
        try {
            while (!bag.isEmpty()) {
                synchronized (bag) {
                    Token token = bag.extractToken();
                    sequence.add(token);
                    points = Math.max(points, sequence.size());
                    System.out.println(name + " extracted token " + token);
                    if (sequence.size() == token.getValue()) {
                        System.out.println(name + " made a sequence of length " + token.getValue());
                        break;
                    }
                }
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
