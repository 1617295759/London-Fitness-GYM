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

    public TrainerDaoImpl() {
        // initiate File trainers' file
        String xmlPath = URLDecoder.decode("XMLdata/trainers.xml", StandardCharsets.UTF_8);
        trainersFile = new File(xmlPath);
        TrainerWrapper trainerWrapper;
        try {
            // initiate JAXBContext context
            context = JAXBContext.newInstance(TrainerWrapper.class);
            // initiate TrainerWrapper wrapper
            Unmarshaller um = context.createUnmarshaller();
            // Reading XML from the file and unmarshalling.
            trainerWrapper = (TrainerWrapper) um.unmarshal(trainersFile);
        } catch (JAXBException e) {
            System.out.println("此时trainers.xml为空");
            e.printStackTrace();
            trainerWrapper = new TrainerWrapper();
        }
    }


    @Override
    public void saveWrapper(UserWrapper wrapper) {
        try {
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(wrapper, trainersFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}

