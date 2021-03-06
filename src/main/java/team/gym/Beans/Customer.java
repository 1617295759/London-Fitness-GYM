package team.gym.Beans;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.springframework.stereotype.Component;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;



/**
 * Customer Entity
 */
@Component
@XmlRootElement(name = "customer")
public class Customer extends User{
    // different level of membership
    private final StringProperty  level = new SimpleStringProperty();
    public static final String NEWBIE =  "Newbie";
    public static final String JUNIOR =  "Junior";
    public static final String SENIOR =  "Senior";

    public Customer(){
        super();
        setAccount(String.valueOf(new Random().nextInt(94)));
        setPassword("ipassword");
        setName("iname");
        setGender("Male");
        setLocation("ilocation");
        setPhone("138");
        setEmail("iemail");
        setLevel("Newbie");
    }

    public String getLevel() {
        return level.get();
    }

    public StringProperty levelProperty() {
        return level;
    }

    public void setLevel(String level) {
        this.level.set(level);
    }

}
