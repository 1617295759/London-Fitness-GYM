package team.gym.Controller;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import team.gym.Beans.User;
import team.gym.MyUtils.Session;
/**
 * Controller to control Personal Detail page
 */
@FXMLController
public class PersonalDetailController {

    @FXML
    private Button modifyButton;

    @FXML
    private Button backButton;


    User currentUser = null;

    @FXML
    private void initialize() {
        currentUser = Session.getUser();
//        welcome.setText(currentUser.getAccount());
//        username.setText(currentUser.getAccount());
    }

    @FXML
    void modifyEvent(ActionEvent event) {

    }

    @FXML
    void backEvent(ActionEvent event) {

    }

}
