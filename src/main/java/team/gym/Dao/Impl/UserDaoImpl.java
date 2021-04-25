package team.gym.Dao.Impl;

import team.gym.Beans.Course;
import team.gym.Beans.User;
import team.gym.Beans.UserWrapper;
import team.gym.Dao.UserDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class UserDaoImpl implements UserDao{

    public String fileName;

    public final File usersFile;

    public JAXBContext context;

    public UserWrapper wrapper;

    public UserDaoImpl(){
        // initiate File users' file
        assert false;
        String xmlPath = URLDecoder.decode(fileName, StandardCharsets.UTF_8);
        usersFile = new File(xmlPath);
        try {
            // initiate JAXBContext context
            context = JAXBContext.newInstance(UserWrapper.class);
            // initiate CustomerWrapper wrapper
            Unmarshaller um = context.createUnmarshaller();
            // Reading XML from the file and unmarshalling.
            wrapper = (UserWrapper) um.unmarshal(usersFile);
        } catch (JAXBException e) {
            System.out.println("此时" + fileName + "为空");
            e.printStackTrace();
            wrapper = new UserWrapper();
        }
    }

    @Override
    public static void saveUser(User user) {
        try{
            // read the original data and append the new user information
            Map map = getUserMap();
            map.put(user.getAccount(),user);
            //package the map to wrapper to transmute to XML
            wrapper.setUserMap(map);
            saveWrapper(wrapper);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public static User findUserByAccount(String userAccount) {
        return wrapper.getUserMap().get(userAccount);
    }

    @Override
    public static Map getUserMap() {
        return null;
    }

    @Override
    public static int modifyUser(String account, String field, String newValue) {
        return 0;
    }

    @Override
    public static int addCourse(String account, Course course) {
        return 0;
    }

    @Override
    public static void saveWrapper(UserWrapper userWrapper) {
        try {
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(wrapper, usersFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
