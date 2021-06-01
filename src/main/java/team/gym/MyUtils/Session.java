package team.gym.MyUtils;

import team.gym.Beans.User;
/**
 * To store some data
 */
public class Session {
    private static final ThreadLocal<User> userholder = new ThreadLocal<>();
    private static final ThreadLocal<User> selectedCoach = new ThreadLocal<>();

    public static User getUser() { return userholder.get(); }

    public static void setUser(User user) { userholder.set(user); }

    public static User getCoach() { return selectedCoach.get(); }

    public static void setCoach(User user) { selectedCoach.set(user); }
}
