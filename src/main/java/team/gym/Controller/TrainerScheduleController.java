package team.gym.Controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.application.HostServices;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import team.gym.Beans.Course;
import team.gym.Beans.Trainer;
import team.gym.MainApp;
import team.gym.MyUtils.Session;
import team.gym.Service.CourseService;
import team.gym.View.LoginView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@FXMLController
public class TrainerScheduleController {
    @FXML
    private TableView<Course> calender;

    @FXML
    private TableView<Course> o_calender;

    @FXML
    private TableView<Course> un_calender;

    @FXML
    private TableColumn<Course, String> date;

    @FXML
    private TableColumn<Course, String> date2;

    @FXML
    private TableColumn<Course, String> date1;

    @FXML
    private TableColumn<Course, String> duration;

    @FXML
    private TableColumn<Course, String> duration1;

    @FXML
    private TableColumn<Course, String> duration2;

    @FXML
    private TableColumn<Course, String> time;

    @FXML
    private TableColumn<Course, String> time1;

    @FXML
    private TableColumn<Course, String> time2;

    @FXML
    private TableColumn<Course, String> coach;

    @FXML
    private TableColumn<Course, String> coach1;

    @FXML
    private TableColumn<Course, String> coach2;

    @FXML
    private TableColumn<Course, String> statues;
    @FXML
    private TableColumn<Course, String> statues1;
    @FXML
    private TableColumn<Course, String> statues12;
    @FXML
    private TableColumn<Course, String> statues2;

    @FXML
    private Text gender;

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

    Trainer currentUser = null;
    List<Course> overCourses;
    List<Course> unconfirmedCourses;
    List<Course> todoCourses;
    private ObservableList<Course> overData = FXCollections.observableArrayList();
    private ObservableList<Course> unconfirmedData = FXCollections.observableArrayList();
    private ObservableList<Course> todoData = FXCollections.observableArrayList();
    @Autowired
    CourseService courseService;

    @Autowired
    @FXML
    private MainApp mainApp;

