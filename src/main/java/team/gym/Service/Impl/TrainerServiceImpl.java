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
    public String verifyTrainer(String username, String password) {
        Trainer verifyTrainer = (Trainer)trainerDao.findUserByAccount(username);
        if(verifyTrainer == null ){
            return "Trainer Account Doesn't Exist";
        }else if(password.equals(verifyTrainer.getPassword())){
            return null;
        }else{
            return "Wrong password, Type Again Please";
        }
    }

    @Override
    public User getTrainer(String username, String password) {
        return trainerDao.findUserByAccount(username);
    }

    @Override
    public String registerTrainer(Trainer trainer) {
        //1. verify

        //2.save the trainer
        trainerDao.saveTrainer(trainer);
        return "registered over";
    }
}
