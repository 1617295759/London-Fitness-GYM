package team.gym.Dao;

import org.springframework.stereotype.Repository;
import team.gym.Beans.Course;
import team.gym.Beans.Customer;

import java.util.List;

/**
 * 课程接口
 */
@Repository
public interface CourseDao {


    int deleteByCourseId(int courseId);


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
    Course selByCourseId(int courseId);

    int modifyCourse(int courseId, String field, String newValue);
}