package team.gym.Service;

import team.gym.Beans.Customer;
import team.gym.Beans.User;

public interface UserService {
    //  返回用户登录状态值 ，0-无账号，1-账号密码匹配，2-密码错误
    public int verifyCustumer(String username, String password);

    User getCustomer(String username, String password);

    public int verifyTrainer(String username, String password);

    User getTrainer(String username, String password);
}
