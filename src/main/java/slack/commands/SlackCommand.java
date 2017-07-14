package slack.commands;

import slack.slack.SlackMessage;
import slack.slack.SlackResponse;

import java.util.function.Function;

public interface SlackCommand extends Function<SlackMessage, SlackResponse> {
}
