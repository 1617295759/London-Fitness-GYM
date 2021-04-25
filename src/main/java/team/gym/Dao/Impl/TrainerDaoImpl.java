package team.gym.Dao.Impl;

import org.springframework.stereotype.Repository;
import team.gym.Beans.Course;
import team.gym.Beans.Trainer;
import team.gym.Beans.TrainerWrapper;
import team.gym.Beans.User;
import team.gym.Dao.TrainerDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Repository
public class TrainerDaoImpl implements TrainerDao{

    public final File trainersFile;
    private TrainerWrapper wrapper;
    private JAXBContext context;

    public TrainerDaoImpl() {
        // initiate File trainers' file
        String xmlPath = URLDecoder.decode("XMLdata/trainers.xml", StandardCharsets.UTF_8);
        trainersFile = new File(xmlPath);
        try {
            // initiate JAXBContext context
            context = JAXBContext.newInstance(TrainerWrapper.class);
            // initiate TrainerWrapper wrapper
            Unmarshaller um = context.createUnmarshaller();
            // Reading XML from the file and unmarshalling.
            wrapper = (TrainerWrapper) um.unmarshal(trainersFile);
        } catch (JAXBException e) {
            System.out.println("此时trainers.xml为空");
            e.printStackTrace();
            wrapper = new TrainerWrapper();
        }
    }


    @Override
    public void saveTrainer(Trainer trainer) {
        UserDaoImpl.saveUser(trainer);
    }

    @Override
    public Map getTrainerMap() {
        return UserDaoImpl.getUserMap();
    }

    @Override
    public int modifyTrainer(String account, String field, String newValue) {
        return UserDaoImpl.modifyUser(account, field, newValue);
    }

    @Override
    public int addTrainerCourse(String account, Course course) {
        return UserDaoImpl.addCourse(account, course);
    }

    @Override
    public User findTrainerByAccount(String trainerAccount) {
        return UserDaoImpl.findUserByAccount(trainerAccount);
    }

    public void saveWrapper(TrainerWrapper wrapper) {
        UserDaoImpl.saveWrapper(wrapper);
    }

}
