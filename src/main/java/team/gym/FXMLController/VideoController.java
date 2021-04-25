package team.gym.FXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import de.felixroske.jfxsupport.FXMLController;
import org.springframework.beans.factory.annotation.Autowired;
import team.gym.FXMLView.Book;
import team.gym.FXMLView.MemberShip;
import team.gym.FXMLView.MineView;
import team.gym.FXMLView.Video;
import team.gym.MainApp;
import team.gym.MyUtils.Session;
import team.gym.MyUtils.VideoPlayer;
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

    @FXML
    private Button watchnow;

    @FXML
    private Pane videos;

    @Autowired
    @FXML
    private MainApp mainApp;

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
        MainApp.showView(Book.class);
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


    @FXML
    void watch(ActionEvent event) {
        VideoPlayer.popup(getClass().getResource("/statics/videos/TestMedia.MP4").toString());
    }


}
