package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Simple Connect Four game.
 * Click a button to drop red/yellow pieces.
 * Detects four in a row and ends the game.
 */
public class Project_Two extends JFrame implements ActionListener {

    /** Board buttons, with  6 rows and 7 columns 
     * 
     */
    private JButton[][] buttons = new JButton[6][7]; 

    /** Track player's turn: red will start (true), yellow goes second (false) 
     * 
     */
    private boolean firstPlayerTurn = true; 

    /** 
     * Main method to start the game 
     */
    public static void main(String[] args) {
        new Project_Two();
    }

    /** 
     * Constructor: sets up GUI and initializes the board 
     */
    public Project_Two() {
        setTitle("Connect Four");
        setSize(700,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6,7));

        for(int r=0;r<6;r++) {
            for(int c=0;c<7;c++) {
                buttons[r][c] = new JButton();
                buttons[r][c].setOpaque(true);
                buttons[r][c].setBorderPainted(false);
                buttons[r][c].setBackground(new Color(173,216,230)); // light blue
                buttons[r][c].addActionListener(this);
                add(buttons[r][c]);
            }
        }

        setVisible(true);
    }

    /**
     * Handles button clicks.
     * Drops the color to the lowest empty row in the clicked column.
     * Shows "Column is full!" if there is no space.
     * Shows "Game Over!" if someone wins or if the board is full and resets.
     * @param e ActionEvent from clicking a button
     */
    public void actionPerformed(ActionEvent e) {
        int col = -1;

        // figure out the column
        for(int c=0;c<7;c++) {
            for(int r=0;r<6;r++) {
                if(e.getSource() == buttons[r][c]) {
                    col = c;
                    break;
                }
            }
            if(col != -1) break;
        }

        if(col == -1) return; // to be safe

        boolean placed = false;
        for(int r=5;r>=0;r--) {
            if(buttons[r][col].getBackground().equals(new Color(173,216,230))) {
                buttons[r][col].setBackground(firstPlayerTurn ? Color.RED : Color.YELLOW);
                firstPlayerTurn = !firstPlayerTurn;
                placed = true;
                break;
            }
        }

        if(!placed) {
            JOptionPane.showMessageDialog(this,"Column is full!");
            return;
        }

        if (checkWin() || isBoardFull()) {
            JOptionPane.showMessageDialog(this,"Game Over!");
            resetBoard();
        }
    }

    /**
     * Checks if the entire board is full (no light blue colors left on the board)
     * @return true if board is full, and false if otherwise
     */
    private boolean isBoardFull() {
        for(int r=0;r<6;r++) {
            for(int c=0;c<7;c++) {
                if(buttons[r][c].getBackground().equals(new Color(173,216,230))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Resets the board to all light blue buttons and sets turn to red 
     */
    private void resetBoard() {
        for(int r=0;r<6;r++) {
            for(int c=0;c<7;c++) {
                buttons[r][c].setBackground(new Color(173,216,230));
            }
        }
        firstPlayerTurn = true;
    }

    /**
     * Checks for four in a row horizontally, vertically, or diagonally.
     * @return true if a player has four in a row
     */
    private boolean checkWin() {
        Color red = Color.RED, yellow = Color.YELLOW;

        for(int r=0;r<6;r++) {
            for(int c=0;c<7;c++) {
                Color color = buttons[r][c].getBackground();
                if(color.equals(red) || color.equals(yellow)) {

                    // horizontal
                    if(c+3<7 && color.equals(buttons[r][c+1].getBackground())
                              && color.equals(buttons[r][c+2].getBackground())
                              && color.equals(buttons[r][c+3].getBackground()))
                        return true;

                    // vertical
                    if(r+3<6 && color.equals(buttons[r+1][c].getBackground())
                              && color.equals(buttons[r+2][c].getBackground())
                              && color.equals(buttons[r+3][c].getBackground()))
                        return true;

                    // diagonal down-right
                    if(r+3<6 && c+3<7 && color.equals(buttons[r+1][c+1].getBackground())
                                    && color.equals(buttons[r+2][c+2].getBackground())
                                    && color.equals(buttons[r+3][c+3].getBackground()))
                        return true;

                    // diagonal up-right
                    if(r-3>=0 && c+3<7 && color.equals(buttons[r-1][c+1].getBackground())
                                    && color.equals(buttons[r-2][c+2].getBackground())
                                    && color.equals(buttons[r-3][c+3].getBackground()))
                        return true;
                }
            }
        }
        return false;
    }
}
