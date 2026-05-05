package entities;

public class Player {
    private String signature;
    private int score;
    private boolean turn;

    public Player() {
        this("");
    }

    public Player(String signature) {
        this(signature, false);
    }

    public Player(String signature, boolean turn) {
        this.signature = signature;
        this.turn = turn;
        score = 0;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }
}
