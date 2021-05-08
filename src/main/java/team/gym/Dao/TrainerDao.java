package team.gym.Dao;

import team.gym.Beans.Course;
import team.gym.Beans.Customer;
import team.gym.Beans.Trainer;
import team.gym.Beans.User;

import java.util.Map;

/**
 *
 * Simple to Introduction
 * @ClassName:    TrainerDao
 * @Description:  TrainerDao should have methods only belongs to trainer
 * @Author:       Dingyue
 * @Version:      [v1.0]
 *
 */
public interface TrainerDao extends UserDao{

    public void saveTrainer(Trainer trainer);

    public User findUserByAccount(String userAccount);

}
