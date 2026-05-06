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

        updateBoardScore();
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
                    if (!winner.isEmpty()) {
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

        updateScore();

        gameView.getInfoLabel().setText("");

        for (JButton button : gameView.getButtons()) {
            button.setEnabled(true);
            button.setText("");
        }

        updateBoardScore();
    }

    private void updateBoardScore() {
        gameView.getScoreLabel().setText("<html>Score:" +
                "<br>X: " + player1.getScore() +
                "<br>O: " + player2.getScore() +
                "</html>");
    }

    private void updateScore() {
        if (!ref.getWinner().isEmpty()) {
            if (ref.getWinner().equals(player1.getSignature())) {
                player1.setScore(player1.getScore() + 1);
            } else {
                player2.setScore(player2.getScore() + 1);
            }
        }
    }
}
