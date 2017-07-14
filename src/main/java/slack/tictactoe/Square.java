package slack.tictactoe;

import static com.google.appengine.repackaged.com.google.common.base.Preconditions.checkArgument;

public class Square {
    private final int x;
    private final int y;

    public Square(int x, int y) {
        checkArgument(x >= 0, "X coordinate must be greater than 0");
        checkArgument(y >= 0, "Y coordinate must be greater than 0");
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
