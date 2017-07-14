package slack.commands;

import slack.slack.*;

import java.util.Collections;

public class StatusCommand implements SlackCommand {

    @Override
    public SlackResponse apply(SlackMessage message) {
        String channel = message.getChannelId();

        SlackTicTacToe game = SlackChannels.SLACK_CHANNELS.getGame(channel);
        if(game == null){
            return new SlackResponse(SlackResponse.ResponseType.channel, "No game started", Collections.emptyList());
        }

        return new SlackResponse(SlackResponse.ResponseType.channel, "Current Game:",
                GameStatusAttachment.getAttachments(game.getGameStatus()));
    }
}
