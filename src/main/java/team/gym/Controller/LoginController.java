package team.gym.Controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import team.gym.MainApp;
import team.gym.MyUtils.DialogUtils;
import team.gym.MyUtils.Session;
import team.gym.Service.CustomerService;
import team.gym.Service.TrainerService;

@FXMLController
public class LoginController {
    @FXML
    private RadioButton isTrainer1;

    @FXML
    private VBox signUpBox;

    @FXML
    private Button signUpButton1;

    @FXML
    private TextField usernameField;

    @FXML
    private RadioButton isMember;

    @FXML
    private ToggleGroup login;

    @FXML
    private RadioButton isMember1;

    @FXML
    private ToggleGroup signup;

    @FXML
    private VBox loginBox;

    @FXML
    private PasswordField passwordField1;

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
    private TextField accountNameField1;

    @Autowired
    TrainerService trainerService;
    @Autowired
    CustomerService customerService;
    @Autowired
    @FXML
    private MainApp mainApp;
    @FXML
    void login(ActionEvent event) {
        System.out.println("用户输入账号"+usernameField.getText());
        System.out.println("用户输入密码"+passwordField.getText());
        try {
            if (isMember.isSelected()) {
                String status = trainerService.verifyTrainer(usernameField.getText(),passwordField.getText());
                if (status != null) {
                    throw new NullPointerException(status);
                }
                Session.setUser(customerService.getCustomer(usernameField.getText(),passwordField.getText()));
                MainApp.showView(team.gym.View.Video.class);
            } else {
                String status = customerService.verifyCustomer(usernameField.getText(),passwordField.getText());
                if (status != null) {
                    throw new NullPointerException(status);
                }
                Session.setUser(trainerService.getTrainer(usernameField.getText(),passwordField.getText()));
                MainApp.showView(team.gym.View.Video.class);
            }
        } catch (Exception e) {
            DialogUtils.tips(mainApp.getPrimaryStage(), e.getMessage());
            System.out.println("出现了一些问题，请查看提示信息");
            usernameField.requestFocus();
        }
    }

    @FXML
    void toSignUp(ActionEvent event) {
        loginBox.setVisible(false);
        signUpBox.setVisible(true);
    }

    @FXML
    void backEvent(ActionEvent event) {
        signUpBox.setVisible(false);
        loginBox.setVisible(true);
    }

    @FXML
    void signUp(ActionEvent event) {

    }

}

