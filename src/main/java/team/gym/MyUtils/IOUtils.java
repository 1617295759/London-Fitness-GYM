package team.gym.MyUtils;

import team.gym.Beans.Customer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class IOUtils {
    public static void loadCustomer(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(Customer.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            Customer custom = (Customer) um.unmarshal(new File("/src/file/customer.xml"));
        } catch (Exception e) {
            e.getMessage();// catches ANY exception
        }
    }
    public static void saveCustomer(Customer customer) {
        System.out.println("into saveCustomer");
        try {
            JAXBContext context = JAXBContext.newInstance(Customer.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            System.out.println("saveCustomer");
            // Marshalling and saving XML to the file.
            //m.marshal(customer, new File("/src/files/customer.xml"));
            m.marshal(customer, System.out);

        } catch (Exception e) { // catches ANY exception
            System.out.println("fail in saving the info");
            e.getMessage();
        }
    }
    public static final File getResources(String file) {
        if(IOUtils.class.getClassLoader().getResource(file)==null){
            return null;
        }
        return new File(IOUtils.class.getClassLoader().getResource(file).getPath());
    }
}
