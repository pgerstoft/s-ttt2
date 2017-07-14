package slack.slack;

import java.util.HashMap;
import java.util.Map;

public class SlackChannels {
    public static final SlackChannels SLACK_CHANNELS = new SlackChannels();

    private Map<String, SlackTicTacToe> activeGames = new HashMap<>();

    public void create(String channel, SlackTicTacToe slackTicTacToe){
        SlackTicTacToe previous = activeGames.putIfAbsent(channel, slackTicTacToe);

        if(previous != null){
            throw new IllegalArgumentException("Game already in play!");
        }
    }

    public SlackTicTacToe getGame(String channel){
        return activeGames.get(channel);
    }

    public void clear(String channel){
        activeGames.remove(channel);
    }

}
