package project.slack.commands;

import project.slack.SlackMessage;
import project.slack.SlackResponse;

import java.util.function.Function;

public interface SlackCommand extends Function<SlackMessage, SlackResponse> {
}
