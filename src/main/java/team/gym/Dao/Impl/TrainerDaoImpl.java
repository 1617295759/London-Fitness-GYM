package team.gym.Dao.Impl;


import org.springframework.stereotype.Repository;
import team.gym.Beans.Customer;
import team.gym.Beans.CustomerWrapper;
import team.gym.Beans.Trainer;
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


public class TrainerDaoImpl<TrainerWrapper> implements TrainerDao{

    public int saveTrainer(Trainer trainer){ return 0;}

    @Override
    public Trainer findTrainerByName(String username) {
        return null;
    }

    private File trainersfile;
    private TrainerWrapper wrapper;
    private JAXBContext context;

    public TrainerDaoImpl() {
        // initiate File customersfile
        try {
            String xmlPath = URLDecoder.decode("XMLdata/customers.xml","utf-8");
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
            System.out.println("此时xml为空");
            e.printStackTrace();
            wrapper = new TrainerWrapper();
        }
    }


    @Override
    public void saveCustomer(Trainer trainer) {
        try{
            // read the original data and append the new customer information
            Map map = getTrainerMap();
            map.put(trainer.getAccout(),trainer);
            //package the map to wrapper to transmute to XML
            wrapper.setTrainerMap(map);
            saveWrapper(wrapper);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public Customer findCustomerByName(String username) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Map getTrainerMap() {
        return wrapper.getTrainerMap();
    }

    /** write the wrapper to customers.xml
     *
     * @param wrapper
     */
    public void saveWrapper(CustomerWrapper wrapper){
        try {
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(wrapper, customersfile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
