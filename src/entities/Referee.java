package entities;

import view.GameView;
import javax.swing.JButton;

public class Referee {
    private GameView gameView;

    public Referee(GameView gameView) {
        this.gameView = gameView;
    }

    public boolean isGameEnded() {
        if (areAllButtonsDisabled() || !getWinner().isEmpty()) {
            return true;
        }

        return false;
    }

    public String getWinner() {

        String[] signatures = getSignatures();

        // Check board rows
        for (int i = 0; i <= 6; i += 3) {
            if (!signatures[i].isEmpty() && signatures[i].equals(signatures[i + 1]) && signatures[i].equals(signatures[i + 2])) {
                return signatures[i];
            }
        }

        // Check board columns
        for (int i = 0; i <= 2; i++) {
            if (!signatures[i].isEmpty() && signatures[i].equals(signatures[i + 3]) && signatures[i].equals(signatures[i + 6])) {
                return signatures[i];
            }
        }

        // Check main diagonal
        if (!signatures[0].isEmpty() && signatures[0].equals(signatures[4]) && signatures[0].equals(signatures[8])) {
            return signatures[0];
        }

        // Check secondary diagonal
        if (!signatures[2].isEmpty() && signatures[2].equals(signatures[4]) && signatures[2].equals(signatures[6])) {
            return signatures[2];
        }

        return "";
    }

    private boolean areAllButtonsDisabled() {
        for (JButton button : gameView.getButtons()) {
            if (button.isEnabled()) {
                return false;
            }
        }

        return true;
    }

    private String[] getSignatures() {
        String[] signatures = new String[9];

        int i = 0;
        for (JButton button : gameView.getButtons()) {
            signatures[i] = button.getText().trim();
            i++;
        }

        return signatures;
    }
}
