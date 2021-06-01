package team.gym.Service.Impl;

import junit.framework.TestCase;
import team.gym.Beans.Customer;

public class CustomerServiceImplTest extends TestCase {


    public void testRegisterCustomer() {
        Customer ct = new Customer();
        ct.setAccount("sauhdiu");
        ct.setGender("ff");
        ct.setPhone("18903806006");
        ct.setEmail("2018213054@bupt.edu.cn");
        System.out.println(new CustomerServiceImpl().registerCustomer(ct));
    }

}