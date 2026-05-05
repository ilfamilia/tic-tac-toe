package view;

import javax.swing.JFrame;
import  javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;



public class GameView extends JFrame {

    private JPanel headerPanel;
    private JPanel mainPanel;
    private JPanel scorePanel;
    private JPanel winnerPanel;
    private JLabel scoreLabel;
    private JLabel winnerLabel;
    private JButton[] buttons;
    private final int BUTTONS_NUM = 9;

    public GameView() {
        initComponent();
    }

    public void initComponent() {
        this.setTitle("Tic-tac-toe");
        this.setSize(400, 550);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        headerPanel = new JPanel(new BorderLayout());

        mainPanel = new JPanel(new GridLayout(3, 3));

        winnerPanel = new JPanel();
        scorePanel = new JPanel();

        scoreLabel = new JLabel("<html>Score:<br>X: 0<br>O: 0</html>");

        winnerLabel = new JLabel("X wins!");

        buttons = new JButton[BUTTONS_NUM];

        for(int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
        }

        this.add(headerPanel, BorderLayout.NORTH);
        this.add(this.mainPanel, BorderLayout.CENTER);

        headerPanel.add(winnerPanel, BorderLayout.CENTER);
        headerPanel.add(scorePanel, BorderLayout.EAST);

        winnerPanel.add(winnerLabel);
        scorePanel.add(scoreLabel);

        for(JButton button : buttons) {
            mainPanel.add(button);
        }
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public JLabel getWinnerLabel() {
        return winnerLabel;
    }

    public JButton[] getButtons() {
        return buttons;
    }
}
