package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GridGame extends JFrame {
    private int gridSize = 10;
    private JPanel boardPanel;
    private JButton[][] boardButtons;
    private boolean playerTurn = true;

    public GridGame() {
        setTitle("Grid Game - Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

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

        boardPanel = new JPanel();
        add(boardPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JButton loadButton = new JButton("Load");
        JButton saveButton = new JButton("Save");
        controlPanel.add(loadButton);
        controlPanel.add(saveButton);
        add(controlPanel, BorderLayout.SOUTH);

        initializeGame();
    }

    private void initializeGame() {
        boardPanel.removeAll();
        boardPanel.setLayout(new GridLayout(gridSize, gridSize));
        boardButtons = new JButton[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50, 50));
                button.setBackground(Color.WHITE);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                button.setOpaque(true);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton clickedButton = (JButton) e.getSource();
                        if (clickedButton.getBackground() == Color.WHITE) {
                            clickedButton.setIcon(playerTurn ? createIcon(Color.RED) : createIcon(Color.BLUE));
                            playerTurn = !playerTurn;
                        }
                    }
                });
                boardButtons[i][j] = button;
                boardPanel.add(button);
            }
        }

        revalidate();
        repaint();
    }

    private ImageIcon createIcon(Color color) {
        int diameter = 40;
        ImageIcon icon = new ImageIcon(new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB));
        Graphics2D g2d = (Graphics2D) icon.getImage().getGraphics();
        g2d.setColor(color);
        g2d.fillOval(0, 0, diameter, diameter);
        g2d.dispose();
        return icon;
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
