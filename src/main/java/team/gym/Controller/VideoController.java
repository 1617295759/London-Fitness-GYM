package team.gym.Controller;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import team.gym.MainApp;
import team.gym.MyUtils.Session;
import team.gym.View.LoginView;

@FXMLController
public class VideoController {

    @FXML
    private Button membershipButton;

    @FXML
    private Button mineButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button ViewSearchButton;

    @FXML
    private AnchorPane menuPane;

    @FXML
    private Button bookButton;

    @FXML
    private Button movesButton;

    @FXML
    private Button sportsButton;

    @FXML
    private Button videoButton;

    @FXML
    private Button yogaButton;

    @FXML
    private Button HIITButton;

    @FXML
    private TextField ViewTF;

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

    @FXML
    void yogaEvent(ActionEvent event) {

    }

    @FXML
    void HIITEvent(ActionEvent event) {

    }

    @FXML
    void movesEvent(ActionEvent event) {

    }

    @FXML
    void sportsEvent(ActionEvent event) {

    }

}
