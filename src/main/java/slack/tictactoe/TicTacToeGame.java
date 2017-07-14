package slack.tictactoe;


public class TicTacToeGame {

    private Player currentTurn = Player.X;
    private Board board = new Board();

    public Player getCurrentPlayer(){
        return currentTurn;
    }

    public Board getBoard(){
        return board;
    }

    public boolean isAvailable(Square square){
        return board.isAvailable(square);
    }

    public void mark(Square square){
        board = board.put(currentTurn, square);
        if(currentTurn == Player.X){
            currentTurn = Player.O;
        }else{
            currentTurn = Player.X;
        }
    }

}
