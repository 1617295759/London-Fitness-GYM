package team.gym.FXMLController;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import team.gym.FXMLView.MemberShip;
import team.gym.FXMLView.MineView;
import team.gym.FXMLView.Video;
import team.gym.MainApp;
import team.gym.MyUtils.Session;
import team.gym.View.LoginView;

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
