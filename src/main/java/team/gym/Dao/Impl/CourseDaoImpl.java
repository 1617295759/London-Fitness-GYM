package team.gym.Dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import team.gym.Beans.Course;

import team.gym.Beans.Customer;
import team.gym.Beans.Trainer;
import team.gym.Dao.CourseDao;
import team.gym.Dao.CustomerDao;
import team.gym.Dao.TrainerDao;
import team.gym.MyUtils.Session;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * do the operation in regard to courses
 */
@Repository
public class CourseDaoImpl implements CourseDao {


    @Autowired
    private TrainerDao trainerDao;

    @Autowired
    private CustomerDao customerDao;

    private Customer customer;
    private Trainer trainer;

    @Override
    public int addNewCourse(Course course) {
        try {
            course.generateId();

            List<Course> trainer_course;
            trainer = trainerDao.findTrainerByAccount(course.getTrainerAccount());
            trainer_course = trainer.getCourses();
            trainer_course.add(course);
            trainer.setCourses(trainer_course);
            trainerDao.saveTrainer(trainer);

            List<Course> user_course;
            customer = customerDao.findCustomerByAccount(course.getCustomerAccount());
            user_course = customer.getCourses();
            user_course.add(course);
            customer.setCourses(user_course);
            customerDao.saveCustomer(customer);
            return 1;
        } catch (Exception e) {
            System.out.println("fail to add a new course");
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public Course selByCourseId(int courseId) {
        //get the specific course information
        customer = (Customer) Session.getUser();
        List<Course> courses = customer.getCourses();
        for (Course course : courses) {
            if (courseId == course.getCourseId())
                return course;
        }
        return null;
    }

    @Override
    public int delCourse(Course course) {
        customer = customerDao.findCustomerByAccount(course.getCustomerAccount());
        trainer = trainerDao.findTrainerByAccount(course.getTrainerAccount());
        List<Course> courses = customer.getCourses();
        for (Course c : courses) {
            if (course.getCourseId() == c.getCourseId()) {
                courses.remove(course);
                customer.setCourses(courses);
                customerDao.saveCustomer(customer);
                break;
            }
        }

        List<Course> t_courses = trainer.getCourses();
        for (Course c : t_courses) {
            if (course.getCourseId() == c.getCourseId()) {
                courses.remove(course);
                trainer.setCourses(courses);
                trainerDao.saveTrainer(trainer);
                return 1;
            }
        }

        return 0;
    }

    @Override
    public int modifyCourse(Course course, String field, String newValue) {
        switch (field) {
            case ("feedback"):
                course.setFeedback(newValue);
                break;
            case ("status"):
                course.setStatus(Integer.parseInt(newValue));
                break;
        }
        saveCourse(course);
        return 0;
    }

    @Override
    public List<Course> getCustomerCourses(String account) {
        Customer customer;
        if ((customer = customerDao.findCustomerByAccount(account))!=null){
            return customer.getCourses();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Course> getTrainerCourses(String account) {
        return trainerDao.findTrainerByAccount(account).getCourses();
    }

    public void saveCourse(Course course) {
        if (customer == null) customer = customerDao.findCustomerByAccount(course.getCustomerAccount());
        if (trainer == null) trainer = trainerDao.findTrainerByAccount(course.getTrainerAccount());
        // java.util.ConcurrentModificationException: null -> Ensure that the index is normal
        List<Course> c_courses = customer.getCourses();
        ListIterator<Course> iterator = c_courses.listIterator();
        while(iterator.hasNext()){
            Course c = iterator.next();
            if (c.getCourseId() == course.getCourseId()){
                iterator.set(course);
            }
        }
        List<Course> t_courses = trainer.getCourses();
        iterator = t_courses.listIterator();
        while(iterator.hasNext()){
            Course c = iterator.next();
            if (c.getCourseId() == course.getCourseId()){
                iterator.set(course);
            }
        }
        customer.setCourses(c_courses);
        trainer.setCourses(t_courses);

        customerDao.saveCustomer(customer);
        trainerDao.saveTrainer(trainer);
    }
}