package team.gym.Service.Impl;

import org.springframework.stereotype.Service;
import team.gym.Beans.Course;
import team.gym.Service.CourseService;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Override
    public void saveCourse(Course course, String customerAccount, String trainerAccount) {

    }

    @Override
    public List<Course> getCustomerTodoCourse(String account) {
        return null;
    }

    @Override
    public List<Course> getCustomerOverCourse(String account) {
        return null;
    }

    @Override
    public List<Course> getTrainerTodoCourse(String account) {
        return null;
    }

    @Override
    public List<Course> getTrainerOverCourse(String account) {
        return null;
    }

    @Override
    public int deleteCourseById(String account, int courseId) {
        return 0;
    }

    @Override
    public int modifyCourseInfo(int courseId, String field, String newValue) {
        return 0;
    }
}
