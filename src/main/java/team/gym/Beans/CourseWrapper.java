package team.gym.Beans;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "CourseWrapper")
public class CourseWrapper {
    private Map<String, Course> courseMap;

    public CourseWrapper(){
        courseMap = new HashMap<String, Course>();
    }
    @XmlElementWrapper(name="courses")
    @XmlElement(name = "course")
    public Map<String, Course> getCourseMap() { return courseMap; }

    public void setCourseMap(Map<String, Course> customerMap) { this.courseMap = courseMap; }

}
