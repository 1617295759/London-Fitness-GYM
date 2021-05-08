package team.gym.Dao;

import org.springframework.stereotype.Repository;

import team.gym.Beans.Course;
import team.gym.Beans.User;
import team.gym.Beans.UserWrapper;

import java.util.Map;

@Repository
public interface UserDao {

    /** change information of user
     * @return change state
     * @param newValue the substitute value
     */
    int modifyUser(String account, String field, String newValue);

    /** change information of user
     * @return change state
     * @param course the future course
     */
    void addCourse(Course course);


}
