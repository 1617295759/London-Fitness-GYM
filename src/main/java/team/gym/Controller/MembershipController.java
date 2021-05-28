package team.gym.Controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import team.gym.Beans.User;
import team.gym.MainApp;
import team.gym.MyUtils.Session;
import team.gym.View.LoginView;

@FXMLController
public class MembershipController {
    @FXML
    private Text welcome;

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
    private Button videoButton;

    @FXML
    private Button MemJbuyButton;

    @FXML
    private Button MemSbuyButton;

    User currentUser = null;

    @FXML
    private void initialize() {
        currentUser = Session.getUser();
        welcome.setText(currentUser.getAccount());
    }

    @FXML
    void MemJbuyEvent(ActionEvent event) {

    }

    @FXML
    void fffffff2(ActionEvent event) {

    }

    @FXML
    void f8f7f7(ActionEvent event) {

    }

    @FXML
    void e8e3e3(ActionEvent event) {

    }

    @FXML
    void f8f4f4(ActionEvent event) {

    }

    @FXML
    void f5f4f4(ActionEvent event) {

    }

    @FXML
    void MemSbuyEvent(ActionEvent event) {

    }

    @FXML
    void ffffff73(ActionEvent event) {

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
