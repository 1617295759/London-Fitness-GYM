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
    public void saveCourse(Course course) {
        courseDao.saveCourse(course);
    }

    @Override
    public List<Course> getCustomerTodoCourse(String account) {
        if(courses==null){
            courses = courseDao.getCustomerCourses(account);
        }
        return getTodoCourses();
    }

    @Override
    public List<Course> getTrainerTodoCourse(String account) {
        if(courses==null){
            courses = courseDao.getTrainerCourses(account);
        }
        return getTodoCourses();
    }

    private List<Course> getTodoCourses() {
        List<Course> todoCourses = new ArrayList<Course>();
        Date current = new Date();
        for (Course course : courses) {
            if (course.getStartDate().after(current)){
                todoCourses.add(course);
            }
        }
        return todoCourses;
    }

    @Override
    public List<Course> getCustomerOverCourse(String account) {
        if(courses==null){
            courses = courseDao.getCustomerCourses(account);
        }
        return getOverCourses();
    }

    @Override
    public List<Course> getTrainerOverCourse(String account) {
        if(courses==null){
            courses = courseDao.getTrainerCourses(account);
        }
        return getOverCourses();
    }

    private List<Course> getOverCourses() {
        List<Course> overCourses = new ArrayList<Course>();
        Date current = new Date();
        for (Course course : courses) {
            if (course.getStartDate().before(current)){
                overCourses.add(course);
            }
        }
        return overCourses;
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
