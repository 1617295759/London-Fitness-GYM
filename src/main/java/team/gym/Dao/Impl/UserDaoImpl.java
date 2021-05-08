package team.gym.Dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import team.gym.Beans.CustomerWrapper;
import team.gym.Beans.User;
import team.gym.Beans.Course;
import team.gym.Beans.UserWrapper;
import team.gym.Dao.UserDao;
import team.gym.Dao.CourseDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;


@Repository
public abstract class UserDaoImpl implements UserDao{

    public String fileName;

    public CourseDaoImpl courseDaoImpl;

   @Autowired
    public CourseDao courseDao;

    @Override
    public void addCourse(Course course) {
        courseDaoImpl.saveCourse(course);
    }

}
