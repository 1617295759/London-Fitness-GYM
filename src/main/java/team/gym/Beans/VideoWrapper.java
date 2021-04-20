package team.gym.Beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;


public class VideoWrapper {
    private Map<String,Video> videoMap;

    public VideoWrapper(){
        videoMap = new HashMap<String,Video>();
    }
    @XmlElementWrapper(name="videos")
    @XmlElement(name = "video")
    public Map<String, Video> getVideoMap() { return videoMap; }

    public void setVideoMap(Map<String, Video> videoMap) { this.videoMap = videoMap; }
}
