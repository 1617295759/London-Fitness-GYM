package team.gym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.gym.Beans.Course;
import team.gym.Dao.CourseDao;
import team.gym.Dao.CustomerDao;
import team.gym.Dao.TrainerDao;
import team.gym.Service.CourseService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    TrainerDao trainerDao;
    List<Course> courses = null;
    @Override
    public void saveCourse(Course course, String customerAccount, String trainerAccount) {
        courseDao.saveCourse(course);
    }

    @Override
    public List<Course> getCustomerTodoCourse() {
        if(courses==null){
            courses = courseDao.getUserCourses();
        }
        return getTodoCourses();
    }

    @Override
    public List<Course> getTrainerTodoCourse() {
        if(courses==null){
            courses = courseDao.getUserCourses();
        }
        return getTodoCourses();
    }

    private List<Course> getTodoCourses() {
        List<Course> todoCourses = new ArrayList<Course>();
        Date current = new Date();
        for (Course course : courses) {
            if (course.getStartTime().after(current)){
                todoCourses.add(course);
            }
        }
        return todoCourses;
    }

    @Override
    public List<Course> getCustomerOverCourse(String account) {
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
