package team.gym.Controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import team.gym.MainApp;
import team.gym.MyUtils.Session;
import team.gym.View.Book;
import team.gym.View.LoginView;

@FXMLController
public class BookingController {

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
    private DatePicker startDatePicker;

    @FXML
    private ComboBox<Integer> startTimeBox;

    @FXML
    private ComboBox<Integer> durationBox;

    @FXML
    private Button BookingSubmitButton;

    @FXML
    private Button videoButton;

    @FXML
    private TextArea BookingTextArea;

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
    private void initialize() {
        durationBox.getItems().addAll(30, 45, 60, 90, 120);
    }

    @FXML
    void backEvent(ActionEvent event) {
        MainApp.showView(Book.class);
    }

    @FXML
    void Submit(ActionEvent event) {

    }

}

