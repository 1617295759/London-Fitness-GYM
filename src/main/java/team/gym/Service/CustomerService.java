package team.gym.Service;

import team.gym.Beans.Customer;
import team.gym.Beans.User;

public interface CustomerService {
    /**check the information is right or not
     *
     * @param username the information user typed in the account area.
     * @param password the information user typed in the password area.
     * @return user's state 0-null account information, 1-match, 2-password wrong
     */
    public int verifyCustomer(String username, String password);

    /** get the customer Object according to the account
     *
     * @param username
     * @param password
     * @return
     */
    public User getCustomer(String username, String password);

    public int registerCustomer(Customer customer);

    public int deleteCustomer(Customer customer);

}
