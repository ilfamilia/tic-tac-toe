package entities;

public class Turn {
    private Player player1;
    private Player player2;

    public Turn(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getCurrentPlayer() {
        if (player1.isTurn()) {
            player1.setTurn(false);
            player2.setTurn(true);
            return player1;
        } else if(player2.isTurn()) {
            player2.setTurn(false);
            player1.setTurn(true);
            return player2;
        } else {
            player2.setTurn(true);
            return player1;
        }
    }
}
