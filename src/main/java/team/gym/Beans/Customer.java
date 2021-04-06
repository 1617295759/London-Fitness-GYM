package team.gym.Beans;

import org.springframework.stereotype.Component;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Random;

@Component
@XmlRootElement(name = "customer")
public class Customer extends User{
    public Customer(){
        super();
        setAccout(String.valueOf(new Random().nextInt(94)));
        setPassword("password");
        setName("name");
        setGender("gender");
        setLocation("location");
        setPhone("138");
        setEmail("email");
    }
}
