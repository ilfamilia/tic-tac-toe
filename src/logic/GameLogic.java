package logic;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import entities.Player;
import entities.Turn;
import entities.Referee;
import view.GameView;

public class GameLogic implements ActionListener{

    private GameView gameView;
    private Player player1;
    private Player player2;
    private Turn turn;
    private Referee ref;

    public GameLogic(GameView gameView, Player player1, Player player2) {
        this.gameView = gameView;
        this.player1 = player1;
        this.player2 = player2;

        ref = new Referee(gameView);

        turn = new Turn(player1, player2);

        for(JButton button : gameView.getButtons()) {
            button.addActionListener(this);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button : gameView.getButtons()) {
            if (e.getSource() == button) {
                String currentPlayerSignature = turn.getCurrentPlayer().getSignature();
                button.setText(currentPlayerSignature);
                button.setEnabled(false);

                if (!ref.isGameEnded()) {
                    String nextPlayer = (currentPlayerSignature.equals(player1.getSignature()))
                            ? player2.getSignature() : player1.getSignature();
                    gameView.getInfoLabel().setText("Is " + nextPlayer + " turn");
                } else {
                    String winner = ref.getWinner();
                    if (!winner.equals("\0")) {
                        JOptionPane.showMessageDialog(gameView, "Player " + winner + " won!");
                        resetGame();
                    } else {
                        JOptionPane.showMessageDialog(gameView, "It's a tie!");
                        resetGame();
                    }
                }
            }
        }
    }


    private void resetGame() {
        gameView.getInfoLabel().setText("");

        for (JButton button : gameView.getButtons()) {
            button.setEnabled(true);
            button.setText("");
        }
    }
}
