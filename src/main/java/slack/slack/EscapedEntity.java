package slack.slack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EscapedEntity {

    //<@U012ABCDEF|ernie>
    private static final Pattern ESCAPED_USER = Pattern.compile("<@(.*)\\|(.*)>");

    public static SlackUser getSlackUser(String escapedEntity){
        return new SlackUser(getUserId(escapedEntity), getUserName(escapedEntity));
    }

    static String getUserId(String escapedUser){
        Matcher matcher = ESCAPED_USER.matcher(escapedUser);
        matcher.find();
        return String.valueOf(matcher.group(1));
    }

    static String getUserName(String escapedUser){
        Matcher matcher = ESCAPED_USER.matcher(escapedUser);
        matcher.find();
        return "@" + matcher.group(2);
    }

}
