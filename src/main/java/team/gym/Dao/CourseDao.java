package team.gym.Dao;

import org.springframework.stereotype.Repository;
import team.gym.Beans.Course;

import java.util.List;


/**
 * 课程接口
 */
public interface CourseDao {
    /**String customerAccount,
     String trainerAccount,
     String startTime,
     String endTime,
     String category,
     double price
     These parameters are needed to be involved
     *
     * @param courses
     * @return
     */
    int addNewCourse(Course courses);

    /**根据id查询课表
     *
     * @param courseId
     * @return
     */
    Course selByCourseId(int courseId);

    /**
     * @param
     * @return
     */
    int delCourse(Course course);

    int modifyCourse(Course course, String field, String newValue);

    /**
     * @param account
     * @return
     */
    List<Course> getCustomerCourses(String account);

    List<Course> getTrainerCourses(String account);
}