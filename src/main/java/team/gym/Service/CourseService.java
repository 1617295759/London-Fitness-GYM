package team.gym.Service;

import team.gym.Beans.Course;
import java.util.List;

public interface CourseService {

    //添加报名报信息，会员选课
    void saveCourse(Course course,String customerAccount, String trainerAccount);

    //用户id查询用户未完成课程
    List<Course> getCustomerTodoCourse(int account);

    //用户id查询用户已完成课程
    List<Course> getCustomerOverCourse(int account);

    //id查询教练未完成课程
    List<Course> getTrainerTodoCourse(int account);

    //id查询教练已完成课程
    List<Course> getTrainerOverCourse(int account);

    //id删除我的课程
    int deleteCourseById(int account,int courseId);

    /** change given course info field to new info
     *
     * @param courseId the course id of course to be modified
     * @param field what field to be modified
     * @param newValue new value
     * @return statues 1-finished successfully 0-failed
     */
    int modifyCourseInfo(int courseId, String field, String newValue);
}