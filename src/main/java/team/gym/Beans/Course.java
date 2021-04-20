package team.gym.Beans;


import javafx.beans.property.*;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Course {
    private final StringProperty courseId = new SimpleStringProperty();
    private final StringProperty customerAccount = new SimpleStringProperty();
    private final StringProperty trainerAccount = new SimpleStringProperty();
    private final StringProperty category = new SimpleStringProperty();
    private final StringProperty intro = new SimpleStringProperty();
    private StringProperty startTime = new SimpleStringProperty();
    private StringProperty endTime = new SimpleStringProperty();
    private final StringProperty feedback = new SimpleStringProperty();
    // 0-committed but not yet accepted，1-reject，2-accept
    private final StringProperty status = new SimpleStringProperty();
    private final DoubleProperty price = new SimpleDoubleProperty();

    public Course(){
        setCourseId(String.valueOf(new Random().nextInt()));
        setCustomerAccount("Tom");
        setTrainerAccount("Old jack");
    }

    public Course(String customerAccount, String trainerAccount, String startTime, String endTime){
        setCustomerAccount(customerAccount);
        setTrainerAccount(trainerAccount);
        setStartTime(startTime);
        setEndTime(endTime);
    }

    public String getCourseId() {
        return courseId.get();
    }

    public StringProperty courseIdProperty() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId.set(courseId);
    }

    public String getCustomerAccount() {
        return customerAccount.get();
    }

    public StringProperty customerAccountProperty() {
        return customerAccount;
    }

    public void setCustomerAccount(String customerAccount) {
        this.customerAccount.set(customerAccount);
    }

    public String getTrainerAccount() {
        return trainerAccount.get();
    }

    public StringProperty trainerAccountProperty() {
        return trainerAccount;
    }

    public void setTrainerAccount(String trainerAccount) {
        this.trainerAccount.set(trainerAccount);
    }

    public String getCategory() {
        return category.get();
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
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

    public String getStartTime() {
        return startTime.get();
    }

    public StringProperty startTimeProperty() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime.set(startTime);
    }

    public String getEndTime() {
        return endTime.get();
    }

    public StringProperty endTimeProperty() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime.set(endTime);
    }

    public String getFeedback() {
        return feedback.get();
    }

    public StringProperty feedbackProperty() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback.set(feedback);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }
}