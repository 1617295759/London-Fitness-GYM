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
import java.util.List;


@Repository
public class CourseDaoImpl implements CourseDao {
    /*
            文件路径问题：java.io.FileNotFoundException:系统找不到指定的路径 ？？
            问题解决 ：路径中的中文或有空格路径处理，会用编码为 a3%20%e9%a1%b9% 等字符
            String xmlPath = URLDecoder.decode("/XMLdata/customers.xml","utf-8");

            URL xmlURL = getClass().getResource("/xmldata/customer.xml");
            resources文件夹下为静态资源，只适合存放配置等不改动的文件，持久化文件不应该放在那里
    */

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
            customer = (Customer) Session.getUser();
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
            case ("status"):
                course.setStatus(Integer.parseInt(newValue));
        }
        saveCourse(course);
        return 0;
    }

    @Override
    public List<Course> getCustomerCourses(String account) {
        return customerDao.findCustomerByAccount(account).getCourses();
    }

    @Override
    public List<Course> getTrainerCourses(String account) {
        return trainerDao.findTrainerByAccount(account).getCourses();
    }

    public void saveCourse(Course course) {
        if (customer == null) customer = customerDao.findCustomerByAccount(course.getCustomerAccount());
        if (trainer == null) trainer = trainerDao.findTrainerByAccount(course.getTrainerAccount());
        List<Course> c_courses = customer.getCourses();
        for (Course c : c_courses) {
            if (c.getCourseId() == course.getCourseId()){
                c_courses.remove(c);
                c_courses.add(course);
            }
        }
        List<Course> t_courses = trainer.getCourses();
        for (Course c : t_courses) {
            if (c.getCourseId() == course.getCourseId()) {
                t_courses.remove(c);
                t_courses.add(course);
            }
        }
        customerDao.saveCustomer(customer);
        trainerDao.saveTrainer(trainer);
    }
}