package team.gym.Dao.Impl;

import org.springframework.stereotype.Repository;
import team.gym.Beans.CustomerWrapper;
import team.gym.Beans.UserWrapper;
import team.gym.Dao.CustomerDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Repository
public class CustomerDaoImpl extends UserDaoImpl implements CustomerDao {
    /*
            文件路径问题：java.io.FileNotFoundException:系统找不到指定的路径 ？？
            问题解决 ：路径中的中文或有空格路径处理，会用编码为 a3%20%e9%a1%b9% 等字符
            String xmlPath = URLDecoder.decode("/XMLdata/customers.xml","utf-8");

            URL xmlURL = getClass().getResource("/xmldata/customer.xml");
            resources文件夹下为静态资源，只适合存放配置等不改动的文件，持久化文件不应该放在那里
    */
    private final File customersfile;
    private JAXBContext context;

    public CustomerDaoImpl() {
        // initiate File customersfile
        String xmlPath = URLDecoder.decode("XMLdata/customers.xml", StandardCharsets.UTF_8);
        customersfile = new File(xmlPath);
        CustomerWrapper customerWrapper;
        try {
            // initiate JAXBContext context
            context = JAXBContext.newInstance(CustomerWrapper.class);
            // initiate CustomerWrapper wrapper
            Unmarshaller um = context.createUnmarshaller();
            // Reading XML from the file and unmarshalling.
            customerWrapper = (CustomerWrapper) um.unmarshal(customersfile);
        } catch (JAXBException e) {
            System.out.println("此时customers.xml为空");
            e.printStackTrace();
            customerWrapper = new CustomerWrapper();
        }
    }

    /** write the wrapper to customers.xml
     *
     * @param customerWrapper the wrapper to be saved
     */
    public void saveWrapper(UserWrapper customerWrapper){
        try {
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(wrapper, customersfile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
