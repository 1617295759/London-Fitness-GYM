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

@Component
@XmlRootElement(name = "customer")

/**
 * 会员实体类
 */

public class Customer extends User{
    // different level of membership
    // Newbie —— Registered —— Advanced —— Respectful —— VIP —— Honorable
    private final StringProperty  level = new SimpleStringProperty();

    public Customer(){
        super();
        setAccount(String.valueOf(new Random().nextInt(94)));
        setPassword("ipassword");
        setName("iname");
        setGender("it");
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
