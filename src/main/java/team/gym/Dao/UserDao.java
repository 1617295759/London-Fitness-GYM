package team.gym.Dao;

import team.gym.Beans.Customer;
import java.util.Map;

public interface UserDao {
    public void saveCustomer(Customer customer);
    public Map getCustomerMap(String username);
}
