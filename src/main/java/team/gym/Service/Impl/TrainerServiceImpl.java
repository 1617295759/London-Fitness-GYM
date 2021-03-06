package team.gym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.gym.Beans.Trainer;
import team.gym.Beans.User;
import team.gym.Dao.TrainerDao;
import team.gym.Service.TrainerService;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
/**
 * realize the functions in regard to Courses
 */
@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    private TrainerDao trainerDao;

    @Override
    public String verifyTrainer(String username, String password) {
        Trainer verifytrainer = trainerDao.findTrainerByAccount(username);
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
        return trainerDao.findTrainerByAccount(username);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return (List<Trainer>) trainerDao.getTrainerMap().values().stream().collect(Collectors.toList());
    }

    @Override
    public String registerTrainer(Trainer trainer) {
        //regular expression to verify account
        String v_account = "^[a-zA-Z]\\w{5,17}$";

        //regular expression to verify password
        String v_password = "^[a-zA-Z0-9]{6,16}$";

        //regular expression to verify phone
        String v_phone = "^((13[0-9])|(15[^4,\\D])|(14[57])|(17[0])|(17[7])|(18[0,0-9]))\\d{8}$";

        //regular expression to verify e-mail
        String v_email = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

        if(Pattern.matches(v_account, trainer.getAccount()) == false)
            return "Please ensure your account has 5-17 letters without numbers";

        else if(Pattern.matches(v_password,trainer.getPassword()) == false)
            return "Please ensure your account has 6-16 letters";

        else if(Pattern.matches(v_phone,trainer.getPhone()) == false)
            return "Please input correct phone number";

        else if(Pattern.matches(v_email,trainer.getEmail()) == false)
            return "Please input correct email address";
        else {
            trainerDao.saveTrainer(trainer);
            return null;
        }
    }
}
