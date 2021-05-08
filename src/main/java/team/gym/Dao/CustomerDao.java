package team.gym.Dao;

import team.gym.Beans.Course;
import team.gym.Beans.Customer;
import team.gym.Beans.User;

import java.util.Map;

/**
 *
 * Simple to Introduction
 * @ClassName:    CustomerDao
 * @Description:  CustomerDao should have methods only belongs to trainer
 * @Author:       Dingyue
 * @Version:      [v1.0]
 *
 */
public interface CustomerDao extends UserDao{
    public void saveCustomer(Customer customer);

    public User findUserByAccount(String userAccount);
}
