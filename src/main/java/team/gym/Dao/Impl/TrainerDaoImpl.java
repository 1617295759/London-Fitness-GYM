package team.gym.Dao.Impl;


import org.springframework.stereotype.Repository;
import team.gym.Beans.Course;
import team.gym.Beans.Trainer;
import team.gym.Beans.TrainerWrapper;
import team.gym.Dao.TrainerDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
/**
 * do the operation in regard to trainers
 */
@Repository
public class TrainerDaoImpl implements TrainerDao{

    private File trainersfile;
    private TrainerWrapper wrapper;
    private JAXBContext context;

    public TrainerDaoImpl() {
        loadData();
    }

    public void loadData(){
        // initiate File trainers file
        String xmlPath = URLDecoder.decode("XMLdata/trainers.xml", StandardCharsets.UTF_8);
        trainersfile = new File(xmlPath);
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
            Map<String,Trainer> map = getTrainerMap();
            map.put(trainer.getAccount(),trainer);
            //package the map to wrapper to transmute to XML
            wrapper.setTrainerMap(map);
            saveWrapper(wrapper);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Map<String,Trainer> getTrainerMap() {
        return wrapper.getTrainerMap();
    }

    @Override
    public int modifyTrainer(String account, String field, String newValue) {
        return 0;
    }

    @Override
    public Trainer findTrainerByAccount(String username) {
        return wrapper.getTrainerMap().get(username);
    }

    /** write the wrapper to trainers.xml
     *
     * @param wrapper the wrapper to be saved
     */
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
