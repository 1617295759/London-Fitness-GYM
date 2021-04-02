package team.gym.Beans;

import org.springframework.stereotype.Component;
import javax.xml.bind.annotation.XmlRootElement;

@Component
@XmlRootElement(name = "customer")
public class Customer extends User{
    public Customer(){
        super();
        setAccout("accout");
        setPassword("password");
        setName("name");
        setGender("gender");
        setLocation("location");
        setPhone("138");
        setEmail("email");
    }
}
