package slack.tictactoe;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * An immutable class that represents a board in Tic Tac Toe
 */
public class Board {
    public static final int SIZE = 3;

    private final Player[][] board;
    private final int count;

    public Board() {
        this(0, new Player[SIZE][SIZE]);
    }

    private Board(int count, Player[][] board) {
        this.count = count;
        this.board = board;
    }

    public Board put(Player p, Square square) {
        checkArgument(isAvailable(square), square + " is not free!");

        Player[][] clone = board.clone();
        clone[square.getX()][square.getY()] = p;
        return new Board(count + 1, clone);
    }


    public boolean isAvailable(Square square) {
        return board[square.getX()][square.getY()] == null;
    }

    public Player[][] getRawBoard() {
        return board.clone();
    }

    public int getNumberOfOccupiedSquares() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int r = 0; r < SIZE; r++) {

            if (r != 0) {
                builder.append(System.lineSeparator());
                //there are 3 characters per square and SIZE-1 pipes
                int lineLength = SIZE*3 + (SIZE - 1);
                for (int i = 0; i < lineLength; i++) {
                    builder.append("-");
                }
                builder.append(System.lineSeparator());
            }

            for (int c = 0; c < SIZE; c++) {
                if (c != 0) {
                    builder.append("|");
                }

                builder.append(" ");
                if (board[r][c] == null) {
                    builder.append(" ");
                } else {
                    builder.append(board[r][c]);
                }
                builder.append(" ");
            }
        }


        return builder.toString();
    }

}
