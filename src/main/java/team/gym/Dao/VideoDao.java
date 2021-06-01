package team.gym.Dao;

import team.gym.Beans.Video;
import java.util.List;
import java.util.Map;

public interface VideoDao {

    /** find the list of videos in regard to category
     *
     * @param category the category
     * @return the list of videos
     */
    List<Video> findVideosByCategory(String category);

    /** find all the list of videos
     *
     * @return
     */
    List<Video> findAllVideo();

}
