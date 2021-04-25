package team.gym.FXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import de.felixroske.jfxsupport.FXMLController;
import org.springframework.beans.factory.annotation.Autowired;
import team.gym.MainApp;
import team.gym.MyUtils.Session;
import team.gym.View.LoginView;

@FXMLController
public class VideoController {

    @FXML
    private ToggleButton membershipButton;

    @FXML
    private ToggleButton mineButton;

    @FXML
    private TextField videoSearchField;

    @FXML
    private Button exitButton;

    @FXML
    private ToggleButton bookButton;

    @FXML
    private VBox VBox1;

    @FXML
    private ToggleGroup function;

    @FXML
    private ToggleButton videoButton;

    @Autowired
    @FXML
    private MainApp mainApp;

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
        MainApp.showView(LoginView.class);
        Session.setUser(null);
    }

}
