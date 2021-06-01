package team.gym.Dao;

import team.gym.Beans.Course;
import team.gym.Beans.Customer;

import java.util.Map;

/**
 * operate the data Persistence in regard to Customer
 */
public interface CustomerDao {
    /** append a new customer information into the xml data
     *
     * @param customer the Object to be saved
     */
    public void saveCustomer(Customer customer);

    /** get the Customer object by the course account
     *
     * @param username the username number of the customer
     * @return the corresponding customer Object
     */
    public Customer findCustomerByAccount(String username);

    /**  all the cutomers
     *
     * @return all the cutomers map, the key is account number(String), value is customer Object
     */
    public Map getCustomerMap();

    int modifyCustomer(Customer customer, String field, String newValue);

    int addCourse(String account, Course course);
}
