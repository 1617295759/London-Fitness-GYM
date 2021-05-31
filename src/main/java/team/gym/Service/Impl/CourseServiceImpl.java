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
    final
    CourseDao courseDao;
    final
    CustomerDao customerDao;
    final
    TrainerDao trainerDao;
    List<Course> courses = null;

    @Autowired
    public CourseServiceImpl (CourseDao courseDao, CustomerDao customerDao, TrainerDao trainerDao) {
        this.courseDao = courseDao;
        this.customerDao = customerDao;
        this.trainerDao = trainerDao;
    }

    @Override
    public void saveCourse(Course course) {
        courseDao.addNewCourse(course);
    }

    @Override
    public List<Course> getCustomerTodoCourse(String account) {
        List<Course> todoCourses = new ArrayList<Course>();
        Date now = new Date();
        for (Course course : courseDao.getCustomerCourses(account)) {
            if (course.getStartDate().after(now)){
                if(course.getStatus()==Course.ACCEPTED || course.getStatus()==Course.FINISHED){
                    todoCourses.add(course);
                }
            }else{
                long diff = course.getStartDate().getTime() - now.getTime();
                System.out.println(diff);
                if(Math.abs(diff) < 600000 &&
                        (course.getStatus()==Course.ACCEPTED||course.getStatus()==Course.FINISHED)){
                    todoCourses.add(course);
                }
            }
        }
        return todoCourses;
    }

    @Override
    public List<Course> getTrainerTodoCourse(String account) {
        List<Course> todoCourses = new ArrayList<Course>();
        Date now = new Date();
        for (Course course : courseDao.getTrainerCourses(account)) {
            if (course.getStartDate().after(now)){
                if(course.getStatus()==Course.ACCEPTED || course.getStatus()==Course.FINISHED){
                    todoCourses.add(course);
                }
            }else{
                long diff = now.getTime() - course.getStartDate().getTime() ;
                if(diff < 600000 &&
                        (course.getStatus()==Course.ACCEPTED||course.getStatus()==Course.FINISHED)){
                    todoCourses.add(course);
                }
            }
        }
        return todoCourses;
    }

    @Override
    public List<Course> getCustomerUnconfirmedCourse (String account) {
        List<Course> unCourses = new ArrayList<>();
        for (Course course : courseDao.getCustomerCourses(account)) {
            if (course.getStatus()==Course.COMMITTED || course.getStatus()==Course.REJECTED){
                unCourses.add(course);
            }
        }
        return unCourses;
    }

    @Override
    public List<Course> getTrainerUnconfirmedCourse (String account) {
        List<Course> unCourses = new ArrayList<>();
        Date now = new Date();
        for (Course course : courseDao.getTrainerCourses(account)) {
            if (course.getStatus()==Course.COMMITTED && course.getStartDate().after(now)){
                unCourses.add(course);
            }
        }
        return unCourses;
    }

    @Override
    public List<Course> getCustomerOverCourse(String account) {
        List<Course> overCourses = new ArrayList<>();
        Date now = new Date();
        for (Course course : courseDao.getCustomerCourses(account)) {
            judgeMiss(course);

            if (course.getStartDate().before(now) || course.getStatus()==Course.FINISHED){
                if(course.getStatus()==Course.FINISHED || course.getStatus()==Course.MISS){
                    overCourses.add(course);
                }
            }
        }
        return overCourses;
    }

    @Override
    public List<Course> getTrainerOverCourse(String account) {
        List<Course> overCourses = new ArrayList<Course>();
        Date now = new Date();

        for (Course course : courseDao.getTrainerCourses(account)) {
            judgeMiss(course);

            if (course.getStartDate().before(now) || course.getStatus()==Course.FINISHED
                    || course.getStatus()==Course.REJECTED){
                if(course.getStatus()==Course.FINISHED || course.getStatus()==Course.MISS
                    || course.getStatus()==Course.COMMITTED || course.getStatus()==Course.REJECTED){
                    overCourses.add(course);
                }
            }
        }
        return overCourses;
    }

    private void judgeMiss(Course course){
        Date now = new Date();
        long diff = now.getTime() - course.getStartDate().getTime();
        if(diff > 600000 && course.getStatus()==Course.ACCEPTED){
            modifyCourseInfo(course,"status",String.valueOf(Course.MISS));
        }
    }

    @Override
    public int deleteCourse(Course course) {
        courseDao.delCourse(course);
        return 0;
    }

    @Override
    public int modifyCourseInfo(Course course, String field, String newValue) {
        courseDao.modifyCourse(course,field,newValue);
        return 0;
    }
}
