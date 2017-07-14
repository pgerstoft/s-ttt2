package slack.slack;

import slack.tictactoe.*;

public class SlackTicTacToe {

    private final TicTacToeGame game = new TicTacToeGame();
    private final SlackUser xUser;
    private final SlackUser oUser;

    public SlackTicTacToe(SlackUser xUser, SlackUser oUser) {
        this.xUser = xUser;
        this.oUser = oUser;
    }

    public GameStatus getGameStatus() {
        return new GameStatus(game.getBoard(), new StateCalculator(game.getBoard()).getState(), game.getCurrentPlayer(),
                xUser.getUserName(), oUser.getUserName());
    }

    public GameStatus play(SlackUser user, Square square) {
        if (!checkPlayer(user)) {
            throw new SlackException("Hey! It's not your turn!");
        }

        if (!game.isAvailable(square)) {
            throw new SlackException("Tsk Tsk. That square is not available.");
        }

        game.mark(square);
        return getGameStatus();
    }

    private boolean checkPlayer(SlackUser user) {
        Player playersTurn = game.getCurrentPlayer();
        if (playersTurn == Player.X) {
            return user.equals(xUser);
        }

        return user.equals(oUser);
    }

}
