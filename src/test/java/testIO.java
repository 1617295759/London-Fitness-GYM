import team.gym.Beans.Customer;
import org.junit.Test;
import team.gym.Beans.CustomerWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class testIO {
    @Test
    public void testLoad() throws JAXBException, IOException {
        CustomerWrapper wrapper = new CustomerWrapper();
        Map map = new HashMap<String,Customer>();

        JAXBContext context = JAXBContext
                .newInstance(CustomerWrapper.class);
        Unmarshaller um = context.createUnmarshaller();

        // Reading XML from the file and unmarshalling.
        wrapper = (CustomerWrapper) um.unmarshal(new File("XMLdata/customers.xml"));
        Map m = wrapper.getCustomerMap();
        System.out.println(m.keySet());
    }

    @Test
    public void testSave() throws JAXBException {
        CustomerWrapper wrapper = new CustomerWrapper();
        Map map = new HashMap<String,Customer>();
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        map.put(c1.getAccout(),c1);
        map.put(c2.getAccout(),c2);
        wrapper.setCustomerMap(map);

        JAXBContext context = JAXBContext.newInstance(CustomerWrapper.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(wrapper,new File("XMLdata/customers.xml"));
    }
}
