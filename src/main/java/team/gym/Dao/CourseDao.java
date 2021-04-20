package team.gym.Dao;

import org.springframework.stereotype.Repository;
import team.gym.Beans.Course;

import java.util.Map;

/**
 * 课程接口
 */
@Repository
public interface CourseDao {


    /**String customerAccount,
     String trainerAccount,
     String startTime,
     String endTime,
     String category,
     double price
     These parameters are needed to be involved
     *
     * @param course
     * @return
     */
    int saveCourse(Course course);


    /**根据id查询课表
     *
     * @param courseId
     * @return
     */
    Course selByCourseId(String courseId);

    int delByCourseId(String courseId);

    int modifyCourse(String courseId, String field, String newValue);

    public Map getCourseMap();
}