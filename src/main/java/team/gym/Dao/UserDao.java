package team.gym.Dao;

import team.gym.Beans.Course;
import team.gym.Beans.User;
import team.gym.Beans.UserWrapper;

import java.util.Map;

public interface UserDao {

    public void saveUser(User user);

    public User findUserByAccount(String userAccount);

    public Map getUserMap();

    int modifyUser(String account, String field, String newValue);

    int addCourse(String account, Course course);

    public void saveWrapper(UserWrapper userWrapper);
}
