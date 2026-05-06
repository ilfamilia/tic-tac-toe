package view;

import javax.swing.JFrame;
import  javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;



public class GameView extends JFrame {

    private JPanel headerPanel;
    private JPanel mainPanel;
    private JPanel scorePanel;
    private JPanel infoPanel;
    private JLabel scoreLabel;
    private JLabel infoLabel;
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

        infoPanel = new JPanel();

        scorePanel = new JPanel();
        // scorePanel.setPreferredSize(new Dimension(100, 100));
        // scorePanel.setBackground(Color.BLUE);

        scoreLabel = new JLabel();

        infoLabel = new JLabel();

        buttons = new JButton[BUTTONS_NUM];

        for(int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
        }

        this.add(headerPanel, BorderLayout.NORTH);
        this.add(this.mainPanel, BorderLayout.CENTER);

        headerPanel.add(infoPanel, BorderLayout.CENTER);
        headerPanel.add(scorePanel, BorderLayout.EAST);

        infoPanel.add(infoLabel);
        scorePanel.add(scoreLabel);

        for(JButton button : buttons) {
            mainPanel.add(button);
        }
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public JLabel getInfoLabel() {
        return infoLabel;
    }

    public JButton[] getButtons() {
        return buttons;
    }
}
