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
        Customer verifycustomer = customerDao.findCustomerByName(username);
        if(verifycustomer == null ){
            return "User Not Found! Please Check Your ID";
        }else if(password == verifycustomer.getPassword()){
            return "1";
        }else{
            return "Wrong Password! Please Input Again";
        }
    }

    @Override
    public User getCustomer(String username, String password) {

        return customerDao.findCustomerByName(username);
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
