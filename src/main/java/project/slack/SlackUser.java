package project.slack;

public class SlackUser {
    private final String userId;
    private final String userName;

    public SlackUser(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SlackUser slackUser = (SlackUser) o;

        return userId.equals(slackUser.userId);
    }

    @Override
    public int hashCode() {
        return userId.hashCode();
    }
}
