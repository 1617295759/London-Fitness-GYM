package team.gym.Dao;

import org.springframework.stereotype.Repository;
import team.gym.Beans.Course;


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
     * @param courses
     * @return
     */
    int saveCourse(Course courses);


    /**根据id查询课表
     *
     * @param courseId
     * @return
     */
    Course selByCourseId(int courseId);


    /**
     * @param courseId
     * @return
     */
    String sortClass();

    int delByCourseId(int courseId);

    int modifyCourse(int courseId, String field, String newValue);

}