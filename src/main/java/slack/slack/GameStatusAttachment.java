package slack.slack;

import slack.tictactoe.GameStatus;

import java.util.ArrayList;
import java.util.List;

public class GameStatusAttachment {

    public static List<SlackResponse.Attachment> getAttachments(GameStatus gameStatus){
        List<SlackResponse.Attachment> attachments = new ArrayList<>();
        attachments.add(new SlackResponse.Attachment("```"+ gameStatus.getBoard() + "````"));
        attachments.add(new SlackResponse.Attachment(gameStatus.getStatus()));
        return attachments;
    }

}
