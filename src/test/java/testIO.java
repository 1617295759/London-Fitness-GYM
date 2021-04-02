import team.gym.Beans.Customer;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;

public class testIO {
    @Test
    public void testIO() throws JAXBException, IOException {
        Customer customer = new Customer();
        JAXBContext context = JAXBContext.newInstance(Customer.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //文件路径问题：java.io.FileNotFoundException:系统找不到指定的路径 ？？
        //问题解决 ：路径中的中文或有空格路径处理，会用编码为 a3%20%e9%a1%b9% 等字符
        URL xmlURL = getClass().getResource("/xmldata/customer.xml");
        String xmlPath = URLDecoder.decode(xmlURL.getPath(),"utf-8");
        File f = new File(xmlPath);
        //m.marshal(customer, f);
        StringWriter writer = new StringWriter();
        m.marshal(customer, writer);

        System.out.println(f.getAbsoluteFile());
        System.out.println(f.getPath());

        BufferedWriter bfw = new BufferedWriter(new FileWriter(f));
        bfw.write(writer.toString());
        bfw.close();

        System.out.println(writer.toString());
        System.out.println("over");
    }
}
