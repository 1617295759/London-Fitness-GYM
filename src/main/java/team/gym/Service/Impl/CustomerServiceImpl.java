package team.gym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.gym.Beans.Customer;
import team.gym.Beans.User;
import team.gym.Dao.CustomerDao;
import team.gym.Service.CustomerService;

import java.util.regex.Pattern;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public String verifyCustomer(String username, String password) {
        Customer verifycustomer = customerDao.findCustomerByAccount(username);
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
        return customerDao.findCustomerByAccount(username);
    }

    @Override
    public String registerCustomer(Customer customer) {
        /**
         * 正则表达式：验证用户名
         */
        String v_account = "^[a-zA-Z]\\w{5,17}$";

        /**
         * 正则表达式：验证密码
         */
        String v_password = "^[a-zA-Z0-9]{6,16}$";


        /**
         * 正则表达式：验证手机号
         */
        String v_phone = "^((13[0-9])|(15[^4,\\D])|(14[57])|(17[0])|(17[7])|(18[0,0-9]))\\d{8}$";

        /**
         * 正则表达式：验证邮箱
         */
        String v_email = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

        //还需要验证账户是否重复
        if(Pattern.matches(v_account, customer.getAccount()) == false)
            return "Please ensure your account has 5-17 letters without numbers";

        else if(Pattern.matches(v_password,customer.getPassword()) == false)
            return "Please ensure your account has 6-16 letters";

        else if(Pattern.matches(v_phone,customer.getPhone()) == false)
            return "Please input correct phone number";

        else if(Pattern.matches(v_email,customer.getEmail()) == false)
            return "Please input correct email address";

        else {
            customerDao.saveCustomer(customer);
            return null;
        }
    }

    @Override
    public int deleteCustomer(Customer customer) {
        return 0;
    }

    @Override
    public int modifyCustomerInfo(Customer customer, String field, String newValue) {
        customerDao.modifyCustomer(customer,field,newValue);
        return 0;
    }

}
