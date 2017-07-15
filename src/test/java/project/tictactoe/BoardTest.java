package project.tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testBoardToString() {
        Board board = new Board();
        String actual = "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   ";

        assertEquals(board.toString(), actual);
    }

    @Test
    public void testBoardWithPiece() {
        Board board = new Board().put(Player.O, new Square(0, 0));
        String actual = " O |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   ";

        assertEquals(board.toString(), actual);
    }

}