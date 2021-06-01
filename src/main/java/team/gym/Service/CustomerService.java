package team.gym.Service;

import team.gym.Beans.Course;
import team.gym.Beans.Customer;
import team.gym.Beans.User;
/**
 * realize the functions in regard to Customers
 */
public interface CustomerService {
    /**check the information is right or not
     *
     * @param username the information user typed in the account area.
     * @param password the information user typed in the password area.
     * @return user's state 0-null account information, 1-match, 2-password wrong
     */
    public String verifyCustomer(String username, String password);

    /** get the customer Object according to the account
     *
     * @param username customer account
     * @param password customer password
     * @return If the customer exists, return the customer object; If not, null will be returned.
     */
    public User getCustomer(String username, String password);

    /** Verify whether the customer registration information meets the requirements, and return an error message;
     * Save the information if there are no errors
     *
     * @param customer the customer object carrying the register information from front end.
     * @return If Registration information does not comply with the rules,
     * the concrete hint will be returned; If nothing wrong, null will be returned.
     */
    public String registerCustomer(Customer customer);

    /** modify the specific field in the Customer Object and save it in Persistence layer
     *
     * @param customer the customer information to be modified
     * @param field the specific field that you want to modify
     * @param newValue  new value
     * @return operation status
     */
    int modifyCustomerInfo(Customer customer, String field, String newValue);
}
