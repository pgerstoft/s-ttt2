package slack.slack;

import slack.tictactoe.*;

import static com.google.appengine.repackaged.com.google.common.base.Preconditions.checkArgument;

public class SlackTicTacToe {

    private final TicTacToeGame game = new TicTacToeGame();
    private final SlackUser xUser;
    private final SlackUser oUser;

    public SlackTicTacToe(SlackUser xUser, SlackUser oUser) {
        this.xUser = xUser;
        this.oUser = oUser;
    }

    public GameStatus getGameStatus(){
        return new GameStatus(game.getBoard(), new StateCalculator(game.getBoard()).getState(), game.getCurrentPlayer(),
                xUser.getUserName(), oUser.getUserName());
    }

    public GameStatus play(SlackUser user, Square square){
        checkArgument(checkPlayer(user), "Hey! It's not your turn!");
        game.mark(square);
        return getGameStatus();
    }

    private boolean checkPlayer(SlackUser user){
        Player playersTurn = game.getCurrentPlayer();
        if(playersTurn == Player.X){
            return user.equals(xUser);
        }

        return user.equals(oUser);
    }

}
