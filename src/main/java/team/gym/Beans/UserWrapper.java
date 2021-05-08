package team.gym.Beans;

import java.util.HashMap;
import java.util.Map;

public class  UserWrapper {

    private Map<String, User> userMap;

    public UserWrapper() {
        userMap = new HashMap<String, User>();
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, Customer> customerMap) {
        this.userMap = userMap;
    }
}