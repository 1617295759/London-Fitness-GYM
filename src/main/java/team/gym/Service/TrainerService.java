package team.gym.Service;

import team.gym.Beans.Trainer;
import team.gym.Beans.User;

public interface TrainerService {

    /** verify the trainer information is matched
     *
     * @param username user input username
     * @param password user input password
     * @return 0-no such trainer, 1-matched, 2-wrong password
     */
    public int verifyTrainer(String username, String password);

    public User getTrainer(String username, String password);

    /**
     * @param trainer
     * @return if anything wrong, return the error information
     */
    public String registerTrainer(Trainer trainer);
}
