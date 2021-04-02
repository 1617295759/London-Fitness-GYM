package team.gym.Dao.Impl;

import org.springframework.stereotype.Repository;
import team.gym.Beans.Customer;
import team.gym.Dao.UserDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveCustomer(Customer customer) {
        try{
            JAXBContext context = JAXBContext.newInstance(Customer.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //文件路径问题：java.io.FileNotFoundException:系统找不到指定的路径 ？？
            //问题解决 ：路径中的中文或有空格路径处理，会用编码为 a3%20%e9%a1%b9% 等字符
            URL xmlURL = getClass().getResource("/xmldata/customer.xml");
            String xmlPath = URLDecoder.decode(xmlURL.getPath(),"utf-8");
            m.marshal(customer, new File(xmlPath));
            System.out.println("over");
        }catch(Exception e){
            System.out.println(e.getMessage());;
        }
    }

    @Override
    public Map getCustomerMap(String username) {
        return null;
    }
}
