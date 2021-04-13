package team.gym.Controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import team.gym.MainApp;
import team.gym.MyUtils.DialogUtils;
import team.gym.MyUtils.Session;
import team.gym.Service.CustomerService;
import team.gym.Service.TrainerService;
import team.gym.View.AdminView;
import team.gym.View.CustomerView;

@FXMLController
public class LoginViewController {
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;
    @FXML
    private CheckBox isAdmin;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private VBox loginBox;
    @FXML
    private VBox signUpBox;

    @FXML
    private TextField commonUserUsername;
    @FXML
    private TextField commonUserPassword;
    @FXML
    private TextField commonUserTruename;
    @FXML
    private TextField commonUserSid;
    @FXML
    private TextField commonUserTel;
    @FXML
    private TextField commonUserAddress;
    @FXML
    private Button saveToDataBaseButton;

    @Autowired
    private CustomerService customerService;
    @Autowired
    private TrainerService trainerService;
    @Autowired
    @FXML
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public MainApp getMainApp() {
        return mainApp;
    }

    /**
     * 这里我们在点击登录后，因为这里区分了管理员和普通用户， 所以之后的编程会相对简单一些.
     */
    @FXML
    private void handleLogin() throws Exception {
        // 调试用信息，之后可去掉
        System.out.println("登录按钮被点击了");
        System.out.println(usernameField.getText());
        System.out.println(passwordField.getText());

        try {
            if (isAdmin.isSelected()) {
                int status = trainerService.verifyTrainer(usernameField.getText(),passwordField.getText());
                if (status != 1) {
                    throw new NullPointerException("出错了，请您检查用户名或密码是否有误");
                }
                Session.setUser(trainerService.getTrainer(usernameField.getText(),passwordField.getText()));
                MainApp.showView(AdminView.class);
            } else {
                int status = customerService.verifyCustomer(usernameField.getText(),passwordField.getText());
                if (status != 1) {
                    throw new NullPointerException("出错了，请您检查用户名或密码是否有误");
                }
                Session.setUser(customerService.getCustomer(usernameField.getText(),passwordField.getText()));
                MainApp.showView(CustomerView.class);
            }
//
//            //认证完成，装载对应页面
//            FXMLLoader loader = new FXMLLoader();
//            if (isAdmin.isSelected()) {
//                loader.setLocation(Main.class.getResource("views/AdminView.fxml"));
//            } else {
//                loader.setLocation(Main.class.getResource("views/CustomerView.fxml"));
//            }
//            /*
//             *==================================================
//             *                 !!important!!
//             *     你必须先调用loader.load才能找到controller
//             *==================================================
//             */
//            Parent newView = loader.load();
//            if (isAdmin.isSelected()) {
//                AdminVIewController adminVIewController = loader.getController();
//                System.out.println(adminVIewController);
//                System.out.println(mainApp);
//                adminVIewController.setMainApp(mainApp);
//            } else {
//                CommonUserViewController commonUserViewController = loader.getController();
//                System.out.println("mainApp: " + mainApp);
//                commonUserViewController.setMainApp(mainApp);
//            }
//            mainApp.getPrimaryStage().setScene(new Scene(newView, 1152, 736));
//
        } catch (Exception e) {
            DialogUtils.tips(mainApp.getPrimaryStage(), e.getMessage());
            System.out.println("出现了一些问题，请查看提示信息");
            usernameField.setText("");
            passwordField.setText("");
            usernameField.requestFocus();
        }

    }

    @FXML
    private void handleSignUp() {
        //调试提示
        System.out.println("注册按钮被点击了");
        // 切换两个页面的显示
        loginBox.setVisible(false);
        signUpBox.setVisible(true);
    }

    @FXML
    private void handleNewUser() {
        //条件检查后，填入数据库，这里的检查包括拼写检查和判重检查
//        String errorMessage = InputChecker.commonUserSignUpCheck(commonUserUsername.getText(),
//                                                                 commonUserPassword.getText(),
//                                                                 commonUserTruename.getText(),
//                                                                 commonUserSid.getText(),
//                                                                 commonUserTel.getText(),
//                                                                 commonUserAddress.getText());
//        if (errorMessage == null) {
            // 添加至数据库
//            JdbcUtils jdbcUtils = new JdbcUtils();
//            jdbcUtils.getConnection();
//            String sql = "insert into `commonUser`(username, password, trueName, sid, tel, address) " +
//                    "values(?, ?, ?, ?, ?, ?)";
//            List<Object> params = new ArrayList<>();
//            params.add(commonUserUsername.getText());
//            params.add(commonUserPassword.getText());
//            params.add(commonUserTruename.getText());
//            params.add(commonUserSid.getText());
//            params.add(commonUserTel.getText());
//            params.add(commonUserAddress.getText());
//            try {
//                //添加用户
//                jdbcUtils.updateByPreparedStatement(sql, params);
//                DialogUtils.good(mainApp.getPrimaryStage(), "添加用户成功");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            // 认证全局用户，跳转页面
//            CommonUser newUser = new CommonUser(commonUserUsername.getText(), commonUserPassword.getText());
//            mainApp.setUserNow(newUser);
//            sql = "select * from `commonUser` where username = ? and password = ?";
//            params.clear();
//            params.add(commonUserUsername.getText());
//            params.add(commonUserPassword.getText());
//            try {
//                CommonUser now = jdbcUtils.findSimpleProResult(sql, params, CommonUser.class);
//                team.gym.MyUtils.Session.setId(now.getId());
//                team.gym.MyUtils.Session.setUsername(now.getUsername());
//                team.gym.MyUtils.Session.setType("commonUser");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//            try {
//                FXMLLoader loader = new FXMLLoader();
//                loader.setLocation(Main.class.getResource("views/CustomerView.fxml"));
//                Parent commonUserView = loader.load();
//                CommonUserViewController commonUserViewController = loader.getController();
//                mainApp.getPrimaryStage().setScene(new Scene(commonUserView, 1152, 736));
//                commonUserViewController.setMainApp(mainApp);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            DialogUtils.tips(mainApp.getPrimaryStage(), errorMessage);
//        }
    }

    @FXML
    private void handleBack() {
        signUpBox.setVisible(false);
        loginBox.setVisible(true);
    }
}
