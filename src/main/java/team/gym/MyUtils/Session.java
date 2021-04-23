package team.gym.MyUtils;

import team.gym.Beans.User;

public class Session {
    private static final ThreadLocal<User> userholder = new ThreadLocal<>();

    public static User getUser() { return userholder.get(); }

    public static void setUser(User user) { userholder.set(user); }

}
