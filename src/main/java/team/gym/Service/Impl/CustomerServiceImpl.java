package team.gym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.gym.Beans.Customer;
import team.gym.Beans.User;
import team.gym.Dao.CustomerDao;
import team.gym.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public int verifyCustomer(String username, String password) {
        Customer verifycustomer = customerDao.getCustomer(username);
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
        return customerDao.getCustomer(username);
    }

    @Override
    public int registerCustomer(Customer customer) {
        return 0;
    }

    @Override
    public int deleteCustomer(Customer customer) {
        return 0;
    }
}
