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
        Trainer verifytrainer = trainerDao.findTrainerByName(username);
        if(verifytrainer == null ){
            return "User Not Found! Please Check Your ID";
        }else if(password == verifytrainer.getPassword()){
            return "1";
        }else{
            return "Wrong Password! Please Input Again";
        }
    }

    @Override
    public User getTrainer(String username, String password) {

        return trainerDao.findTrainerByName(username);
    }

    @Override
    public String registerTrainer(Trainer trainer) {

        return " ";
    }
}
