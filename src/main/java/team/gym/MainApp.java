package team.gym;

import team.gym.Beans.User;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import team.gym.MyUtils.SplashScreenCustom;
import team.gym.View.LoginView;

@SpringBootApplication
public class MainApp extends AbstractJavaFxApplicationSupport {
    private Stage primaryStage;
    private User userNow;

    public static void main(String[] args) {
        launch(MainApp.class, LoginView.class , new SplashScreenCustom(), args);
    }

    public Stage getPrimaryStage() { return primaryStage; }

    public void setPrimaryStage(Stage primaryStage) { this.primaryStage = primaryStage; }

    public User getUserNow() { return userNow; }

    public void setUserNow(User userNow) { this.userNow = userNow; }
}
