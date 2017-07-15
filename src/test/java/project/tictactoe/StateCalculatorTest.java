package project.tictactoe;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StateCalculatorTest {

    @Test
    public void testWins(){
        List<Board> winningBoardsForX = getWinningBoards(Player.X);

        assertEquals("3 rows, 3 cols, 2 diagonals", 8, winningBoardsForX.size());

        for(Board b : winningBoardsForX){
            assertEquals(b.toString(), TicTacToeState.X_WON, new StateCalculator(b).getState());
        }

        List<Board> winningBoardsForO = getWinningBoards(Player.O);
        assertEquals("3 rows, 3 cols, 2 diagonals", 8, winningBoardsForO.size());
        for(Board b : winningBoardsForO){
            assertEquals(b.toString(), TicTacToeState.O_WON, new StateCalculator(b).getState());
        }

    }

    public List<Board> getWinningBoards(Player player){
        List<Board> boards = new ArrayList<>();
        for(int r = 0; r < Board.SIZE; r++){
            Board board = new Board();
            for(int c = 0; c < Board.SIZE; c++) {
                board = board.put(player, new Square(r, c));
            }
            boards.add(board);
        }

        for(int c = 0; c < Board.SIZE; c++){
            Board board = new Board();
            for(int r = 0; r < Board.SIZE; r++) {
                board = board.put(player, new Square(r, c));
            }
            boards.add(board);
        }

        Board forward = new Board();
        Board backward = new Board();
        for(int x = 0; x < Board.SIZE; x++){
            forward = forward.put(player, new Square(x, x));
        }

        backward = backward.put(player, new Square(0, 2));
        backward = backward.put(player, new Square(1, 1));
        backward = backward.put(player, new Square(2,  0));

        boards.add(forward);
        boards.add(backward);
        return boards;
    }


}