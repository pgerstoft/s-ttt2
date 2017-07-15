package project.slack.commands;

import project.slack.SlackException;
import project.slack.*;
import project.tictactoe.GameStatus;
import project.tictactoe.Square;

/**
 * Makes a move in a tic tac toe game
 */
public class MoveCommand implements SlackCommand {

    @Override
    public SlackResponse apply(SlackMessage message) {
        SlackUser slackUser = message.getSlackUser();
        String channel = message.getChannelId();

        SlackTicTacToe game = SlackChannelGames.SLACK_CHANNELS.getGame(channel);
        if(game == null){
            throw new SlackException("No game started");
        }

        GameStatus gameStatus = game.play(slackUser, getSquare(message.getText()));

        if(gameStatus.getState().isTerminal()){
            SlackChannelGames.SLACK_CHANNELS.clear(channel);
        }

        String mainText = slackUser.getUserName() + " moved!";

        return new SlackResponse(SlackResponse.ResponseType.channel, mainText,
                GameStatusAttachment.getAttachments(gameStatus));
    }

    private Square getSquare(String text){
        String[] split = text.split(" ");

        if(split.length != 3){
            throw new SlackException("Please specify coordinates");
        }

        try {
            return new Square(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        }catch (IllegalArgumentException e){
            throw new SlackException(e.getMessage());
        }
    }
}
