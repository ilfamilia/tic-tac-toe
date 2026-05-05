package logic;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

import entities.Player;
import entities.Turn;
import view.GameView;

public class GameLogic implements ActionListener{

    private GameView gameView;
    private Player player1;
    private Player player2;
    private Turn turn;

    public GameLogic(GameView gameView, Player player1, Player player2) {
        this.gameView = gameView;
        this.player1 = player1;
        this.player2 = player2;

        turn = new Turn(player1, player2);

        for(JButton button : gameView.getButtons()) {
            button.addActionListener(this);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button : gameView.getButtons()) {
            if (e.getSource() == button) {
                button.setText(turn.getCurrentPlayer().getSignature());
                button.setEnabled(false);
                return;
            }
        }
    }
}
