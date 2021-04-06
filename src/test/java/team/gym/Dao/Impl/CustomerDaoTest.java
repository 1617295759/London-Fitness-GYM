package team.gym.Dao.Impl;

import junit.framework.TestCase;
import org.junit.Test;
import team.gym.Beans.Customer;

import java.io.File;


public class CustomerDaoTest extends TestCase {
    @Test
    public void testSaveCustomer() throws Exception {
        Customer customer = new Customer();
        new CustomerDaoImpl().saveCustomer(customer);

        File f = new File("XMLdata/customers.xml");
        System.out.println(f.getAbsoluteFile());
    }
}