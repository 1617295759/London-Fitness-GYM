package team.gym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import team.gym.Beans.Course;
import team.gym.Dao.CourseDao;
import team.gym.Dao.CustomerDao;
import team.gym.Dao.TrainerDao;
import team.gym.Service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    @Autowired
    CustomerDao customerdao;
    @Autowired
    TrainerDao trainerdao;
    @Autowired
    CourseDao coursedao;
    @Override
    public void saveCourse(Course course, String customerAccount, String trainerAccount) {
        // 1.verify if the course

        //2.  call for dao to save
        coursedao.saveCourse(course);
    }

    @Override
    public List<Course> getCustomerCourseById(int account) {
        return null;
    }

    @Override
    public List<Course> getTrainerCourseById(int account) {
        return null;
    }

    @Override
    public int deleteCourseById(int account, int courseId) {
        return 0;
    }

    @Override
    public int modifyCourseInfo(int courseId, String field, String newValue) {
        return 0;
    }
}
