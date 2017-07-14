package slack.commands;

import slack.slack.*;
import slack.tictactoe.GameStatus;
import slack.tictactoe.Square;

public class MoveCommand implements SlackCommand {

    @Override
    public SlackResponse apply(SlackMessage message) {
        SlackUser slackUser = message.getSlackUser();
        String channel = message.getChannelId();

        SlackTicTacToe game = SlackChannels.SLACK_CHANNELS.getGame(channel);
        if(game == null){
            throw new IllegalStateException("No game started");
        }

        GameStatus gameStatus = game.play(slackUser, getSquare(message.getText()));

        if(gameStatus.getState().isTerminal()){
            SlackChannels.SLACK_CHANNELS.clear(channel);
        }

        String mainText = slackUser.getUserName() + " moved!";

        return new SlackResponse(SlackResponse.ResponseType.channel, mainText,
                GameStatusAttachment.getAttachments(gameStatus));
    }

    private Square getSquare(String text){
        String[] split = text.split(" ");

        if(split.length == 3){
            throw new IllegalArgumentException("Specify a coordinates");
        }

        return new Square(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }
}
