package team.gym.Dao.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import team.gym.Beans.Course;

import team.gym.Beans.Customer;
import team.gym.Beans.Trainer;
import team.gym.Beans.User;
import team.gym.Dao.CourseDao;
import team.gym.Dao.CustomerDao;
import team.gym.Dao.TrainerDao;
import team.gym.MyUtils.Session;

import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {
    /*
            文件路径问题：java.io.FileNotFoundException:系统找不到指定的路径
import team.gym.MyUtils.Session;


import java.util.List;

 ？？
            问题解决 ：路径中的中文或有空格路径处理，会用编码为 a3%20%e9%a1%b9% 等字符
            String xmlPath = URLDecoder.decode("/XMLdata/customers.xml","utf-8");

            URL xmlURL = getClass().getResource("/xmldata/customer.xml");
            resources文件夹下为静态资源，只适合存放配置等不改动的文件，持久化文件不应该放在那里
    */

    public User user = Session.getUser();

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private TrainerDao trainerDao;

    @Override
    public int saveCourse(Course course) {
        try {
            String username = sortClass();
            if(username.equals("Customer")) {
                List<Course> courses1;
                Customer customer = (Customer) user;
                courses1 = customer.getCourses();
                courses1.add(course);
                customer.setCourses(courses1);
                customerDao.saveUser(customer);

                List<Course> courses2;
                String trainerName = course.getTrainerAccount();
                Trainer trainer = (Trainer)trainerDao.findUserByAccount(trainerName);
                courses2 = trainer.getCourses();
                courses2.add(course);
                trainer.setCourses(courses2);
                trainerDao.saveUser(trainer);
            }
            if(username.equals("Trainer")) {
                List<Course> courses3;
                Trainer trainer = (Trainer) user;
                courses3 = trainer.getCourses();
                courses3.add(course);
                trainer.setCourses(courses3);
                trainerDao.saveUser(trainer);

                List<Course> courses4;
                String customerName = course.getCustomerAccount();
                Customer customer = (Customer)customerDao.findUserByAccount(customerName);
                courses4 = customer.getCourses();
                courses4.add(course);
                customer.setCourses(courses4);
                customerDao.saveUser(customer);
            }

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public Course selByCourseId(int courseId) {
        //get the specific course information
        Course course1 = courseDao.selByCourseId(courseId);
        Customer customer = (Customer)customerDao.findUserByAccount(course1.getCustomerAccount());
        List<Course> courses = customer.getCourses();
        for (Course course:courses) {
            if(courseId == course.getCourseId())
                return course;
        }
        return null;
    }

    @Override
    public String sortClass() {
        User user = Session.getUser();
        return user.getName();
    }

    @Override
    public int delByCourseId(int courseId) {
        Course course1 = courseDao.selByCourseId(courseId);
        String trainerName = course1.getTrainerAccount();
        String customerName = course1.getCustomerAccount();
        Trainer trainer = (Trainer)trainerDao.findUserByAccount(trainerName);
        Customer customer = (Customer)customerDao.findUserByAccount(customerName);
        List<Course> courses = customer.getCourses();

        for (Course course:courses) {
            if(courseId == course.getCourseId()) {
                courses.remove(course);
                customer.setCourses(courses);
                trainer.setCourses(courses);
                return 1;
            }
        }
        return 0;
    }


    @Override
    public int modifyCourse(int courseId, String field, String newValue) {
        Course course = selByCourseId(courseId);
        switch (field){
            case("feedback"):
                course.setFeedback(newValue);
            case("status"):
                course.setStatus(newValue);
        }
        saveCourse(course);
        return 0;
    }





}