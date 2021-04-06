package team.gym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.gym.Beans.Customer;
import team.gym.Beans.User;
import team.gym.Dao.UserDao;
import team.gym.Service.UserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int verifyCustumer(String username, String password) {
        Customer verifycustomer = userDao.getCustomer(username);
        if(verifycustomer == null ){
            return 0;
        }else if(password == verifycustomer.getPassword()){
            return 1;
        }else{
            return 2;
        }
    }

    @Override
    public User getCustomer(String username, String password) {
        return userDao.getCustomer(username);
    }

    @Override
    public int verifyTrainer(String username, String password) {
        return 1;
    }

    @Override
    public User getTrainer(String username, String password) {
        return null;
    }

}
