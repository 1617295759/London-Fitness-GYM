package team.gym.Beans;
import org.springframework.stereotype.Component;
import javax.xml.bind.annotation.XmlRootElement;

@Component
@XmlRootElement(name = "trainer")
public class Trainer extends User{

    public Trainer(){
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
