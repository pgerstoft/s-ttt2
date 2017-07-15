package project.slack;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A Singleton that keeps track of the games currently being played
 */
public class SlackChannelGames {

    public static final SlackChannelGames SLACK_CHANNELS = new SlackChannelGames();

    private Map<String, SlackTicTacToe> activeGames = new ConcurrentHashMap<>();

    public void create(String channel, SlackTicTacToe slackTicTacToe) {
        SlackTicTacToe previous = activeGames.putIfAbsent(channel, slackTicTacToe);

        if (previous != null) {
            throw new SlackException("Game already in play!");
        }
    }

    public SlackTicTacToe getGame(String channel) {
        return activeGames.get(channel);
    }

    public void clear(String channel) {
        activeGames.remove(channel);
    }

}
