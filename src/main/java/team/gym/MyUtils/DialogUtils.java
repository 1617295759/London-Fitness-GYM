package team.gym.MyUtils;

import com.sun.tools.javac.Main;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogEvent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import team.gym.MainApp;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Optional;
/**
 * Dialog Util
 */
public class DialogUtils {
    /** prompt a window to tip
     *
     * @param stage the main stage
     * @param header the header of the tip window
     * @param message the message presented in the prompted window
     */
    public static void tips(Stage stage,String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示");
        ImageView menhera = new ImageView("/statics/images/systemUse/tips.png");
        menhera.setFitHeight(100);
        menhera.setPreserveRatio(true);
        alert.setGraphic(menhera);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.initOwner(stage);
        alert.show();
    }

    /** prompt a window to tell the customer the operation is done successfully.
     *
     * @param stage the main stage
     * @param header the header of the tip window
     * @param message the message presented in the prompted window
     */
    public static void good(Stage stage,String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Yeah!");
        ImageView menhera = new ImageView("/statics/images/systemUse/good.png");
        menhera.setFitHeight(100);
        menhera.setPreserveRatio(true);
        alert.setGraphic(menhera);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.initOwner(stage);
        alert.show();

    }
    /** prompt a window to tell the customer the operation is done successfully.
     *
     * @param stage the main stage
     * @param header the header of the tip window
     * @param message the message presented in the prompted window
     */
    public static boolean confirm(Stage stage,String header, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, message ,new ButtonType("取消", ButtonBar.ButtonData.NO),
                new ButtonType("确定", ButtonBar.ButtonData.YES));
        //set header
        alert.setTitle(header);
        ImageView menhera = new ImageView("/statics/images/systemUse/confirm.png");
        menhera.setFitHeight(100);
        menhera.setPreserveRatio(true);
        alert.setGraphic(menhera);
        alert.setHeaderText("Last Chance");
        alert.initOwner(stage);
        // showAndWait() The following code will not be executed until the dialog box disappears
        Optional<ButtonType> buttonType = alert.showAndWait();
        if(buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES)){
            return true;
        } else {
            return false;
        }
    }

    /**get the String type path in the Resources, need "/" at first letter
     *
     * @param relativePath the relative path, for example "/statics/images/systemUse/tips.png"
     * @return the String type path
     */
    public static String getURL(String relativePath){
        String path = null;
        try {
            path = URLDecoder.decode(MainApp.class.getResource(relativePath).getPath(),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return path;
    }
}
