package team.gym.Dao.Impl;

import team.gym.Beans.Video;
import team.gym.Beans.VideoWrapper;
import team.gym.Dao.VideoDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class VideoDaoImpl implements VideoDao {

    private VideoWrapper wrapper;
    private VideoDao videoDao;

    public VideoDaoImpl() {
        // initiate File videosfile
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
        List<Video> videosInSameCate = videoDao.findVideosByCategory(category);
        return videosInSameCate;
    }

    @Override
    public List<Video> findAllVideo() {
        // TODO Auto-generated method stub
        return videoDao.findAllVideo();
    }


    @Override
    public Map<String, Video> getVideoMap() {
        return wrapper.getVideoMap();
    }
}
