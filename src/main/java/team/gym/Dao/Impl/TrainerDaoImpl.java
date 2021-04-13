package team.gym.Dao.Impl;


import org.springframework.stereotype.Repository;
import team.gym.Beans.Trainer;
import team.gym.Beans.TrainerWrapper;
import team.gym.Dao.TrainerDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

@Repository
public class TrainerDaoImpl implements TrainerDao{

    private File trainersfile;
    private TrainerWrapper wrapper;
    private JAXBContext context;

    public TrainerDaoImpl() {
        // initiate File customersfile
        try {
            String xmlPath = URLDecoder.decode("XMLdata/trainers.xml","utf-8");
            trainersfile = new File(xmlPath);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            // initiate JAXBContext context
            context = JAXBContext.newInstance(TrainerWrapper.class);
            // initiate CustomerWrapper wrapper
            Unmarshaller um = context.createUnmarshaller();
            // Reading XML from the file and unmarshalling.
            wrapper = (TrainerWrapper) um.unmarshal(trainersfile);
        } catch (JAXBException e) {
            System.out.println("此时trainers.xml为空");
            e.printStackTrace();
            wrapper = new TrainerWrapper();
        }
    }


    @Override
    public void saveTrainer(Trainer trainer) {
        try{
            // read the original data and append the new customer information
            Map map = getTrainerMap();
            map.put(trainer.getAccount(),trainer);
            //package the map to wrapper to transmute to XML
            wrapper.setTrainerMap(map);
            saveWrapper(wrapper);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Map getTrainerMap() {
        return wrapper.getTrainerMap();
    }

    @Override
    public Trainer findTrainerByName(String username) {
        Trainer trainer = wrapper.getTrainerMap().get(username);
        return trainer;
    }

    public void saveWrapper(TrainerWrapper wrapper){
        try {
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(wrapper, trainersfile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
