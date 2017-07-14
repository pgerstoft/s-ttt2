package slack;

import com.google.gson.Gson;
import slack.commands.Commands;
import slack.slack.SlackMessage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@WebServlet(value = "/ttt")
public class HelloWorld extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        SlackMessage slackMessage = new SlackMessage(new BufferedReader(new InputStreamReader(request.getInputStream())).lines().collect(Collectors.toList()));

        String command = slackMessage.getText().split(" ")[0];

        Commands commands = Commands.fromString(command);



        response.setContentType("text/plain");
        response.getWriter().println(new Gson().toJson(commands.getSlackCommand().apply(slackMessage)));
    }

}