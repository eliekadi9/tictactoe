import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton playAgainButton = new JButton("Play Again");
    boolean player1_turn;

    TicTacToe() {
        this.frame.setDefaultCloseOperation(3);
        this.frame.setSize(600, 500);
        this.frame.getContentPane().setBackground(new Color(50, 50, 50));
        this.frame.setLayout(new BorderLayout());
        this.frame.setVisible(true);
        this.textfield.setBackground(new Color(25, 25, 25));
        this.textfield.setForeground(new Color(24, 195, 201));
        this.textfield.setFont(new Font("Ink Free", 1, 75));
        this.textfield.setHorizontalAlignment(0);
        this.textfield.setText("TIC-TAC-TOE");
        this.textfield.setOpaque(true);
        this.title_panel.setLayout(new BorderLayout());
        this.title_panel.setBounds(0, 0, 800, 100);
        this.button_panel.setLayout(new GridLayout(3, 3));
        this.button_panel.setBackground(new Color(150, 150, 150));

        // Set up play again button
        JPanel playAgainPanel = new JPanel();
        playAgainPanel.setLayout(new FlowLayout());
        playAgainButton.setFont(new Font("Arial", Font.BOLD, 20));
        playAgainButton.setFocusable(false);
        playAgainButton.setEnabled(false); // only enable after game ends
        playAgainButton.addActionListener(e -> resetGame());
        playAgainPanel.add(playAgainButton);

// Add panel to the frame
        this.frame.add(playAgainPanel, BorderLayout.SOUTH);


        for(int i = 0; i < 9; ++i) {
            this.buttons[i] = new JButton();
            this.button_panel.add(this.buttons[i]);
            this.buttons[i].setFont(new Font("MV Boli", 1, 120));
            this.buttons[i].setFocusable(false);
            this.buttons[i].addActionListener(this);
        }

        this.title_panel.add(this.textfield);
        this.frame.add(this.title_panel, "North");
        this.frame.add(this.button_panel);
        this.firstTurn();
    }

    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 9; ++i) {
            if (e.getSource() == this.buttons[i]) {
                if (this.player1_turn) {
                    if (this.buttons[i].getText() == "") {
                        this.buttons[i].setForeground(new Color(255, 0, 0));
                        this.buttons[i].setText("X");
                        this.player1_turn = false;
                        this.textfield.setText("O turn");
                        this.check();
                    }
                } else if (this.buttons[i].getText() == "") {
                    this.buttons[i].setForeground(new Color(0, 0, 255));
                    this.buttons[i].setText("O");
                    this.player1_turn = true;
                    this.textfield.setText("X turn");
                    this.check();
                }
            }
        }

        this.check();
        this.tie();
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

        if (this.random.nextInt(2) == 0) {
            this.player1_turn = true;
            this.textfield.setText(" X turn");
        } else {
            this.player1_turn = false;
            this.textfield.setText("O turn");
        }

    }

    public void check() {
        if (this.buttons[0].getText().equals("X") && this.buttons[1].getText().equals("X") && this.buttons[2].getText().equals("X")) {
            this.xWins(0, 1, 2);
        }

        if (this.buttons[3].getText().equals("X") && this.buttons[4].getText().equals("X") && this.buttons[5].getText().equals("X")) {
            this.xWins(3, 4, 5);
        }

        if (this.buttons[6].getText().equals("X") && this.buttons[7].getText().equals("X") && this.buttons[8].getText().equals("X")) {
            this.xWins(6, 7, 8);
        }

        if (this.buttons[0].getText().equals("X") && this.buttons[3].getText().equals("X") && this.buttons[6].getText().equals("X")) {
            this.xWins(0, 3, 6);
        }

        if (this.buttons[1].getText().equals("X") && this.buttons[4].getText().equals("X") && this.buttons[7].getText().equals("X")) {
            this.xWins(1, 4, 7);
        }

        if (this.buttons[2].getText().equals("X") && this.buttons[5].getText().equals("X") && this.buttons[8].getText().equals("X")) {
            this.xWins(2, 5, 8);
        }

        if (this.buttons[0].getText().equals("X") && this.buttons[4].getText().equals("X") && this.buttons[8].getText().equals("X")) {
            this.xWins(0, 4, 8);
        }

        if (this.buttons[2].getText().equals("X") && this.buttons[4].getText().equals("X") && this.buttons[6].getText().equals("X")) {
            this.xWins(2, 4, 6);
        }

        if (this.buttons[0].getText().equals("O") && this.buttons[1].getText().equals("O") && this.buttons[2].getText().equals("O")) {
            this.oWins(0, 1, 2);
        }

        if (this.buttons[3].getText().equals("O") && this.buttons[4].getText().equals("O") && this.buttons[5].getText().equals("O")) {
            this.oWins(3, 4, 5);
        }

        if (this.buttons[6].getText().equals("O") && this.buttons[7].getText().equals("O") && this.buttons[8].getText().equals("O")) {
            this.oWins(6, 7, 8);
        }

        if (this.buttons[0].getText().equals("O") && this.buttons[3].getText().equals("O") && this.buttons[6].getText().equals("O")) {
            this.oWins(0, 3, 6);
        }

        if (this.buttons[1].getText().equals("O") && this.buttons[4].getText().equals("O") && this.buttons[7].getText().equals("O")) {
            this.oWins(1, 4, 7);
        }

        if (this.buttons[2].getText().equals("O") && this.buttons[5].getText().equals("O") && this.buttons[8].getText().equals("O")) {
            this.oWins(2, 5, 8);
        }

        if (this.buttons[0].getText().equals("O") && this.buttons[4].getText().equals("O") && this.buttons[8].getText().equals("O")) {
            this.oWins(0, 4, 8);
        }

        if (this.buttons[2].getText().equals("O") && this.buttons[4].getText().equals("O") && this.buttons[6].getText().equals("O")) {
            this.oWins(2, 4, 6);
        }

    }

    public void xWins(int a, int b, int c) {
        this.buttons[a].setBackground(Color.GREEN);
        this.buttons[b].setBackground(Color.GREEN);
        this.buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9; ++i) {
            this.buttons[i].setEnabled(false);
        }

        this.textfield.setText("X wins!");
        this.playAgainButton.setEnabled(true);
    }

    public void oWins(int a, int b, int c) {
        this.buttons[a].setBackground(Color.GREEN);
        this.buttons[b].setBackground(Color.GREEN);
        this.buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9; ++i) {
            this.buttons[i].setEnabled(false);
        }

        this.textfield.setText("O wins!");
        this.playAgainButton.setEnabled(true);
    }

    public void tie() {
        boolean fullBoard = true;
        boolean someoneWon = false;

        for(int i = 0; i < 9; ++i) {
            if (this.buttons[i].getText().equals("")) {
                fullBoard = false;
                break;
            }
        }

        int[][] winConditions = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        int[][] var4 = winConditions;
        int var5 = winConditions.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            int[] condition = var4[var6];
            if (!this.buttons[condition[0]].getText().equals("") && this.buttons[condition[0]].getText().equals(this.buttons[condition[1]].getText()) && this.buttons[condition[1]].getText().equals(this.buttons[condition[2]].getText())) {
                someoneWon = true;
                break;
            }
        }

        if (fullBoard && !someoneWon) {
            this.textfield.setText("Tie!");

            for(int i = 0; i < 9; ++i) {
                this.buttons[i].setEnabled(false);
            }
        }
        this.playAgainButton.setEnabled(true);
    }

    public void resetGame() {
        for (JButton button : this.buttons) {
            button.setText("");
            button.setEnabled(true);
            button.setBackground(null);
        }
        this.playAgainButton.setEnabled(false);
        this.firstTurn();
    }



}
