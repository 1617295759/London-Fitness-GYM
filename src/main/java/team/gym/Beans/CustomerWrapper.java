package team.gym.Beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "CustomerWrapper")
public class CustomerWrapper extends UserWrapper{

    private Map<String, Customer> customerMap;

    public CustomerWrapper(){
        customerMap = new HashMap<String, Customer>();
    }
    @XmlElementWrapper(name="customers")
    @XmlElement(name = "customer")
    public Map<String, Customer> getCustomerMap() { return customerMap; }

    public void setCustomerMap(Map<String, Customer> customerMap) { this.customerMap = customerMap; }
}
