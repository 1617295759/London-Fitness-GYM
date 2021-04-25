package team.gym.Dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import team.gym.Beans.Course;
import team.gym.Beans.Customer;
import team.gym.Beans.Video;
import team.gym.Beans.VideoWrapper;
import team.gym.Dao.CourseDao;
import team.gym.Dao.VideoDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VideoDaoImpl implements VideoDao {

    private VideoWrapper wrapper;

    @Autowired
    private VideoDao videoDao;

    @Autowired
    private CourseDao courseDao;



    public VideoDaoImpl() {
        // initiate File videos file
        String xmlPath = URLDecoder.decode("XMLdata/videos.xml", StandardCharsets.UTF_8);
        File videosfile = new File(xmlPath);
        try {
            // initiate JAXBContext context
            JAXBContext context = JAXBContext.newInstance(VideoWrapper.class);
            // initiate CustomerWrapper wrapper
            Unmarshaller um = context.createUnmarshaller();
            // Reading XML from the file and unmarshalling.
            wrapper = (VideoWrapper) um.unmarshal(videosfile);
        } catch (JAXBException e) {
            System.out.println("此时videos.xml为空");
            e.printStackTrace();
            wrapper = new VideoWrapper();
        }
    }

    @Override
    public List<Video> findVideosByCategory(String category) {
        Video video;
        Customer customer = customerDao.findCustomerByName(course1.getCustomerAccount());
        List<Course> courses = customer.getCourses();
        for (Course course:courses) {
            if(courseId == course.getCourseId())
                return course;
        }
        return null;
    }

    @Override
    public List<Video> findAllVideo() {
        return wrapper.getVideoMap().values().stream().collect(Collectors.toList());
    }


    @Override
    public Map<String, Video> getVideoMap() {
        return wrapper.getVideoMap();
    }
}
