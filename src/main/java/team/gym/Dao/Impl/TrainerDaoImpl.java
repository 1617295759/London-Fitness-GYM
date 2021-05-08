package team.gym.Dao.Impl;

import org.springframework.stereotype.Repository;
import team.gym.Beans.*;
import team.gym.Dao.TrainerDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Repository
public class TrainerDaoImpl extends UserDaoImpl implements TrainerDao {

    public final File trainersFile;

    public JAXBContext context;

    public TrainerWrapper trainerWrapper;

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
            this.trainerWrapper = (TrainerWrapper) um.unmarshal(trainersFile);
        } catch (JAXBException e) {
            System.out.println("此时trainers.xml为空");
            e.printStackTrace();
            trainerWrapper = new TrainerWrapper();
        }
    }


    public void saveWrapper(UserWrapper trainerWrapper) {
        try {
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(trainerWrapper, trainersFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Map getTrainerMap() { return trainerWrapper.getTrainerMap();}

    public void saveTrainer(Trainer trainer){
        try{
            // read the original data and append the new user information
            Map map = getTrainerMap();
            map.put(trainer.getAccount(),trainer);
            //package the map to wrapper to transmute to XML
            trainerWrapper.setUserMap(map);
            saveWrapper(trainerWrapper);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public User findUserByAccount(String userAccount) {
        return trainerWrapper.getTrainerMap().get(userAccount);
    }

    @Override
    public int modifyUser(String account, String field, String newValue) {
        Trainer trainer = (Trainer) findUserByAccount(account);
        switch (field){
            case ("password"):
                trainer.setPassword(newValue);
            case ("name"):
                trainer.setName(newValue);
            case ("location"):
                trainer.setLocation(newValue);
            case ("phone"):
                trainer.setPhone(newValue);
        }
        saveTrainer(trainer);
        return 1;
    }


}

