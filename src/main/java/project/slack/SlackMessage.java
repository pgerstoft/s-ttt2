package project.slack;

import java.util.HashMap;
import java.util.Map;

/**
 * A wrapper around the POST data project sends in the slash command
 */
public class SlackMessage {

    public static final String USER_NAME = "user_name";
    public static final String USER_ID = "user_id";
    public static final String CHANNEL_ID = "channel_id";
    public static final String TEXT = "text";

    private final Map<String, String> messageMap;

    public SlackMessage(Map<String, String[]> params) {
        messageMap = new HashMap<>();
        for (Map.Entry<String, String[]> entry : params.entrySet()) {
            messageMap.put(entry.getKey(), entry.getValue()[0]);
        }
    }

    public SlackUser getSlackUser() {
        return new SlackUser(get(USER_ID), "@" + get(USER_NAME));
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
