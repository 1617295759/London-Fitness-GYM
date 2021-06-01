package team.gym.Beans;


import javafx.beans.property.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *  Course Entity
 */
@Component
public class Course {
    // status
    public static final int COMMITTED =  0;
    public static final int REJECTED =  1;
    public static final int ACCEPTED =  2;
    public static final int FINISHED =  3;
    public static final int MISS =  4;
    public static final int MAXGAP = 60000000;


    private final IntegerProperty courseId = new SimpleIntegerProperty();
    private final StringProperty customerAccount = new SimpleStringProperty();
    private final StringProperty trainerAccount = new SimpleStringProperty();
    private final StringProperty category = new SimpleStringProperty();
    private final StringProperty intro = new SimpleStringProperty();
    private Date startDate = new Date();
    private StringProperty time = new SimpleStringProperty();
    private IntegerProperty duration = new SimpleIntegerProperty();
    private final StringProperty feedback = new SimpleStringProperty();
    private int status;
    private final DoubleProperty price = new SimpleDoubleProperty();

    public Course () {
        //setCourseId(new Random().nextInt());
        setStatus(0);
        setCustomerAccount("Tom");
        setTrainerAccount("Old jack");
        setStartDate(new Date());
    }


    public Course (String customerAccount, String trainerAccount, Date startDate, int endTime) {
        setCustomerAccount(customerAccount);
        setTrainerAccount(trainerAccount);
        setStartDate(startDate);
        setDuration(endTime);
    }

    public int getCourseId () {
        return courseId.get();
    }

    public IntegerProperty courseIdProperty () {
        return courseId;
    }

    public void setCourseId (int courseId) {
        this.courseId.set(courseId);
    }

    public void generateId(){
        SimpleDateFormat format = new SimpleDateFormat("MMdd");
        String id = format.format(getStartDate()) + new Random().nextInt(1000);
        setCourseId(Integer.parseInt(id));
    }

    public String getCustomerAccount () {
        return customerAccount.get();
    }

    public StringProperty customerAccountProperty () {
        return customerAccount;
    }

    public void setCustomerAccount (String customerAccount) {
        this.customerAccount.set(customerAccount);
    }

    public String getTrainerAccount () {
        return trainerAccount.get();
    }

    public StringProperty trainerAccountProperty () {
        return trainerAccount;
    }

    public void setTrainerAccount (String trainerAccount) {
        this.trainerAccount.set(trainerAccount);
    }

    public String getCategory () {
        return category.get();
    }

    public StringProperty categoryProperty () {
        return category;
    }

    public void setCategory (String category) {
        this.category.set(category);
    }

    public String getIntro () {
        return intro.get();
    }

    public StringProperty introProperty () {
        return intro;
    }

    public void setIntro (String intro) {
        this.intro.set(intro);
    }

    public Date getStartDate () { return startDate; }

    public void setStartDate (Date startDate) { this.startDate = startDate; }

    public int getDuration () {
        return duration.get();
    }

    public IntegerProperty durationProperty () {
        return duration;
    }

    public void setDuration (int duration) {
        this.duration.set(duration);
    }

    public String getFeedback () {
        return feedback.get();
    }

    public StringProperty feedbackProperty () {
        return feedback;
    }

    public void setFeedback (String feedback) {
        this.feedback.set(feedback);
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public double getPrice () {
        return price.get();
    }

    public DoubleProperty priceProperty () {
        return price;
    }

    public void setPrice (double price) {
        this.price.set(price);
    }

    public String getTime () {
        return time.get();
    }

    public StringProperty timeProperty () {
        return time;
    }

    public void setTime (String time) {
        this.time.set(time);
    }

    @Override
    public String toString () {
        return "Course{" +
                "courseId=" + getCourseId() +
                ", customerAccount=" + customerAccount +
                ", trainerAccount=" + trainerAccount +
                ", category=" + category +
                ", intro=" + intro +
                ", startTime=" + startDate +
                ", duration=" + duration +
                ", feedback=" + feedback +
                ", status=" + status +
                ", price=" + price +
                '}';
    }
}