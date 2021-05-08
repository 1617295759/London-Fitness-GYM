package team.gym.Dao.Impl;

import org.springframework.stereotype.Repository;
import team.gym.Beans.Customer;
import team.gym.Beans.CustomerWrapper;
import team.gym.Beans.User;
import team.gym.Beans.UserWrapper;
import team.gym.Dao.CustomerDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Repository
public class CustomerDaoImpl extends UserDaoImpl implements CustomerDao {
    /*
            文件路径问题：java.io.FileNotFoundException:系统找不到指定的路径 ？？
            问题解决 ：路径中的中文或有空格路径处理，会用编码为 a3%20%e9%a1%b9% 等字符
            String xmlPath = URLDecoder.decode("/XMLdata/customers.xml","utf-8");

            URL xmlURL = getClass().getResource("/xmldata/customer.xml");
            resources文件夹下为静态资源，只适合存放配置等不改动的文件，持久化文件不应该放在那里
    */

    public final File customersfile;

    public JAXBContext context;

    public CustomerWrapper customerWrapper;

    public CustomerDaoImpl() {
        // initiate File customersfile
        String xmlPath = URLDecoder.decode("XMLdata/customers.xml", StandardCharsets.UTF_8);
        customersfile = new File(xmlPath);
        try {
            // initiate JAXBContext context
            context = JAXBContext.newInstance(CustomerWrapper.class);
            // initiate CustomerWrapper wrapper
            Unmarshaller um = context.createUnmarshaller();
            // Reading XML from the file and unmarshalling.
            this.customerWrapper = (CustomerWrapper) um.unmarshal(customersfile);
        } catch (JAXBException e) {
            System.out.println("此时customers.xml为空");
            e.printStackTrace();
            customerWrapper = new CustomerWrapper();
        }
    }

    public void saveCustomer(Customer customer){
        try{
            // read the original data and append the new user information
            Map map = getCustomerMap();
            map.put(customer.getAccount(),customer);
            //package the map to wrapper to transmute to XML
            customerWrapper.setUserMap(map);
            saveWrapper(customerWrapper);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public User findUserByAccount(String userAccount) {
        return customerWrapper.getCustomerMap().get(userAccount);
    }

    @Override
    public int modifyUser(String account, String field, String newValue) {
        Customer customer = (Customer)findUserByAccount(account);
        switch (field) {
            case ("password"):
                customer.setPassword(newValue);
            case ("name"):
                customer.setName(newValue);
            case ("location"):
                customer.setLocation(newValue);
            case ("phone"):
                customer.setPhone(newValue);
        }
        saveCustomer(customer);
        return 1;
    }


    public Map getCustomerMap() { return customerWrapper.getCustomerMap();}


    /** write the wrapper to customers.xml
     */
    public void saveWrapper(CustomerWrapper customerWrapper){
        try {
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(customerWrapper, customersfile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
