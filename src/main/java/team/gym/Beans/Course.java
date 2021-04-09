package team.gym.Beans;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Course {
    private final StringProperty customer_account = new SimpleStringProperty();
    private final StringProperty trainer_account = new SimpleStringProperty();
    private final StringProperty type = new SimpleStringProperty();
    private final StringProperty intro = new SimpleStringProperty();
    private StringProperty date = new SimpleStringProperty();

    public Course(){
        setCustomer_account("Tom");
        setTrainer_account("Old jack");
    }

    public String getCustomer_account() {
        return customer_account.get();
    }

    public StringProperty customer_accountProperty() { return customer_account; }

    public void setCustomer_account(String customer_account) {
        this.customer_account.set(customer_account);
    }

    public String getTrainer_account() {
        return trainer_account.get();
    }

    public StringProperty trainer_accountProperty() {
        return trainer_account;
    }

    public void setTrainer_account(String trainer_account) {
        this.trainer_account.set(trainer_account);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getIntro() {
        return intro.get();
    }

    public StringProperty introProperty() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro.set(intro);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
