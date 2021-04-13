package team.gym.Beans;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.LinkedList;
import java.util.List;

@Component
@XmlRootElement(name = "trainer")
public class Trainer extends User{
    // XmLElementWrapper generates a wrapper element around XML representation
    @XmlElementWrapper(name = "CourseList")
    // XmlElement sets the name of the entities
    @XmlElement(name = "course")
    private List<Course> courses = new LinkedList<Course>();
    public Trainer(){
        super();
        setAccount("accout");
        setPassword("password");
        setName("name");
        setGender("gender");
        setLocation("location");
        setPhone("138");
        setEmail("email");
    }

    @XmlTransient
    public List<Course> getCourses() { return courses; }

    public void setCourses(List<Course> courses) { this.courses = courses; }
}
