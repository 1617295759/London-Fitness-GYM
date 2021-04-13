package team.gym.Service;

import team.gym.Beans.Course;
import java.util.List;

public interface CourseService {

    //添加报名报信息，会员选课
    void saveCourse(Course course,String customerAccount, String trainerAccount);

    //id查询用户课程
    List<Course> getCustomerCourseById(int account);

    //id查询教练课程
    List<Course> getTrainerCourseById(int account);

    //id删除我的课程
    int deleteCourseById(int account,int courseId);

    int modifyCourseInfo(int courseId, String field, String newValue);
}