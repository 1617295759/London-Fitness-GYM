package LoginView;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;

public class LoginController {

    @FXML
    private RadioButton isTrainer1;

    @FXML
    private VBox signUpBox;

    @FXML
    private Button signUpButton1;

    @FXML
    private TextField accountNameField;

    @FXML
    private RadioButton isMember;

    @FXML
    private ToggleGroup type;

    @FXML
    private ToggleGroup type1;

    @FXML
    private RadioButton isMember1;

    @FXML
    private VBox loginBox;

    @FXML
    private Button loginButton;

    @FXML
    private Button backButton;

    @FXML
    private Button signUpButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private RadioButton isTrainer;

    @FXML
    private PasswordField passwordSignUpField;

    @FXML
    void chooseMemberEvent(ActionEvent event) {

    }

    @FXML
    void chooseTrainerEvent(ActionEvent event) {

    }

    @FXML
    void loginEvent(ActionEvent event) {

    }

    @FXML
    void signUpEvent(ActionEvent event) {
        loginBox.setVisible(false);
        signUpBox.setVisible(true);
    }

    @FXML
    void chooseMemberEvent1(ActionEvent event) {

    }

    @FXML
    void chooseTrainerEvent1(ActionEvent event) {

    }

    @FXML
    void backEvent(ActionEvent event) {
        signUpBox.setVisible(false);
        loginBox.setVisible(true);
    }

    @FXML
    void signUpEvent1(ActionEvent event) {

    }

}