    @FXML
    private void initialize() {
        // Text assignment
        currentUser = (Trainer) Session.getUser();
        welcome.setText(currentUser.getAccount());
        username.setText(currentUser.getAccount());
        gender.setText(currentUser.getGender());
        email.setText(currentUser.getEmail());
        phone.setText(currentUser.getPhone());


        updateData();


        // Populate the  table with corresponding observable list data
        calender.setItems(todoData);
        un_calender.setItems(unconfirmedData);
        o_calender.setItems(overData);

        // Populate the table cell with data, To_do table
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        coach.setCellValueFactory(new PropertyValueFactory<>("customerAccount"));
        date.setCellValueFactory(
                cellData -> new SimpleStringProperty(dateFormat.format(cellData.getValue().getStartDate())));
        time.setCellValueFactory(
                cellData -> new SimpleStringProperty(timeFormat.format(cellData.getValue().getStartDate()))
        );
        duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        statues.setCellFactory((col) -> {
            TableCell<Course, String> cell = new TableCell<Course, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    if (empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        super.updateItem(item, empty);
                        Course course = todoData.get(getIndex());
                        Date now = new Date();
                        long diff = course.getStartDate().getTime() - now.getTime();

                        Button joinLive = new Button("Join the Live");
                        joinLive.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");
                        joinLive.setOnMouseClicked((col) -> {
                            System.out.println("You shall join the live ——");
                            courseService.modifyCourseInfo(
                                    course, "status", String.valueOf(Course.FINISHED));
                            HostServices host = mainApp.getHostServices();
                            host.showDocument("https://live.bilibili.com/");
                            updateData();
                        });
                        // enter the live 10 minutes before the start of the live
                        if (Math.abs(diff) < 600000) {
                            this.setGraphic(joinLive);
                        } else {
                            setText("In Schedule");
                            setGraphic(null);
                        }
                    }
                }
            };
            return cell;
        });

        // Unconfirmed table
        coach1.setCellValueFactory(new PropertyValueFactory<>("customerAccount"));
        date1.setCellValueFactory(
                cellData -> new SimpleStringProperty(dateFormat.format(cellData.getValue().getStartDate())));
        time1.setCellValueFactory(
                cellData -> new SimpleStringProperty(timeFormat.format(cellData.getValue().getStartDate()))
        );
        duration1.setCellValueFactory(new PropertyValueFactory<>("duration"));
        statues1.setCellFactory((col) -> {
            TableCell<Course, String> cell = new TableCell<Course, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    if (empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        super.updateItem(item, empty);
                        Course course = unconfirmedData.get(getIndex());
                        int status = course.getStatus();
                        Button accept = new Button("ACCEPT");
                        accept.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");
                        accept.setOnMouseClicked((col) -> {
                            System.out.println("You shall accept the live ——");
                            courseService.modifyCourseInfo(
                                    course, "status", String.valueOf(Course.ACCEPTED));
                            updateData();
                        });
                        if (status == Course.COMMITTED) {
                            setGraphic(accept);
                        }
                    }
                }
            };
            return cell;
        });
        statues12.setCellFactory((col) -> {
            TableCell<Course, String> cell = new TableCell<Course, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    if (empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        super.updateItem(item, empty);
                        Course course = unconfirmedData.get(getIndex());
                        int status = course.getStatus();

                        Button reject = new Button("REJECT");
                        reject.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");
                        reject.setOnMouseClicked((col) -> {
                            System.out.println("You shall reject the live ——");
                            courseService.modifyCourseInfo(
                                    course, "status", String.valueOf(Course.REJECTED));
                            updateData();
                        });
                        if (status == Course.COMMITTED) {
                            setGraphic(reject);
                        }
                    }
                }
            };
            return cell;
        });

        // passed courses table
        coach2.setCellValueFactory(new PropertyValueFactory<>("customerAccount"));
        date2.setCellValueFactory(
                cellData -> new SimpleStringProperty(dateFormat.format(cellData.getValue().getStartDate())));
        time2.setCellValueFactory(
                cellData -> new SimpleStringProperty(timeFormat.format(cellData.getValue().getStartDate()))
        );
        duration2.setCellValueFactory(new PropertyValueFactory<>("duration"));
        statues2.setCellFactory((col) -> {
            TableCell<Course, String> cell = new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    if (empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        super.updateItem(item, empty);
                        Course course = overData.get(getIndex());
                        int status = course.getStatus();

                        Button cancel = new Button("DELETE");
                        cancel.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");
                        cancel.setOnMouseClicked((col) -> {
                            System.out.println("You shall delete the live ——");
                            courseService.deleteCourse(course);
                            updateData();
                        });

                        if (status == Course.FINISHED) {
                            setText("FINISHED");
                        } else if (status == Course.MISS) {
                            setText("MISS");
                        } else if (status == Course.COMMITTED) {
                            setText("TIMEOUT");
                        } else if (status == Course.REJECTED) {
                            setText("REJECTED");
                        }
                        setGraphic(cancel);
                    }
                }
            };
            return cell;
        });

    }

    @FXML
    void mineEvent(ActionEvent event) {

    }

    @FXML
    void videoEvent(ActionEvent event) {

    }

    @FXML
    void bookEvent(ActionEvent event) {

    }

    @FXML
    void membershipEvent(ActionEvent event) {

    }

    @FXML
    void exitEvent(ActionEvent event) {
        System.out.println("Trainer exit");
        MainApp.showView(LoginView.class);
        Session.setUser(null);
    }
    @FXML
    void onSort(SortEvent<TableView<Course>> event) {
        // get the courses data from xml calling for Service
        updateData();
    }

    void updateData() {
        if (currentUser == null) currentUser = (Trainer) Session.getUser();
        // get the courses data from xml calling for Service
        overCourses = courseService.getTrainerOverCourse(currentUser.getAccount());
        unconfirmedCourses = courseService.getTrainerUnconfirmedCourse(currentUser.getAccount());
        todoCourses = courseService.getTrainerTodoCourse(currentUser.getAccount());

        overData.clear();
        unconfirmedData.clear();
        todoData.clear();

        // add the list into the observable list
        overData.addAll(overCourses);
        unconfirmedData.addAll(unconfirmedCourses);
        todoData.addAll(todoCourses);

    }
}
