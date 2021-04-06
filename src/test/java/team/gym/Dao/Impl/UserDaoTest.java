package team.gym.Dao.Impl;

import junit.framework.TestCase;
import org.junit.Test;
import team.gym.Beans.Customer;
import team.gym.Dao.UserDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;


public class UserDaoTest extends TestCase {
    @Test
    public void testSaveCustomer() throws Exception {
        Customer customer = new Customer();
        new UserDaoImpl().saveCustomer(customer);

        File f = new File("XMLdata/customers.xml");
        System.out.println(f.getAbsoluteFile());
    }
}