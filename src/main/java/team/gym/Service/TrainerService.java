package team.gym.Service;

import team.gym.Beans.Trainer;
import team.gym.Beans.User;

public interface TrainerService {
    public int verifyTrainer(String username, String password);

    public User getTrainer(String username, String password);

    public int registerTrainer(Trainer trainer);
}
