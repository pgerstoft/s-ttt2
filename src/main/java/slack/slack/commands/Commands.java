package slack.slack.commands;

import slack.slack.SlackException;

public enum Commands {
    HELP("Displays available commands", new HelpCommand()),
    START("Starts game. Give the opponent username", new StartCommand()),
    MOVE("Make a move. Please provide space delimited coordinates", new MoveCommand()),
    STATUS("Returns the status of the current game", new StatusCommand());

    private final String description;
    private final SlackCommand slackCommand;

    Commands(String description, SlackCommand slackCommand) {
        this.description = description;
        this.slackCommand = slackCommand;
    }

    public String getDescription() {
        return description;
    }

    public SlackCommand getSlackCommand() {
        return slackCommand;
    }

    public static Commands fromString(String s) {
        try {
            return valueOf(s.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new SlackException(s + " is not a valid command. Try help for more info.");
        }
    }
}
