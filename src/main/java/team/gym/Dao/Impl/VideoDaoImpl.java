package team.gym.Dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VideoDaoImpl implements VideoDao {

    private VideoWrapper videoWrapper;

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
            videoWrapper = (VideoWrapper) um.unmarshal(videosfile);
        } catch (JAXBException e) {
            System.out.println("此时videos.xml为空");
            e.printStackTrace();
            videoWrapper = new VideoWrapper();
        }
    }

    @Override
    public List<Video> findVideosByCategory(String category) {
        List<Video> videos = findAllVideos();
        List<Video> videoList = null;
        for (Video video:videos) {
            if(video.getCategory().equals(category)) {
                assert false;
                videoList.add(video);
            }
        }
        return videoList;
    }

    @Override
    public List<Video> findAllVideos() {
        return new ArrayList<>(videoWrapper.getVideoMap().values());
    }


    @Override
    public Map<String, Video> getVideoMap() {
        return videoWrapper.getVideoMap();
    }
}
