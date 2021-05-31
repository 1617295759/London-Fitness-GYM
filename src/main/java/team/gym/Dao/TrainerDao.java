package team.gym.Dao;

import team.gym.Beans.Course;
import team.gym.Beans.Trainer;

import java.util.Map;

public interface TrainerDao {

    /** append a trainer information into the xml data
     *
     * @param trainer the Object to be saved
     */
    public void saveTrainer(Trainer trainer);

    /**
     * @param username the account number of the trainer
     * @return the corresponding customer Object
     */
    public Trainer findTrainerByAccount(String username);

    /**
     * @return all the trainer map, the key is account number(String), value is trainer Object
     */
    public Map getTrainerMap();

    int modifyTrainer(String account, String field, String newValue);

    int addCourse(String account, Course course);
}
