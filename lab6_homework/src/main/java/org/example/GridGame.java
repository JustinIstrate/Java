package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

public class GridGame extends JFrame implements Serializable {
    private int gridSize = 10;
    private JPanel boardPanel;
    private boolean[][] sticks;
    private boolean[][] redStones;
    private boolean[][] blueStones;
    private boolean playerTurn = true; // true for red  false for blue

    public GridGame() {
        setTitle("Grid Game - Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Configuration Panel
        JPanel configPanel = new JPanel();
        JLabel gridSizeLabel = new JLabel("Grid Size:");
        JTextField gridSizeField = new JTextField("10", 5);
        JButton createButton = new JButton("Create");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gridSize = Integer.parseInt(gridSizeField.getText());
                initializeGame();
            }
        });

        configPanel.add(gridSizeLabel);
        configPanel.add(gridSizeField);
        configPanel.add(createButton);
        add(configPanel, BorderLayout.NORTH);

        // Board Panel
        boardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBoard((Graphics2D) g);
            }
        };
        boardPanel.setPreferredSize(new Dimension(500, 500));
        boardPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                placeStone(e.getX(), e.getY());
            }
        });
        add(boardPanel, BorderLayout.CENTER);

        // Control Panel
        JPanel controlPanel = new JPanel();
        JButton loadButton = new JButton("Load");
        JButton saveButton = new JButton("Save");
        JButton exitButton = new JButton("Exit");
        JButton exportButton = new JButton("Export");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadGame("saved_game.ser");
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGame("saved_game.ser");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportBoardImage();
            }
        });
        controlPanel.add(loadButton);
        controlPanel.add(saveButton);
        controlPanel.add(exitButton);
        controlPanel.add(exportButton);
        add(controlPanel, BorderLayout.SOUTH);
        initializeGame();
    }

    private void initializeGame() {
        sticks = new boolean[gridSize + 1][gridSize + 1];
        redStones = new boolean[gridSize][gridSize];
        blueStones = new boolean[gridSize][gridSize];
        Random random = new Random();

        // Place random sticks
        for (int i = 0; i < gridSize * gridSize / 2; i++) {
            int startX = random.nextInt(gridSize);
            int startY = random.nextInt(gridSize);
            int endX = startX + (random.nextBoolean() ? 1 : 0);
            int endY = startY + (random.nextBoolean() ? 1 : 0);

            if (startX >= 0 && startX < gridSize && startY >= 0 && startY < gridSize && endX >= 0 && endX < gridSize + 1 && endY >= 0 && endY < gridSize + 1) {
                sticks[startX][startY] = true;
                sticks[endX][endY] = true;
            }
        }

        repaint();
    }

    private void drawBoard(Graphics2D g2d) {
        int margin = 20; // Define the margin size

        int availableWidth = boardPanel.getWidth() - 2 * margin;
        int availableHeight = boardPanel.getHeight() - 2 * margin;
        int squareSize = Math.min(availableWidth / gridSize, availableHeight / gridSize);

        g2d.setStroke(new BasicStroke(1)); //default line thickness

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                // Draw stick
                if (i < gridSize - 1 && j < gridSize - 1) {
                    g2d.setColor(Color.BLACK);
                    if (sticks[i][j] && sticks[i + 1][j]) {
                        g2d.setStroke(new BasicStroke(3));
                    } else {
                        g2d.setStroke(new BasicStroke(1));
                    }
                    g2d.drawLine(margin + (i + 1) * squareSize, margin + j * squareSize, margin + (i + 1) * squareSize, margin + (j + 1) * squareSize);

                    if (sticks[i][j] && sticks[i][j + 1]) {
                        g2d.setStroke(new BasicStroke(3));
                    } else {
                        g2d.setStroke(new BasicStroke(1));
                    }
                    g2d.drawLine(margin + i * squareSize, margin + (j + 1) * squareSize, margin + (i + 1) * squareSize, margin + (j + 1) * squareSize);
                }
                // Draw stones
                g2d.setColor(Color.BLACK);
                g2d.draw(new Ellipse2D.Double(margin + i * squareSize - squareSize / 4, margin + j * squareSize - squareSize / 4, squareSize / 2, squareSize / 2));
                g2d.setColor(Color.WHITE); // Change the color to white
                g2d.fill(new Ellipse2D.Double(margin + i * squareSize - squareSize / 4, margin + j * squareSize - squareSize / 4, squareSize / 2, squareSize / 2));
                if (redStones[i][j]) {
                    g2d.setColor(Color.RED);
                    g2d.fill(new Ellipse2D.Double(margin + i * squareSize - squareSize / 4, margin + j * squareSize - squareSize / 4, squareSize / 2, squareSize / 2));
                } else if (blueStones[i][j]) {
                    g2d.setColor(Color.BLUE);
                    g2d.fill(new Ellipse2D.Double(margin + i * squareSize - squareSize / 4, margin + j * squareSize - squareSize / 4, squareSize / 2, squareSize / 2));
                }
            }
        }
    }

    private void placeStone(int x, int y) {
        int squareSize = boardPanel.getWidth() / gridSize;
        int radius = squareSize / 2;

        int col = (x + radius) / squareSize;
        int row = (y + radius) / squareSize;
        int centerX = col * squareSize;
        int centerY = row * squareSize;

        if (isNode(col, row)) {
            if (!redStones[col][row] && !blueStones[col][row]) {
                if (playerTurn) {
                    redStones[col][row] = true;
                } else {
                    blueStones[col][row] = true;
                }

                playerTurn = !playerTurn;
                repaint();

                // Check for a winner
                if (checkWinner()) {
                    JOptionPane.showMessageDialog(this, "Player " + (playerTurn ? "Red" : "Blue") + " wins!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Node is already occupied!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid node! You can only place stones on valid nodes.");
        }
    }

    private boolean isNode(int col, int row) {
        if (col < 0 || col >= gridSize || row < 0 || row >= gridSize) {
            return false;
        }

        if ((col > 0 && sticks[col - 1][row]) || (col < gridSize - 1 && sticks[col + 1][row]) ||
                (row > 0 && sticks[col][row - 1]) || (row < gridSize - 1 && sticks[col][row + 1])) {
            return true;
        }

        return false;
    }

    private boolean checkWinner() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (!redStones[i][j] && !blueStones[i][j] && isNode(i, j)) {
                    return false; // There are still valid nodes to place stones
                }
            }
        }
        return true; // No valid nodes left game over
    }

    private void exportBoardImage() {
        BufferedImage image = new BufferedImage(boardPanel.getWidth(), boardPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        boardPanel.paint(g2d);
        g2d.dispose();
        File outputFile = new File("board_image.png");
        try {
            ImageIO.write(image, "png", outputFile);
            JOptionPane.showMessageDialog(this, "Board image exported successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to export board image!");
        }
    }

    private void saveGame(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(this);
            JOptionPane.showMessageDialog(this, "Game saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to save game!");
        }
    }

    private void loadGame(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            GridGame savedGame = (GridGame) in.readObject();
            this.gridSize = savedGame.gridSize;
            this.sticks = savedGame.sticks;
            this.redStones = savedGame.redStones;
            this.blueStones = savedGame.blueStones;
            this.playerTurn = savedGame.playerTurn;
            JOptionPane.showMessageDialog(this, "Game loaded successfully!");
            repaint();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load game!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GridGame gridGame = new GridGame();
                gridGame.pack();
                gridGame.setVisible(true);
            }
        });
    }
}
