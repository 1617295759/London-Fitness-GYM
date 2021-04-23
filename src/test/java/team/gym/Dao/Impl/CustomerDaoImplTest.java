package team.gym.Dao.Impl;

import junit.framework.TestCase;
import team.gym.Beans.Course;
import team.gym.Beans.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImplTest extends TestCase {

    public void testSaveCustomer() {
        Customer customer = new Customer();
        List<Course> list = new ArrayList<Course>();
        list.add(new Course());
        list.add(new Course());
        customer.setCourses(list);
        new CustomerDaoImpl().saveCustomer(customer);
    }

    public void testFindCustomerByName() {
    }

    public void testGetCustomerMap() {
    }

    public void testModifyCustomer() {
    }

    public void testAddCourse() {

    }
}