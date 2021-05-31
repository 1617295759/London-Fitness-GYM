import org.junit.Test;
import team.gym.Beans.Course;
import team.gym.Beans.Customer;
import team.gym.Dao.Impl.CourseDaoImpl;
import team.gym.Dao.Impl.CustomerDaoImpl;

import java.util.Date;
import java.util.Random;

public class testTime {
    @Test
    public void testTime(){
        Date now = new Date();
//        for (Course c:new CustomerDaoImpl().findCustomerByAccount("Dwayne Johnson").getCourses()) {
//            System.out.println(c.getStartDate().after(now) && c.getStatus()==Course.ACCEPTED);
//        }
        CourseDaoImpl courseDao = new CourseDaoImpl();
        for (Course course: courseDao.getCustomerCourses("Dwayne Johnson")) {
            System.out.println(course.getStartDate().after(now) && course.getStatus()==Course.ACCEPTED);
            if (course.getStartDate().after(now) && course.getStatus()==Course.ACCEPTED){
                System.out.println(course.getStartDate());
            }
        }
    }

    @Test
    public void testNum(){
        System.out.println(new Random().nextInt(1000));;
    }
}
