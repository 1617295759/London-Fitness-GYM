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

@FXMLController
public class TrainerSchedule {

    @FXML
    private Button BookerAccept2button;

    @FXML
    private Button BookerAccept1button;

    @FXML
    private Button BookerAdjustment;

    @FXML
    private TableView<Course> schedule;
    @FXML
    private TableColumn<Course, String> duration;
    @FXML
    private TableColumn<Course, String> client;
    @FXML
    private TableColumn<Course, Date> startTime;
    @FXML
    private Button Exit;

    private ObservableList<Course> courseData = FXCollections.observableArrayList();

    @Autowired
    TrainerService trainerService;
    @Autowired
    CourseService courseService;

    @FXML
    private void initialize(){
        courseData.addAll(courseService.getTrainerTodoCourse());
        schedule.setItems(courseData);

        client.setCellValueFactory(cellData -> cellData.getValue().customerAccountProperty());
        //startTime.setCellValueFactory(cellData -> (ObservableValue<Date>) cellData.getValue().getStartTime());
        //duration.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDuration())));
    }

    @FXML
    void BookerAccept1Event(ActionEvent event) {

    }

    @FXML
    void BookerAccept2Event(ActionEvent event) {

    }


    @FXML
    void BookerAdjustEvent(ActionEvent event) {

    }

    @FXML
    void Exit(ActionEvent event) {
        MainApp.showView(LoginView.class);
        Session.setUser(null);
    }
}
