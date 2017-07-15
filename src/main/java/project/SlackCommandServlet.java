package project;

import com.google.gson.Gson;
import project.slack.SlackException;
import project.slack.SlackMessage;
import project.slack.SlackResponse;
import project.slack.commands.Commands;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;

@WebServlet(value = "/ttt")
public class SlackCommandServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        SlackMessage slackMessage = new SlackMessage(request.getParameterMap());

        response.setContentType("application/json");
        response.getWriter().println(new Gson().toJson(getResponse(slackMessage)));
    }

    private SlackResponse getResponse(SlackMessage slackMessage) {
        try {
            String tttCommand = slackMessage.getText().split(" ")[0];
            Commands command = Commands.fromString(tttCommand);
            return command.getSlackCommand().apply(slackMessage);
        } catch (SlackException slackException) {
            return new SlackResponse(SlackResponse.ResponseType.ephemeral, slackException.getMessage(),
                    Collections.emptyList());
        } catch (RuntimeException e) {
            //NOTE: In a production system this would be sent to logs not to the user!
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return new SlackResponse(SlackResponse.ResponseType.ephemeral, "Error: " + sw.toString(),
                    Collections.emptyList());
        }
    }


}