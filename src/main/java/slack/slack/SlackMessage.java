package slack.slack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlackMessage {

    /*
     * Example message
     * token=gIkuvaNzQIHg97ATvDxqgjtO
     team_id=T0001
     team_domain=example
     enterprise_id=E0001
     enterprise_name=Globular%20Construct%20Inc
     channel_id=C2147483705
     channel_name=test
     user_id=U2147483697
     user_name=Steve
     command=/weather
     text=94070
     response_url=https://hooks.slack.com/commands/1234/5678
     */

    public static final String USER_NAME = "user_name";
    public static final String USER_ID = "user_ID";
    public static final String CHANNEL_ID = "channel_id";
    public static final String TEXT = "text";

    private final Map<String, String> messageMap;

    public SlackMessage(String message) {
        this(Arrays.asList(message.split(System.lineSeparator())));
    }

    public SlackMessage(List<String> lines) {
        messageMap = new HashMap<>();
        for (String line : lines) {
            String[] keyValue = line.split("=");
            messageMap.put(keyValue[0], keyValue[1]);
        }
    }

    public SlackUser getSlackUser() {
        return new SlackUser(get(USER_ID), get(USER_NAME));
    }

    public String getChannelId() {
        return get(CHANNEL_ID);
    }

    public String getText() {
        return get(TEXT);
    }

    public String get(String key) {
        return messageMap.get(key);
    }


}
