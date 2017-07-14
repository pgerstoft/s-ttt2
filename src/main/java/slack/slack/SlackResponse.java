package slack.slack;


import java.util.Collections;
import java.util.List;

public class SlackResponse {

    private ResponseType response_type;
    private String text;
    private List<Attachment> attachments;


    public SlackResponse(ResponseType responseType, String text, List<Attachment> attachments) {
        this.response_type = responseType;
        this.text = text;
        this.attachments = attachments;
    }

    public enum ResponseType {
        channel,
        ephemeral;
    }

    public static class Attachment {
        private String text;

        private List<String> mrkdwn_in = Collections.singletonList("text");

        public Attachment(String text) {
            this.text = text;
        }
    }

}
