package org.example;

import java.util.concurrent.TimeUnit;

public class Timekeeper extends Thread {
    private long timeLimit;
    private boolean gameRunning;

    public Timekeeper(long timeLimit) {
        this.timeLimit = timeLimit;
        this.gameRunning = true;
        setDaemon(true); // setez ca demon thread sa se opreasca cand trheadu principal incheie
    }

    @Override
    public void run(){
        long startTime = System.currentTimeMillis();
        while (gameRunning) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println("Elapsed time: " + TimeUnit.MILLISECONDS.toSeconds(elapsedTime) + " seconds");

            if (elapsedTime >= timeLimit) {
                System.out.println("Time limit reached. Stopping the game.");
                gameRunning = false;
                break;
            }

            try {
                Thread.sleep(1000); // Check every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stopGame() {
        gameRunning = false;
    }
}
