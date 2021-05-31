package team.gym.Service;

import team.gym.Beans.Course;
import java.util.List;

public interface CourseService {

    //添加报名报信息，会员选课
    void saveCourse(Course course);

    //用户id查询用户未完成课程
    List<Course> getCustomerTodoCourse(String account);

    //用户id查询用户已完成课程
    List<Course> getCustomerOverCourse(String account);

    List<Course> getCustomerUnconfirmedCourse(String account);

    List<Course> getTrainerUnconfirmedCourse(String account);

    //id查询教练未完成课程
    List<Course> getTrainerTodoCourse(String account);

    //id查询教练已完成课程
    List<Course> getTrainerOverCourse(String account);

    //id删除我的课程
    int deleteCourse(Course course);

    /** change given course info field to new info
     *
     * @param course the course of course to be modified
     * @param field what field to be modified
     * @param newValue new value
     * @return statues 1-finished successfully 0-failed
     */
    int modifyCourseInfo(Course course, String field, String newValue);
}