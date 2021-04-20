package team.gym.Dao.Impl;
import org.springframework.stereotype.Repository;
import team.gym.Beans.Course;
import team.gym.Beans.CourseWrapper;
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
public class CourseDaoImpl implements CourseDao {
    /*
            文件路径问题：java.io.FileNotFoundException:系统找不到指定的路径 ？？
            问题解决 ：路径中的中文或有空格路径处理，会用编码为 a3%20%e9%a1%b9% 等字符
            String xmlPath = URLDecoder.decode("/XMLdata/customers.xml","utf-8");

            URL xmlURL = getClass().getResource("/xmldata/customer.xml");
            resources文件夹下为静态资源，只适合存放配置等不改动的文件，持久化文件不应该放在那里
    */
    private final File coursesfile;
    private CourseWrapper wrapper;
    private JAXBContext context;

    public CourseDaoImpl() {
        // initiate File coursesfile
        String xmlPath = URLDecoder.decode("XMLdata/courses.xml", StandardCharsets.UTF_8);
        coursesfile = new File(xmlPath);
        try {
            // initiate JAXBContext context
            context = JAXBContext.newInstance(CourseWrapper.class);
            // initiate CourseWrapper wrapper
            Unmarshaller um = context.createUnmarshaller();
            // Reading XML from the file and unmarshalling.
            wrapper = (CourseWrapper) um.unmarshal(coursesfile);
        } catch (JAXBException e) {
            System.out.println("此时courses.xml为空");
            e.printStackTrace();
            wrapper = new CourseWrapper();
        }
    }


    @Override
    public int saveCourse(Course course) {
        try {
            // read the original data and append the new customer information
            Map<String, Course> map = getCourseMap();
            map.put(course.getCourseId(), course);
            //package the map to wrapper to transmute to XML
            wrapper.setCourseMap(map);
            saveWrapper(wrapper);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public Course selByCourseId(String courseId) {
        //get the specific course information
        return wrapper.getCourseMap().get(courseId);
    }

    @Override
    public int delByCourseId(String courseId) {
        int result = 0;//initial state
        return result;
    }


    @Override
    public int modifyCourse(String courseId, String field, String newValue) {
        return 0;
    }

    @Override
    public Map<String, Course> getCourseMap() {
        return wrapper.getCourseMap();
    }


    /**
     * write the wrapper to customers.xml
     *
     * @param wrapper the wrapper to be saved
     */
    public void saveWrapper(CourseWrapper wrapper) {
        try {
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(wrapper, coursesfile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}