package team.gym.Beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "CustomerWrapper")
public class TrainerWrapper {
    private Map<String,Trainer> trainerMap;

    public TrainerWrapper(){
        trainerMap = new HashMap<String,Trainer>();
    }
    @XmlElementWrapper(name="trainers")
    @XmlElement(name = "trainer")
    public Map<String, Trainer> getTrainerMap() { return trainerMap; }

    public void setTrainerMap(Map<String, Trainer> trainerMap) { this.trainerMap = trainerMap; }
}
