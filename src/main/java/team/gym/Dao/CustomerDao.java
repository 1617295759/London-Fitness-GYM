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
    void saveCustomer(Customer customer);

    /** get the Customer object by the course account
     *
     * @param username the username number of the customer
     * @return the corresponding customer Object
     */
    Customer findCustomerByAccount(String username);

    /** get all the cutomers Map
     *
     * @return all the cutomers map, the key is account number(String), value is customer Object
     */
    Map getCustomerMap();

    /** modify the specific field in the Customer Object and save it in Persistence layer
     *
     * @param customer the customer information to be modified
     * @param field the specific field that you want to modify
     * @param newValue  new value
     * @return operation status
     */
    int modifyCustomer(Customer customer, String field, String newValue);

    void loadData();
}
