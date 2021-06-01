package team.gym.Service;

import team.gym.Beans.Trainer;
import team.gym.Beans.User;

import java.util.List;
/**
 * realize the functions in regard to Trainers
 */
public interface TrainerService {

    /** verify the trainer information is matched
     *
     * @param username user input username
     * @param password user input password
     * @return 0-no such trainer, 1-matched, 2-wrong password
     */
    public String verifyTrainer(String username, String password);

    /**get the trainer Object according to the account
     *
     * @param username trainer account
     * @param password trainer password
     * @return If the trainer exists, return the trainer object; If not, null will be returned.
     */
    public User getTrainer(String username, String password);

    /** get the list of all trainers
     *
     * @return the list of all trainers
     */
    public List<Trainer> getAllTrainers();

    /**Verify whether the trainer registration information meets the requirements, and return an error message;
     * Save the information if there are no errors
     *
     * @param trainer the trainer object carrying the register information from front end.
     * @return If Registration information does not comply with the rules,
     * the concrete hint will be returned; If nothing wrong, null will be returned.
     */
    public String registerTrainer(Trainer trainer);
}
