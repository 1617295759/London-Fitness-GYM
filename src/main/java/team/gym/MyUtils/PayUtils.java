package team.gym.MyUtils;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import team.gym.Beans.Course;
import team.gym.Beans.Customer;
import team.gym.Controller.MineController;
import team.gym.Dao.Impl.CustomerDaoImpl;
import team.gym.MainApp;
import team.gym.Service.CourseService;
import team.gym.View.MineView;

public class PayUtils {
    public static void payForLevel(Stage stage,String level,double price,MineController controller) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Paying");
        alert.setHeaderText(" ");
        alert.setContentText("Scan QR code to pay through WeChat or Alipay, You shall pay "+ price +" for this level");

        ImageView QRcode = new ImageView("/statics/images/payCode.jpg");
        QRcode.setFitHeight(500);
        QRcode.setFitWidth(500);
        QRcode.setPreserveRatio(true);
        alert.setGraphic(QRcode);

        Button cancel = (Button)alert.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancel.setText("Cancel");
        Button ok = (Button)alert.getDialogPane().lookupButton(ButtonType.OK);
        ok.setText("Pay Finished");
        ok.setOnAction(event -> {
            Customer sessionCustomer = (Customer) Session.getUser();
            new CustomerDaoImpl().modifyCustomer(sessionCustomer,"level",level);

            sessionCustomer.setLevel(level);
            Session.setUser(sessionCustomer);
            controller.updateData();
            System.out.println("Level Changed successfully to " + level);
            MainApp.showView(MineView.class);
        });
        alert.initOwner(stage);
        alert.show();
    }
    public static void payForLive(Stage stage, double price, Course course, CourseService service, MineController mineController) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Paying");
        alert.setHeaderText(" ");
        alert.setContentText("Scan QR code to pay through WeChat or Alipay, You shall pay "+ price +" for this Live. ");

        ImageView QRcode = new ImageView("/statics/images/payCode.jpg");
        QRcode.setFitHeight(500);
        QRcode.setFitWidth(500);
        QRcode.setPreserveRatio(true);
        alert.setGraphic(QRcode);

        Button cancel = (Button)alert.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancel.setText("Cancel");
        Button ok = (Button)alert.getDialogPane().lookupButton(ButtonType.OK);
        ok.setText("Pay Finished");
        ok.setOnAction(event -> {
            service.addNewCourse(course);
            // update the data
            mineController.updateData();
            System.out.println("Pay for Live successfully");
            DialogUtils.good(stage, "Reserve Submitted"," Waiting for Confirmation of the Coach");

            MainApp.showView(MineView.class);
        });
        alert.initOwner(stage);
        alert.show();
    }

}
