package team.gym.Controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
@FXMLController
public class CustomerViewController {

    @FXML // fx:id="usernameField"
    private TextField usernameField; // Value injected by FXMLLoader

    @FXML // fx:id="magazineNameColumn"
    private TableColumn<?, ?> magazineNameColumn; // Value injected by FXMLLoader

    @FXML // fx:id="magazinClassLabel"
    private Label magazinClassLabel; // Value injected by FXMLLoader

    @FXML // fx:id="orderIdColumn"
    private TableColumn<?, ?> orderIdColumn; // Value injected by FXMLLoader

    @FXML // fx:id="subscriptedPane"
    private BorderPane subscriptedPane; // Value injected by FXMLLoader

    @FXML // fx:id="totalPrice"
    private Label totalPrice; // Value injected by FXMLLoader

    @FXML // fx:id="totalPriceColumn"
    private TableColumn<?, ?> totalPriceColumn; // Value injected by FXMLLoader

    @FXML // fx:id="timeChoiceBox"
    private ChoiceBox<?> timeChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="imageBorder"
    private Rectangle imageBorder; // Value injected by FXMLLoader

    @FXML // fx:id="sidField"
    private TextField sidField; // Value injected by FXMLLoader

    @FXML // fx:id="magazinePriceLabel"
    private Label magazinePriceLabel; // Value injected by FXMLLoader

    @FXML // fx:id="confirmButton"
    private Button confirmButton; // Value injected by FXMLLoader

    @FXML // fx:id="changeButton"
    private Button changeButton; // Value injected by FXMLLoader

    @FXML // fx:id="orderTable"
    private TableView<?> orderTable; // Value injected by FXMLLoader

    @FXML // fx:id="trueNameField"
    private TextField trueNameField; // Value injected by FXMLLoader

    @FXML // fx:id="magazinIntroLabel"
    private Label magazinIntroLabel; // Value injected by FXMLLoader

    @FXML // fx:id="nameColumn"
    private TableColumn<?, ?> nameColumn; // Value injected by FXMLLoader

    @FXML // fx:id="magazineCover"
    private ImageView magazineCover; // Value injected by FXMLLoader

    @FXML // fx:id="classNameColumn"
    private TableColumn<?, ?> classNameColumn; // Value injected by FXMLLoader

    @FXML // fx:id="copiesNumChoiceBox"
    private ChoiceBox<?> copiesNumChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="userNameLabel"
    private Label userNameLabel; // Value injected by FXMLLoader

    @FXML // fx:id="passwordField"
    private TextField passwordField; // Value injected by FXMLLoader

    @FXML // fx:id="magazineIdLabel"
    private Label magazineIdLabel; // Value injected by FXMLLoader

    @FXML // fx:id="priceColumn"
    private TableColumn<?, ?> priceColumn; // Value injected by FXMLLoader

    @FXML // fx:id="monthColumn"
    private TableColumn<?, ?> monthColumn; // Value injected by FXMLLoader

    @FXML // fx:id="subscriptionPane"
    private BorderPane subscriptionPane; // Value injected by FXMLLoader

    @FXML // fx:id="magazineTable"
    private TableView<?> magazineTable; // Value injected by FXMLLoader

    @FXML // fx:id="magazineIdColumn"
    private TableColumn<?, ?> magazineIdColumn; // Value injected by FXMLLoader

    @FXML // fx:id="magazineNameLabel"
    private Label magazineNameLabel; // Value injected by FXMLLoader

    @FXML // fx:id="telField"
    private TextField telField; // Value injected by FXMLLoader

    @FXML // fx:id="magazineOfficeLabel"
    private Label magazineOfficeLabel; // Value injected by FXMLLoader

    @FXML // fx:id="magazineCycleLabel"
    private Label magazineCycleLabel; // Value injected by FXMLLoader

    @FXML // fx:id="personInfoPane"
    private BorderPane personInfoPane; // Value injected by FXMLLoader

    @FXML // fx:id="addrField"
    private TextField addrField; // Value injected by FXMLLoader

    @FXML // fx:id="funcBar"
    private HBox funcBar; // Value injected by FXMLLoader

    @FXML // fx:id="copiesNumColumn"
    private TableColumn<?, ?> copiesNumColumn; // Value injected by FXMLLoader

    @FXML // fx:id="statisticPriceChart"
    private PieChart statisticPriceChart; // Value injected by FXMLLoader

    @FXML
    void handleChange(ActionEvent event) {

    }

    @FXML
    void handleNameOrderPie(ActionEvent event) {

    }

    @FXML
    void handleClassOrderPie(ActionEvent event) {

    }

    @FXML
    void handleNamePricePie(ActionEvent event) {

    }

    @FXML
    void handleClassPricePie(ActionEvent event) {

    }

    @FXML
    void handleConfirm(ActionEvent event) {

    }

    @FXML
    void handlePersonInfo(ActionEvent event) {

    }

    @FXML
    void handleSubscription(ActionEvent event) {

    }

    @FXML
    void handleSubscripted(ActionEvent event) {

    }

    @FXML
    void handleLogout(ActionEvent event) {

    }

}

