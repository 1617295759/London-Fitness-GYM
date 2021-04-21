import team.gym.Beans.Course;
import org.junit.Test;
import team.gym.Beans.CustomerWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class testIO {
    @Test
    public void testLoad() throws JAXBException, IOException {
        CustomerWrapper wrapper = new CustomerWrapper();
        Map map = new HashMap<String, Course>();

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
        Map map = new HashMap<String, Course>();
        Course c1 = new Course();
        Course c2 = new Course();
        map.put(c1.getCourseId(),c1);
        map.put(c2.getCourseId(),c2);
        wrapper.setCustomerMap(map);

        JAXBContext context = JAXBContext.newInstance(CustomerWrapper.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(wrapper,new File("XMLdata/customers.xml"));
    }
}
