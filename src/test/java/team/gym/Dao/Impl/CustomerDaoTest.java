package team.gym.Dao.Impl;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import team.gym.Beans.Customer;
import team.gym.MainApp;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {MainApp.class})

public class CustomerDaoTest extends TestCase {

    @Test
    public void testSaveCustomer() throws Exception {
        Customer customer = new Customer();
        new CustomerDaoImpl().saveCustomer(customer);
    }
    @Test
    public void testGetCustomer() {
        System.out.println(new CustomerDaoImpl().getCustomer("abc"));
    }
    @Test
    public void testGetCustomerMap() {
        CustomerDaoImpl dao = new CustomerDaoImpl();
        System.out.println(dao.customersfile);
        System.out.println(dao.getCustomerMap().keySet());
    }
}