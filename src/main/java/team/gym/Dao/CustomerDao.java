package team.gym.Dao;

import team.gym.Beans.Course;
import team.gym.Beans.Customer;

import java.util.Map;

public interface CustomerDao {
    /** append a customer information into the xml data
     *
     * @param customer the Object to be saved
     */
    public void saveCustomer(Customer customer);

    /**
     * @param username the username number of the customer
     * @return the corresponding customer Object
     */
    public Customer findCustomerByAccount(String username);

    /**
     * @return all the cutomers map, the key is account number(String), value is customer Object
     */
    public Map getCustomerMap();

    int modifyCustomer(String account, String field, String newValue);

    int addCourse(String account, Course course);
}
