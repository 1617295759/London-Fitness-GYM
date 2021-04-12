package team.gym.Dao;

import team.gym.Beans.Trainer;

import java.util.Map;

public interface TrainerDao {

    /** append a customer information into the xml data
     *
     * @param trainer the Object to be saved
     * @return
     */
    public int saveTrainer(Trainer trainer);

    /**
     * @param username the account number of the trainer
     * @return the corresponding customer Object
     */
    public Trainer findTrainerByName(String username);

    public boolean isEmpty();

    /**
     * @return all the trainer map, the key is account number(String), value is trainer Object
     */
    public Map getTrainerMap();

}
