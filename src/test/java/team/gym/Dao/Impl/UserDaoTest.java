package team.gym.Dao.Impl;

import junit.framework.TestCase;
import org.junit.Test;
import team.gym.Beans.Customer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


public class UserDaoTest extends TestCase {
    @Test
    public void testSaveCustomer() throws Exception {
        Customer customer = new Customer();
        new UserDaoImpl().saveCustomer(customer);
    }
}