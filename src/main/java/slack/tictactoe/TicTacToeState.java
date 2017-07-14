package slack.tictactoe;

public enum TicTacToeState {

    PLAYING,
    DRAW,
    X_WON,
    O_WON;

    public boolean isTerminal() {
        return this != PLAYING;
    }

}
