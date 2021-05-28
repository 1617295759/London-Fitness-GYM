package team.gym.Controller;
import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import team.gym.Beans.Course;
import team.gym.Beans.Trainer;
import team.gym.Beans.User;
import team.gym.MainApp;
import team.gym.MyUtils.Session;
import team.gym.Service.CourseService;
import team.gym.View.LoginView;

import java.util.Date;
import java.util.List;

@FXMLController
public class MineController {

    @FXML
    private TableView<Course> calender;

    @FXML
    private TableColumn<Course, String> date;

    @FXML
    private TableColumn<Course, String> duration;

    @FXML
    private TableColumn<Course, String> time;

    @FXML
    private TableColumn<Course, String> coach;

    @FXML
    private Text gender;

    @FXML
    private AnchorPane menuPane;

    @FXML
    private Button membershipButton;


    @FXML
    private Button mineButton;

    @FXML
    private Button exitButton;

    @FXML
    private Text phone;

    @FXML
    private Button bookButton;

    @FXML
    private Button videoButton;

    @FXML
    private Text welcome;

    @FXML
    private Text email;

    @FXML
    private Text username;

    User currentUser = null;
    private ObservableList<Course> coursesData = FXCollections.observableArrayList();
    @Autowired
    CourseService courseService;

    @FXML
    private void initialize() {
        currentUser = Session.getUser();
        welcome.setText(currentUser.getAccount());
        username.setText(currentUser.getAccount());
        gender.setText(currentUser.getGender());
        email.setText(currentUser.getEmail());
        phone.setText(currentUser.getPhone());

        List<Course> courses = courseService.getCustomerOverCourse(currentUser.getAccount());
        coursesData.addAll(courses);
        calender.setItems(coursesData);

        coach.setCellValueFactory(cellData -> cellData.getValue().trainerAccountProperty());
        date.setCellValueFactory(
                cellData ->new SimpleStringProperty(cellData.getValue().getStartDate().toString()));
        time.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
        duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
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
    void exitEvent(ActionEvent event) {
        MainApp.showView(LoginView.class);
        Session.setUser(null);
    }

}

