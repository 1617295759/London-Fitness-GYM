package team.gym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.gym.Beans.Trainer;
import team.gym.Beans.User;
import team.gym.Dao.TrainerDao;
import team.gym.Service.TrainerService;
@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    private TrainerDao trainerDao;

    @Override
    public int verifyTrainer(String username, String password) {
        Trainer verifytrainer = trainerDao.findTrainerByAccount(username);
        if(verifytrainer == null ){
            return 0;
        }else if(password.equals(verifytrainer.getPassword())){
            return 1;
        }else{
            return 2;
        }
    }

    @Override
    public User getTrainer(String username, String password) {
        return trainerDao.findTrainerByAccount(username);
    }

    @Override
    public String registerTrainer(Trainer trainer) {
        //1. verify

        //2.save the trainer
        trainerDao.saveTrainer(trainer);
        return "registered over";
    }
}
