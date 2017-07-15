package project.slack.commands;

import project.slack.SlackMessage;
import project.slack.SlackResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Lists all the available commands
 */
public class HelpCommand implements SlackCommand {

    public SlackResponse apply(SlackMessage message){

        String msg = "Hey " + message.get(SlackMessage.USER_NAME) + " here are your available commands.";

        List<SlackResponse.Attachment> attachments = new ArrayList<>();

        for(Commands command : Commands.values()){
            attachments.add(new SlackResponse.Attachment(command.name() + " " + command.getDescription()));
        }

        return new SlackResponse(SlackResponse.ResponseType.ephemeral, msg,attachments);
    }

}
