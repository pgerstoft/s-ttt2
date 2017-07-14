package slack.commands;

import slack.slack.*;

public class StartCommand implements SlackCommand {

    @Override
    public SlackResponse apply(SlackMessage message) {
        SlackUser user = message.getSlackUser();
        String channel = message.getChannelId();
        SlackUser challenged = getChallengedUser(message.getText());

        SlackTicTacToe slackTicTacToe = new SlackTicTacToe(user, challenged);
        SlackChannels.SLACK_CHANNELS.create(channel, slackTicTacToe);

        String mainText = "Game started between " + user.getUserName() + " and " + challenged.getUserName() + ";";

        return new SlackResponse(SlackResponse.ResponseType.channel, mainText,
                GameStatusAttachment.getAttachments(slackTicTacToe.getGameStatus()));
    }

    private SlackUser getChallengedUser(String text){
        String[] split = text.split(" ");
        if(split.length == 1){
            throw new IllegalArgumentException("Specify a user");
        }
        if(split.length > 2){
            throw new IllegalArgumentException("Only one user allowed");
        }

        return EscapedEntity.getSlackUser(text);
    }

}
