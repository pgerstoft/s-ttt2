package project.tictactoe;

/**
 * Represents the status of the game
 */
public class GameStatus {

    private final Board board;
    private final TicTacToeState state;
    private final Player currentPlayer;
    private final String xPlayer;
    private final String oPlayer;

    public GameStatus(Board board, TicTacToeState state, Player currentPlayer, String xPlayer, String oPlayer){
        this.board = board;
        this.state = state;
        this.currentPlayer = currentPlayer;
        this.xPlayer = xPlayer;
        this.oPlayer = oPlayer;
    }

    public TicTacToeState getState() {
        return state;
    }

    public String getStatus(){
        switch (state){
            case DRAW:
                return "Game drawn";
            case X_WON:
                return xPlayer + " won!";
            case O_WON:
                return oPlayer + " won!";
            case PLAYING:
                return (currentPlayer == Player.X? xPlayer : oPlayer) + "'s turn";
            default:
                throw new IllegalStateException("Invalid state");
        }
    }

    public Board getBoard(){
        return board;
    }

}
