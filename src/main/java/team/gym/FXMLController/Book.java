package team.gym.FXMLController;

import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import team.gym.Beans.Trainer;
import team.gym.FXMLView.MemberShip;
import team.gym.FXMLView.MineView;
import team.gym.FXMLView.Video;
import team.gym.MainApp;
import team.gym.MyUtils.Session;
import team.gym.Service.CourseService;
import team.gym.Service.TrainerService;
import team.gym.View.LoginView;

import java.util.List;

@FXMLController
public class Book {

    @FXML
    private ToggleButton membershipButton;

    @FXML
    private ToggleButton mineButton;

    @FXML
    private Button exitButton;

    @FXML
    private ToggleButton bookButton;

    @FXML
    private ToggleGroup function;

    @FXML
    private ToggleButton videoButton;


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

    @FXML
    private void initialize() {
        List<Trainer> trainers = trainerService.getAllTrainers();
        trainersData.addAll(trainers);
        trainersTable.setItems(trainersData);

        Name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        Gender.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        tele.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        email.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
//        operate.setCellFactory((col) -> {
//
//                    TableCell<Trainer, String> cell = new TableCell<Trainer, String>() {
//                        @Override
//                        protected void updateItem(String item, boolean empty) {
//                            super.updateItem(item, empty);
//                            button1 = new JFXButton("编辑");
//                            button1.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");
//
//                            button1.setOnMouseClicked((col) -> {
//
//                                //获取list列表中的位置，进而获取列表对应的信息数据
//                                Trainer userLoad1 = trainersData.get(getIndex());
//                                //按钮事件自己添加
//
//                            });
//                            if (empty) {
//                                //如果此列为空默认不添加元素
//                                setText(null);
//                                setGraphic(null);
//                            } else {
//                                this.setGraphic(button1);
//                            }
//                        }
//                    };
//                    return cell;
//                }
//        );
    }

    @FXML
    void mineEvent(ActionEvent event) {
        MainApp.showView(MineView.class);
    }

    @FXML
    void videoEvent(ActionEvent event) {
        MainApp.showView(Video.class);
    }

    @FXML
    void bookEvent(ActionEvent event) {
        MainApp.showView(team.gym.FXMLView.Book.class);
    }

    @FXML
    void membershipEvent(ActionEvent event) {
        MainApp.showView(MemberShip.class);
    }

    @FXML
    void exitEvent(ActionEvent event) {
        MainApp.showView(LoginView.class);
        Session.setUser(null);
    }
}
