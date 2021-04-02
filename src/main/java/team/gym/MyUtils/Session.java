package team.gym.MyUtils;

import team.gym.Beans.User;

public class Session {

    private static User user;
    private static String type;

    public static User getUser() { return user; }

    public static void setUser(User user) { Session.user = user; }

    public static String getType() { return type; }

    public static void setType(String type) { Session.type = type; }
}
