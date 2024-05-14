package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private ServerSocket serverSocket;
    private boolean running = true;

    public GameServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }

    public void start() {
        try {
            while (running) {
                Socket clientSocket = serverSocket.accept();
                new ClientThread(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Error accepting client connection: " + e.getMessage());
        } finally {
            stop();
        }
    }

    public void stop() {
        running = false;
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                System.out.println("Server stopped.");
                serverSocket.close();

            }
        } catch (IOException e) {
            System.err.println("Error stopping server: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int port = 12346;
        GameServer server = new GameServer(port);
        server.start();
    }
}
