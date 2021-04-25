package team.gym.Beans;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Component
@XmlRootElement(name = "trainer")
public class Trainer extends User{

    public Trainer(){
        super();
        setAccount(String.valueOf(new Random().nextInt()));
        setPassword("password");
        setName("name");
        setGender("gender");
        setLocation("location");
        setPhone("138");
        setEmail("email");
    }
}
