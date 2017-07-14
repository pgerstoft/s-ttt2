package slack.tictactoe;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Computes the current state of the tic tac toe game
 */
public class StateCalculator {

    private final Board board;

    public StateCalculator(Board board){
        this.board = board;
    }

    public TicTacToeState getState(){
        if(board.getNumberOfOccupiedSquares() < Board.SIZE){
            return TicTacToeState.PLAYING;
        }
        Optional<Player> player = checkIfWon();
        if(player.isPresent()){
            if(player.get() == Player.X){
                return TicTacToeState.X_WON;
            }else{
                return TicTacToeState.O_WON;
            }
        }

        if(board.getNumberOfOccupiedSquares() == Board.SIZE*Board.SIZE){
            return TicTacToeState.DRAW;
        }

        return TicTacToeState.PLAYING;
    }

    public Optional<Player> checkIfWon(){
        Player[][] raw = board.getRawBoard();
        //check rows
        Optional<Player> rowWinner = checkRowsForWinner(raw);
        if(rowWinner.isPresent()){
            return rowWinner;
        }

        Optional<Player> colsWinner = checkColumnsForWinner(raw);
        if(colsWinner.isPresent()){
            return colsWinner;
        }

        //check diagonals
        return checkDiagonals(raw);
    }

    private Optional<Player> checkDiagonals(Player[][] raw) {
        List<Player> forwardDiagonal = new ArrayList<>();
        List<Player> backwardDiagonal = new ArrayList<>();

        for (int x = 0; x < Board.SIZE; x++){
            forwardDiagonal.add(raw[x][x]);
            backwardDiagonal.add(raw[x][ Board.SIZE - 1 - x]);
        }

        Optional<Player> optionalWinner = getWinner(forwardDiagonal);
        if(optionalWinner.isPresent()){
            return optionalWinner;
        }

        return getWinner(backwardDiagonal);
    }

    private Optional<Player> checkRowsForWinner(Player[][] raw){

        for(int r = 0; r < Board.SIZE; r ++){
            Optional<Player> optionalWinner = getWinner(Arrays.asList(raw[r]));
            if(optionalWinner.isPresent()){
                return optionalWinner;
            }
        }

        return Optional.empty();
    }

    private Optional<Player> checkColumnsForWinner(Player[][] raw){
        for(int c = 0; c < Board.SIZE; c ++){
            List<Player> squareValues = new ArrayList<>();
            for(int r = 0; r < Board.SIZE; r++){
               squareValues.add(raw[r][c]);
            }

            Optional<Player> optionalWinner = getWinner(squareValues);
            if(optionalWinner.isPresent()){
                return optionalWinner;
            }
        }

        return Optional.empty();
    }

    private Optional<Player> getWinner(List<Player> squares){
        Optional<Player> firstSquare = Optional.ofNullable(squares.get(0));
        if(!firstSquare.isPresent()){
            return Optional.empty();
        }
        if(squares.stream().allMatch(s -> s == firstSquare.get())){
            return firstSquare;
        }else{
            return Optional.empty();
        }
    }


}
