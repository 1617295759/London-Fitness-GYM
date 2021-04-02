package team.gym.Service.Impl;

import org.springframework.stereotype.Service;
import team.gym.Beans.Customer;
import team.gym.Beans.User;
import team.gym.Service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public int verifyCustumer(String username, String password) {

        return 1;
    }

    @Override
    public User getCustomer(String username, String password) {
        return null;
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
