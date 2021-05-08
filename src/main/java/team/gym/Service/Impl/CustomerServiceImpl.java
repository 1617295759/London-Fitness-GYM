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
    public String verifyCustomer(String username, String password) {
        Customer verifycustomer = (Customer)customerDao.findUserByAccount(username);
        if(verifycustomer == null ){
            return "Customer Account Doesn't Exist";
        }else if(password.equals(verifycustomer.getPassword())){
            return null;
        }else{
            return "Wrong password, Type Again Please";
        }
    }

    @Override
    public User getCustomer(String username, String password) {
        return customerDao.findUserByAccount(username);
    }

    @Override
    public String registerCustomer(Customer customer) {
        return "registered over";
    }

    @Override
    public int deleteCustomer(Customer customer) {
        return 0;
    }



}
