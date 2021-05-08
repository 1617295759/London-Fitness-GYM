package team.gym.FXMLController;

import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import team.gym.Beans.Course;
import team.gym.Beans.Customer;
import team.gym.Dao.CourseDao;
import team.gym.Dao.TrainerDao;
import team.gym.MainApp;
import team.gym.MyUtils.Session;
import team.gym.Service.CourseService;
import team.gym.Service.TrainerService;
import team.gym.View.LoginView;

import java.util.Date;
import java.util.List;

@FXMLController
public class TrainerSchedule {

    @FXML
    private Button OverCourses;

    @FXML
    private Button TodoCourses;

    @FXML
    private Button BookerAdjustment;

    @FXML
    private TableView<Course> schedule;
    @FXML
    private TableColumn<Course, String> duration;
    @FXML
    private TableColumn<Course, String> client;
    @FXML
    private TableColumn<Course, String> startTime;
    @FXML
    private Button Exit;

    private ObservableList<Course> courseData = FXCollections.observableArrayList();

    @Autowired
    TrainerService trainerService;
    @Autowired
    CourseService courseService;

    @FXML
    private void initialize(){
        List<Course> courses = courseService.getTrainerOverCourse(Session.getUser().getAccount());

        courseData.addAll(courses);

        schedule.setItems(courseData);

        client.setCellValueFactory(cellData -> cellData.getValue().customerAccountProperty());
        startTime.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartTime().toString()));
        duration.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDuration())));
    }
    @FXML
    void BookerAdjustEvent(ActionEvent event) {

    }

    @FXML
    void Exit(ActionEvent event) {
        MainApp.showView(LoginView.class);
        Session.setUser(null);
    }


    @FXML
    void Over(ActionEvent event) {

    }

    @FXML
    void Todo(ActionEvent event) {

    }
}
