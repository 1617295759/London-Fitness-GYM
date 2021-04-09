package team.gym.Service.Impl;

import org.springframework.stereotype.Service;
import team.gym.Beans.Trainer;
import team.gym.Beans.User;
import team.gym.Service.TrainerService;
@Service
public class TrainerServiceImpl implements TrainerService {
    @Override
    public int verifyTrainer(String username, String password) {
        return 0;
    }

    @Override
    public User getTrainer(String username, String password) {
        return null;
    }

    @Override
    public int registerTrainer(Trainer trainer) {
        return 0;
    }
}
