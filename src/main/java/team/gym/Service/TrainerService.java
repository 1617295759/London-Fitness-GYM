package team.gym.Service;

import team.gym.Beans.Customer;
import team.gym.Beans.Trainer;
import team.gym.Beans.User;

public interface TrainerService {
    public String verifyTrainer(String username, String password);

    public User getTrainer(String username, String password);

    public String registerTrainer(Trainer trainer);
}
