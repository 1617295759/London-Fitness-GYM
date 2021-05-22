package team.gym.Controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import team.gym.Beans.Trainer;
import team.gym.View.Booking;
import team.gym.MainApp;
import team.gym.MyUtils.Session;
import team.gym.Service.CourseService;
import team.gym.Service.TrainerService;
import team.gym.View.LoginView;


import java.util.List;

@FXMLController
public class BookController {
    @FXML
    private AnchorPane menuPane;

    @FXML
    private TextField ViewTF;

    @FXML
    private Button membershipButton;

    @FXML
    private Button mineButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button ViewSearchButton;

    @FXML
    private Button bookButton;

    @FXML
    private Button videoButton;

    @FXML
    private TableView<Trainer> trainersTable;

    @FXML
    private TableColumn<Trainer, String> Gender;

    @FXML
    private TableColumn<Trainer, String> tele;

    @FXML
    private TableColumn<Trainer, String> email;

    @FXML
    private TableColumn<Trainer, String> Name;

    @FXML
    private TableColumn<Trainer, String> operate;

    private ObservableList<Trainer> trainersData = FXCollections.observableArrayList();

    @Autowired
    TrainerService trainerService;
    @Autowired
    CourseService courseService;
    @Autowired
    MainApp mainApp;

    @FXML
    private void initialize() {
        List<Trainer> trainers = trainerService.getAllTrainers();
        trainersData.addAll(trainers);
        trainersTable.setItems(trainersData);

        Name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        Gender.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        tele.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        email.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        operate.setCellFactory((col) -> {
                    TableCell<Trainer, String> cell = new TableCell<Trainer, String>() {
                        @Override
                        protected void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            Button wantit = new Button("Reserve This Gay");
                            wantit.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");

                            wantit.setOnMouseClicked((col) -> {
                                Trainer selectedTrainer = trainersData.get(getIndex());
                                System.out.println("You shall reserve this gay ——"+selectedTrainer.getAccount());
                                Session.setCoach(selectedTrainer);
                                // turn the page to select date and time
                                MainApp.showView(Booking.class);
                            });
                            if (empty) {
                                //如果此列为空默认不添加元素
                                setText(null);
                                setGraphic(null);
                            } else {
                                this.setGraphic(wantit);
                            }
                        }
                    };
                    return cell;
                }
        );
    }

    @FXML
    void ViewTFEvent(ActionEvent event) {

    }

    @FXML
    void ViewSearchButtonEvent(ActionEvent event) {

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

