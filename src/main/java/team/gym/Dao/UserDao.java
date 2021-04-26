package team.gym.Dao;

import team.gym.Beans.Course;
import team.gym.Beans.User;
import team.gym.Beans.UserWrapper;

import java.util.Map;

public interface UserDao {

    /** append a user information into the xml data
     *
     * @param user the Object to be saved
     */
    void saveUser(User user);

    /**
     * @param userAccount the account number of the user
     * @return the corresponding customer Object
     */
    User findUserByAccount(String userAccount);

    /**
     * @return all the users' map, the key is account number(String), value is user Object
     */
    Map getUserMap();

    /** change information of user
     * @return change state
     * @param newValue the substitute value
     */
    int modifyUser(String account, String field, String newValue);

    void addCourse(Course course);

    void saveWrapper(UserWrapper userWrapper);
}
