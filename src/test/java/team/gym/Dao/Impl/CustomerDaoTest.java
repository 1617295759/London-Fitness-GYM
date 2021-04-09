package team.gym.Dao.Impl;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import team.gym.Beans.Course;
import team.gym.Beans.Customer;
import team.gym.MainApp;

import java.util.LinkedList;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {MainApp.class})

public class CustomerDaoTest extends TestCase {

    @Test
    public void testSaveCustomer() throws Exception {
        Customer customer = new Customer();
        List list = customer.getCourses();
        list.add(new Course());
        customer.setCourses(list);
        new CustomerDaoImpl().saveCustomer(customer);
    }
    @Test
    public void testGetCustomer() {
        System.out.println(new CustomerDaoImpl().getCustomer("23"));
    }
    @Test
    public void testGetCustomerMap() {
        CustomerDaoImpl dao = new CustomerDaoImpl();
        System.out.println(dao.getCustomerMap().keySet());
    }
}