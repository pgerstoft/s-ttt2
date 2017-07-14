package slack.slack;

import slack.tictactoe.GameStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a Slack Response Attachment from a Game Status
 */
public class GameStatusAttachment {

    public static List<SlackResponse.Attachment> getAttachments(GameStatus gameStatus) {
        List<SlackResponse.Attachment> attachments = new ArrayList<>();
        attachments.add(new SlackResponse.Attachment("```" + gameStatus.getBoard().toString() + "```"));
        attachments.add(new SlackResponse.Attachment(gameStatus.getStatus()));
        return attachments;
    }

}
