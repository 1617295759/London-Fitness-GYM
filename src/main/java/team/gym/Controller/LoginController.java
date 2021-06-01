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
import team.gym.Beans.Customer;
import team.gym.Beans.Trainer;
import team.gym.Beans.User;
import team.gym.MainApp;
import team.gym.MyUtils.DialogUtils;
import team.gym.MyUtils.Session;
import team.gym.Service.CustomerService;
import team.gym.Service.TrainerService;
import team.gym.View.TrainerSchedule;
import team.gym.View.Video;
/**
 * Controller to control login page
 */
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
    @FXML
    private PasswordField passwordField1;
    @FXML
    private TextField accountEmail;
    @FXML
    private TextField accountPhone;

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
                String status = customerService.verifyCustomer(usernameField.getText(),passwordField.getText());
                if (status != null) {
                    throw new NullPointerException(status);
                }
                Session.setUser(customerService.getCustomer(usernameField.getText(),passwordField.getText()));
                MainApp.showView(team.gym.View.Video.class);
            } else {
                String status = trainerService.verifyTrainer(usernameField.getText(),passwordField.getText());
                if (status != null) {
                    throw new NullPointerException(status);
                }
                Session.setUser(trainerService.getTrainer(usernameField.getText(),passwordField.getText()));
                MainApp.showView(team.gym.View.TrainerSchedule.class);
            }
        } catch (Exception e) {
            DialogUtils.tips(mainApp.getPrimaryStage(),"There was a problem logging in", e.getMessage());
            System.out.println("There was a problem logging in");
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
        String account = accountNameField1.getText();
        String password = passwordField1.getText();
        String email = accountEmail.getText();
        String phone = accountPhone.getText();

        if(isMember1.isSelected()){
            Customer user = new Customer();
            user.setAccount(account);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhone(phone);

            String status = customerService.registerCustomer(user);
            if (status!=null){
                DialogUtils.tips(mainApp.getPrimaryStage(),"There was a problem Customer Signing up", status);
            }else{
                Session.setUser(user);
                MainApp.showView(Video.class);
                DialogUtils.good(mainApp.getPrimaryStage(), "Congratulations to Join Us", "Signing in Successfully");
            }
        }else if(isTrainer1.isSelected()){
            Trainer user = new Trainer();
            user.setAccount(account);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhone(phone);

            String status = trainerService.registerTrainer(user);
            if (status!=null){
                DialogUtils.tips(mainApp.getPrimaryStage(),"There was a problem Trainer Signing up", status);
            }else{
                Session.setUser(user);
                MainApp.showView(TrainerSchedule.class);
                DialogUtils.good(mainApp.getPrimaryStage(), "Congratulations to Join Us",
                        "Signing in Successfully, Your Information are presented to Coachees");
            }
        }
    }

}

