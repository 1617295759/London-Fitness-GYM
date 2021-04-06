package team.gym.Dao.Impl;

import org.springframework.stereotype.Repository;
import team.gym.Beans.Customer;
import team.gym.Beans.CustomerWrapper;
import team.gym.Dao.CustomerDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
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

    @Override
    public void saveCustomer(Customer customer) {
        try{
            // read the original data and append the new customer information
            Map map = getCustomerMap();
            map.put(customer.getAccout(),customer);
            //package the map to wrapper to transmute to XML
            CustomerWrapper wrapper = new CustomerWrapper();
            wrapper.setCustomerMap(map);
            //write the wrapper to XML
            JAXBContext context = JAXBContext.newInstance(CustomerWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            String xmlPath = URLDecoder.decode("XMLdata/customers.xml","utf-8");
            m.marshal(wrapper, new File(xmlPath));
        }catch(Exception e){
            System.out.println(e.getMessage());;
        }
    }

    @Override
    public Customer getCustomer(String accout) {
        Customer customer = new Customer();
        try {
            JAXBContext context = JAXBContext
                    .newInstance(CustomerWrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            // Reading XML from the file and unmarshalling.
            CustomerWrapper wrapper = (CustomerWrapper) um.unmarshal(new File("XMLdata/customers.xml"));
            //get the specific customer information
            customer = wrapper.getCustomerMap().get(accout);

        } catch (Exception e) {
            System.out.println(e.getMessage());;// catches ANY exception
        }
        return customer;
    }

    @Override
    public Map getCustomerMap() {
        Map map = new HashMap();
        try{
            JAXBContext context = JAXBContext
                    .newInstance(CustomerWrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            // Reading XML from the file and unmarshalling.
            CustomerWrapper wrapper = (CustomerWrapper) um.unmarshal(new File("XMLdata/customers.xml"));
            map = wrapper.getCustomerMap();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return map;
    }

}
