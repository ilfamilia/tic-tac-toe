package main;

import javax.swing.SwingUtilities;
import view.GameView;
import entities.Player;
import logic.GameLogic;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameView gameView = new GameView();
            Player player1 = new Player("X");
            Player player2 = new Player("O");
            new GameLogic(gameView, player1, player2);
            gameView.setVisible(true);
        });
    }
}
