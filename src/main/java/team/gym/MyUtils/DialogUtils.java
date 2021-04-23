package team.gym.MyUtils;

import com.sun.tools.javac.Main;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import team.gym.MainApp;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Optional;

public class DialogUtils {
    public static void tips(Stage stage, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示");
        ImageView menhera = new ImageView("/statics/images/systemUse/tips.png");
        menhera.setFitHeight(100);
        menhera.setPreserveRatio(true);
        alert.setGraphic(menhera);
        alert.setHeaderText("您可能有一些信息填写有误");
        alert.setContentText(message);
        alert.initOwner(stage);
        alert.show();
    }

    public static void good(Stage stage, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("祝贺");
        ImageView menhera = new ImageView("/statics/images/systemUse/good.png");
        menhera.setFitHeight(100);
        menhera.setPreserveRatio(true);
        alert.setGraphic(menhera);
        alert.setHeaderText("您的操作如期运行了");
        alert.setContentText(message);
        alert.initOwner(stage);
        alert.show();
    }

    public static boolean confirm(Stage stage, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, message ,new ButtonType("取消", ButtonBar.ButtonData.NO),
                new ButtonType("确定", ButtonBar.ButtonData.YES));
//        设置窗口的标题
        alert.setTitle("确认");
        ImageView menhera = new ImageView("/statics/images/systemUse/confirm.png");
        menhera.setFitHeight(100);
        menhera.setPreserveRatio(true);
        alert.setGraphic(menhera);
        alert.setHeaderText("最后一次机会");
//        设置对话框的 icon 图标，参数是主窗口的 stage
        alert.initOwner(stage);
//        showAndWait() 将在对话框消失以前不会执行之后的代码
        Optional<ButtonType> buttonType = alert.showAndWait();
//        根据点击结果返回
        if(buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES)){
            return true;
        } else {
            return false;
        }
    }

    /**get the String type path in the Resources, need "/" at first letter
     *
     * @param relativePath the ralative path, for example "/statics/images/systemUse/tips.png"
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
