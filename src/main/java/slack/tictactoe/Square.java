package slack.tictactoe;


import static com.google.common.base.Preconditions.checkArgument;

/**
 * A tic tac toe coordinate
 */
public class Square {
    private final int x;
    private final int y;

    public Square(int x, int y) {
        checkArgument(x >= 0 && x < Board.SIZE, "X must be greater than or equal to 0 or less than 3");
        checkArgument(y >= 0 && y < Board.SIZE, "Y must be greater than or equal to 0 or less than 3");
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
