package slack.tictactoe;

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

    public Board put(Player p, Square square) throws OccupiedSquareException {
        if (board[square.getY()][square.getY()] != null) {
            throw new OccupiedSquareException();
        }

        Player[][] clone = board.clone();
        clone[square.getX()][square.getY()] = p;
        return new Board(count + 1, clone);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int r = 0; r < SIZE; r++) {

            if (r != 0) {
                builder.append(System.lineSeparator());
                for (int i = 0; i < (3 + 1 + 3 + 1 + 3); i++) {
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