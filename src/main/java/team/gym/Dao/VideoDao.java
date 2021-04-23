package team.gym.Dao;

import team.gym.Beans.Video;
import java.util.List;
import java.util.Map;

public interface VideoDao {

    List<Video> findVideosByCategory(String category);

    List<Video> findAllVideo();

    public Map getVideoMap();
}
