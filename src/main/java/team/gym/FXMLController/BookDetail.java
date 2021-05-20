package team.gym.FXMLController;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import team.gym.FXMLView.MemberShip;
import team.gym.FXMLView.MineView;
import team.gym.FXMLView.Video;
import team.gym.MainApp;
import team.gym.MyUtils.Session;
import team.gym.View.LoginView;

@FXMLController
public class BookDetail {
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
    private Button BookingSubmitButton;

    @FXML
    private ToggleButton videoButton;

    @FXML
    private DatePicker BookingSDPicker;

    @FXML
    private TextArea BookingTextArea;

    @FXML
    private ComboBox<Integer> BookingComboBox;

    @FXML
    private DatePicker BookingSTPicker;

    @FXML
    private void initialize() {
        BookingComboBox.getItems().addAll(
                30,
                45,
                60,
                90,
                120
        );
    }

    @FXML
    void exitEvent(ActionEvent event) {
        Session.setUser(null);
        MainApp.showView(LoginView.class);
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
    void BookingSDPickerEvent(ActionEvent event) {

    }

    @FXML
    void BookingSTPickerEvent(ActionEvent event) {

    }

    @FXML
    void BookingComboBoxEvent(ActionEvent event) {

    }

    @FXML
    void BookingSubmitButtonEvent(ActionEvent event) {
        int duration = BookingComboBox.getValue();
        System.out.println(duration);
    }

}
