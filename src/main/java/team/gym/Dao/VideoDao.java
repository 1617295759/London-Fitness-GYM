package team.gym.Dao;

import team.gym.Beans.Video;
import java.util.List;

public interface VideoDao {

    List<Video> findAllVideos();

    List<Video> findVideosByCategory(String category);
}
