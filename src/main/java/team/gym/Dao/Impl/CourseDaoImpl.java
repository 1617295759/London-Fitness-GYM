package team.gym.Dao.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import team.gym.Beans.Course;

import team.gym.Beans.Customer;
import team.gym.Dao.CourseDao;
import team.gym.Dao.CustomerDao;
import team.gym.MyUtils.Session;


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
    private CourseDao courseDao;

    @Autowired
    private CustomerDao customerDao;

    private Customer customer;



    @Override
    public int saveCourse(Course course) {
        try {
            List<Course> courses1;
            customer = (Customer)Session.getUser();
            courses1 = customer.getCourses();
            courses1.add(course);
            customer.setCourses(courses1);
            customerDao.saveCustomer(customer);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public Course selByCourseId(int courseId) {
        //get the specific course information
        customer = (Customer)Session.getUser();
        List<Course> courses = customer.getCourses();
        for (Course course:courses) {
            if(courseId == course.getCourseId())
                return course;
        }
        return null;
    }

    @Override
    public int delByCourseId(int courseId) {
        customer = (Customer)Session.getUser();
        List<Course> courses = customer.getCourses();
        for (Course course:courses) {
            if(courseId == course.getCourseId()) {
                courses.remove(course);
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
        return 0;
    }





}