package team.gym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.gym.Beans.Trainer;
import team.gym.Beans.User;
import team.gym.Dao.TrainerDao;
import team.gym.Service.TrainerService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    private TrainerDao trainerDao;

    @Override
    public String verifyTrainer(String username, String password) {
        Trainer verifytrainer = trainerDao.findTrainerByName(username);
        if(verifytrainer == null ){
            return "Trainer Account Doesn't Exist";
        }else if(password.equals(verifytrainer.getPassword())){
            return null;
        }else{
            return "Wrong password, Type Again Please";
        }
    }

    @Override
    public User getTrainer(String username, String password) {
        return trainerDao.findTrainerByName(username);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return (List<Trainer>) trainerDao.getTrainerMap().values().stream().collect(Collectors.toList());
    }

    @Override
    public String registerTrainer(Trainer trainer) {
        //1. verify

        //2.save the trainer
        trainerDao.saveTrainer(trainer);
        return "registered over";
    }
}
