package team.gym.Dao.Impl;

import team.gym.Beans.Course;
import team.gym.Beans.User;
import team.gym.Beans.UserWrapper;
import team.gym.Dao.UserDao;

import javax.xml.bind.JAXBContext;
import java.util.Map;

public abstract class UserDaoImpl implements UserDao{

    public String fileName;

    public JAXBContext context;

    public UserWrapper wrapper;

    public CourseDaoImpl courseDaoImpl;


    @Override
    public void saveUser(User user){
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
    public User findUserByAccount(String userAccount) {
        return wrapper.getUserMap().get(userAccount);
    }

    @Override
    public Map getUserMap() { return wrapper.getUserMap();}

    @Override
    public int modifyUser(String account, String field, String newValue){
        User user = findUserByAccount(account);
        switch (field){
            case("password"):
                user.setPassword(newValue);
            case("name"):
                user.setName(newValue);
            case("location"):
                user.setLocation(newValue);
            case("phone"):
                user.setPhone(newValue);
        }
        saveUser(user);
        return 1;
    }

    @Override
    public void addCourse(Course course){
        courseDaoImpl.saveCourse(course);
    }

    @Override
    public abstract void saveWrapper(UserWrapper userWrapper);
}
