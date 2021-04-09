package team.gym.Beans;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.springframework.stereotype.Component;

@Component
public class User {
    private final StringProperty accout= new SimpleStringProperty();
    private final StringProperty password= new SimpleStringProperty();
    private final StringProperty name= new SimpleStringProperty();
    private final StringProperty gender= new SimpleStringProperty();
    private final StringProperty location= new SimpleStringProperty();
    private final StringProperty phone= new SimpleStringProperty();
    private final StringProperty email= new SimpleStringProperty();

    public User(){

    }
    public User(String accout, String password, String name, String gender, String location, String phone, String email) {
        setAccout(accout);
        setPassword(password);
        setName(name);
        setGender(gender);
        setLocation(location);
        setPhone(phone);
        setEmail(email);
    }

    public String getAccout() {
        return accout.get();
    }

    public StringProperty accoutProperty() {
        return accout;
    }

    public void setAccout(String accout) {
        this.accout.set(accout);
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

    @Override
    public String toString() {
        return "User{" +
                "accout=" + getAccout() +
                ", password=" + getPassword() +
                ", name=" + getName() +
                ", gender=" + getGender() +
                ", location=" + getLocation() +
                ", phone=" + getPhone() +
                ", email=" + getEmail() +
                '}';
    }
}
