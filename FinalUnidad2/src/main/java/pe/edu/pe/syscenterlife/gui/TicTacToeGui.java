/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pe.syscenterlife.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGui extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private JTextField player1Field;
    private JTextField player2Field;
    private JLabel turnLabel;
    private boolean isXturn = true; // X starts
    private JTable scoreTable;
    private DefaultTableModel tableModel;

    public TicTacToeGui() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Tic Tac Toe");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                boardPanel.add(buttons[i][j]);
            }
        }

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(4, 2));

        player1Field = new JTextField();
        player2Field = new JTextField();
        turnLabel = new JLabel("Turno: X", SwingConstants.CENTER);

        JButton startButton = new JButton("Iniciar");
        JButton resetButton = new JButton("Anular");

        startButton.addActionListener(new StartButtonListener());
        resetButton.addActionListener(new ResetButtonListener());

        controlPanel.add(new JLabel("Nombre Jugador 1:"));
        controlPanel.add(player1Field);
        controlPanel.add(new JLabel("Nombre Jugador 2:"));
        controlPanel.add(player2Field);
        controlPanel.add(startButton);
        controlPanel.add(resetButton);
        controlPanel.add(turnLabel);

        String[] columnNames = {"Nombre Partido", "Nombre Jugador 1", "Nombre Jugador 2", "Nombre Ganador", "Puntuación", "Estado"};
        tableModel = new DefaultTableModel(columnNames, 0);
        scoreTable = new JTable(tableModel);

        add(boardPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.NORTH);
        add(new JScrollPane(scoreTable), BorderLayout.SOUTH);
    }

    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons[row][col].getText().equals("")) {
                buttons[row][col].setText(isXturn ? "X" : "O");
                turnLabel.setText("Turno: " + (isXturn ? "O" : "X"));
                isXturn = !isXturn;
                checkWinner();
            }
        }
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            resetBoard();
        }
    }

    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            resetBoard();
        }
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        isXturn = true;
        turnLabel.setText("Turno: X");
    }

    private void checkWinner() {
        // Implement your winner checking logic here
        // Update the score table if there is a winner
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToeGui().setVisible(true);
            }
        });
    }
}
