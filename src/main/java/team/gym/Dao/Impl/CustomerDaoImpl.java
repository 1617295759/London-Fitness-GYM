package team.gym.Dao.Impl;

import org.springframework.stereotype.Repository;
import team.gym.Beans.Course;
import team.gym.Beans.Customer;
import team.gym.Beans.CustomerWrapper;
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
public class CustomerDaoImpl implements CustomerDao {
    /*
            文件路径问题：java.io.FileNotFoundException:系统找不到指定的路径 ？？
            问题解决 ：路径中的中文或有空格路径处理，会用编码为 a3%20%e9%a1%b9% 等字符
            String xmlPath = URLDecoder.decode("/XMLdata/customers.xml","utf-8");

            URL xmlURL = getClass().getResource("/xmldata/customer.xml");
            resources文件夹下为静态资源，只适合存放配置等不改动的文件，持久化文件不应该放在那里
    */
    private final File customersfile;
    private CustomerWrapper wrapper;
    private JAXBContext context;

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
            wrapper = (CustomerWrapper) um.unmarshal(customersfile);
        } catch (JAXBException e) {
            System.out.println("此时customers.xml为空");
            e.printStackTrace();
            wrapper = new CustomerWrapper();
        }
    }


    @Override
    public void saveCustomer(Customer customer) {
        try{
            // read the original data and append the new customer information
            Map<String, Customer> map = getCustomerMap();
            map.put(customer.getAccount(),customer);
            //package the map to wrapper to transmute to XML
            wrapper.setCustomerMap(map);
            saveWrapper(wrapper);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public Customer findCustomerByAccount(String account) {
        //get the specific customer information
        return wrapper.getCustomerMap().get(account);
    }

    @Override
    public Map<String, Customer> getCustomerMap() {
        return wrapper.getCustomerMap();
    }

    @Override
    public int modifyCustomer(Customer customer, String field, String newValue) {
        Customer customer_data = findCustomerByAccount(customer.getAccount());
        switch (field) {
            case ("level"):
                customer_data.setLevel(newValue);
                break;
            case ("account"):
                customer_data.setAccount(newValue);
                break;
        }
        saveCustomer(customer_data);
        return 0;
    }

    @Override
    public int addCourse(String account, Course course) {
        return 0;
    }

    /** write the wrapper to customers.xml
     *
     * @param wrapper the wrapper to be saved
     */
    public void saveWrapper(CustomerWrapper wrapper){
        try {
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(wrapper, customersfile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
