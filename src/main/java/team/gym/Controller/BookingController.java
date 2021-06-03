package team.gym.Controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import team.gym.Beans.Course;
import team.gym.Beans.User;
import team.gym.MainApp;
import team.gym.MyUtils.DialogUtils;
import team.gym.MyUtils.PayUtils;
import team.gym.MyUtils.Session;
import team.gym.Service.CourseService;
import team.gym.View.Book;
import team.gym.View.MineView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Controller to control reserving page
 */
@FXMLController
public class BookingController {
    @FXML
    private Text welcome;

    @FXML
    private Button membershipButton;

    @FXML
    private Button mineButton;

    @FXML
    private Button exitButton;

    @FXML
    private AnchorPane menuPane;

    @FXML
    private Button bookButton;

    @FXML
    private DatePicker startDatePicker = new DatePicker(LocalDate.of(2021, 5, 27));;

    @FXML
    private ComboBox<String> startTimeBox;

    @FXML
    private ComboBox<Integer> durationBox;

    @FXML
    private Button BookingSubmitButton;

    @FXML
    private Button videoButton;

    @FXML
    private TextArea BookingTextArea;

    User currentUser = null;

    @Autowired
    CourseService courseService;

    @Autowired
    @FXML
    private MainApp mainApp;

    @Autowired
    MineController mineController;


    @FXML
    private void initialize() {
        startDatePicker.setValue(LocalDate.now());

        currentUser = Session.getUser();
        welcome.setText(currentUser.getAccount());
        durationBox.getItems().addAll(30, 45, 60, 90, 120);
        durationBox.getSelectionModel().selectFirst();
        startTimeBox.getItems().addAll(
                "9:00","9:30","10:00","10:30","11:00","14:30","15:00","15:30","16:00","16:30","20:30");
        startTimeBox.getSelectionModel().selectFirst();
    }

    @FXML
    void mineEvent(ActionEvent event) { MainApp.showView(team.gym.View.MineView.class); }

    @FXML
    void videoEvent(ActionEvent event) { MainApp.showView(team.gym.View.Video.class); }

    @FXML
    void bookEvent(ActionEvent event) {
        MainApp.showView(team.gym.View.Book.class);
    }

    @FXML
    void membershipEvent(ActionEvent event) {
        MainApp.showView(team.gym.View.Membership.class);
    }

    @FXML
    void backEvent(ActionEvent event) {
        MainApp.showView(Book.class);
    }

    @FXML
    void Submit(ActionEvent event) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = startDatePicker.getValue().atStartOfDay(zoneId);
        Date date = Date.from(zdt.toInstant());

        String time="";int duration=0;String intro="";
        try{
            time = startTimeBox.getValue();
            duration = durationBox.getValue();
            intro = BookingTextArea.getText();
        }catch(Exception e){
            DialogUtils.tips(mainApp.getPrimaryStage(),"Incomplete Information","Please select all the option boxes");
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        String combined = dateformat.format(date) + " " + time;
        try {
            date = format.parse(combined);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Reserve Information" + date + "  BeginTime:" +time + "  Duration:" +duration);

        Course course = new Course();
        course.setCustomerAccount(currentUser.getAccount());
        course.setTrainerAccount(Session.getCoach().getAccount());
        course.setStartDate(date);
        course.setDuration(duration);
        course.setTime(time);
        course.setIntro(intro);

        PayUtils.payForLive(
                mainApp.getPrimaryStage(),duration*2,course,courseService,mineController);
    }

}

