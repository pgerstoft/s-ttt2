package project.slack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EscapedEntity {

    //<@U012ABCDEF|ernie>
    private static final Pattern ESCAPED_USER = Pattern.compile("<@(.*)\\|(.*)>");

    /**
     * Parse the user from an escaped entity
     */
    public static SlackUser getSlackUser(String escapedEntity) {
        try {
            return new SlackUser(getUserId(escapedEntity), getUserName(escapedEntity));
        } catch (RuntimeException e) {
            throw new SlackException("Please provide a valid username!");
        }
    }

    static String getUserId(String escapedUser) {
        Matcher matcher = ESCAPED_USER.matcher(escapedUser);
        matcher.find();
        return String.valueOf(matcher.group(1));
    }

    static String getUserName(String escapedUser) {
        Matcher matcher = ESCAPED_USER.matcher(escapedUser);
        matcher.find();
        return "@" + matcher.group(2);
    }

}
