package team.gym.Beans;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class User {
    private final StringProperty account = new SimpleStringProperty();
    private final StringProperty password= new SimpleStringProperty();
    private final StringProperty name= new SimpleStringProperty();
    private final StringProperty gender= new SimpleStringProperty();
    private final StringProperty location= new SimpleStringProperty();
    private final StringProperty phone= new SimpleStringProperty();
    private final StringProperty email= new SimpleStringProperty();

    private List<Course> courses = new LinkedList<Course>();


    public User(){

    }
    public User(String account, String password, String name, String gender, String location, String phone, String email) {
        setAccount(account);
        setPassword(password);
        setName(name);
        setGender(gender);
        setLocation(location);
        setPhone(phone);
        setEmail(email);
    }

    public String getAccount() {
        return account.get();
    }

    public StringProperty accountProperty() {
        return account;
    }

    public void setAccount(String account) {
        this.account.set(account);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "User{" +
                "accout=" + getAccount() +
                ", password=" + getPassword() +
                ", name=" + getName() +
                ", gender=" + getGender() +
                ", location=" + getLocation() +
                ", phone=" + getPhone() +
                ", email=" + getEmail() +
                '}';
    }

    public boolean isEmpty() {
        if(getName().equals(""))
            return true;
         return false;
    }
}
