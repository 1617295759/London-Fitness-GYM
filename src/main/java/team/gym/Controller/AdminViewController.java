package team.gym.Controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
@FXMLController
public class AdminViewController {

    @FXML
    private ComboBox<?> anUserNameBox;

    @FXML
    private TableColumn<?, ?> magazineNameColumn;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private ComboBox<?> fooOrderUsernameBox;

    @FXML
    private Label bestMagazineCopiesNum;

    @FXML
    private Rectangle imageBorder;

    @FXML
    private TextField fooOrderIdField;

    @FXML
    private TextField magazineCycleField;

    @FXML
    private BorderPane commonUserPane;

    @FXML
    private TableColumn<?, ?> fooOrderIdColumn;

    @FXML
    private TextField commonUserIdField;

    @FXML
    private TableView<?> fooMagazineClassTableView;

    @FXML
    private BorderPane searchPane;

    @FXML
    private ImageView magazineCover;

    @FXML
    private Label userNameLabel;

    @FXML
    private Label toCommonUserButton;

    @FXML
    private BorderPane adminPane;

    @FXML
    private TextField fooMagazineClassNameField;

    @FXML
    private Label bestMagazine;

    @FXML
    private TextField commonUserSidField;

    @FXML
    private TableColumn<?, ?> seOrderIdColumn;

    @FXML
    private TextField commonUserNameField;

    @FXML
    private TableColumn<?, ?> adminPasswordColumn;

    @FXML
    private ComboBox<?> seCopiesNumBox;

    @FXML
    private TableView<?> adminTableView;

    @FXML
    private Label anMagazineNameLabel;

    @FXML
    private TableColumn<?, ?> adminNameColumn;

    @FXML
    private TableColumn<?, ?> fooTotalPriceColumn;

    @FXML
    private Label adminIdLabel;

    @FXML
    private Label mostOrderNumUser;

    @FXML
    private TableColumn<?, ?> fooMagazineClassIdColumn;

    @FXML
    private ComboBox<?> sePriceIntervalBox;

    @FXML
    private TextArea magazineIntroArea;

    @FXML
    private TableColumn<?, ?> commonUserNameColumn;

    @FXML
    private Label adminNameLabel;

    @FXML
    private ChoiceBox<?> fooCopiesNumBox;

    @FXML
    private TextField adminPasswordField;

    @FXML
    private Label toAdminButton;

    @FXML
    private TableView<?> magazineTableView;

    @FXML
    private Label bestClass;

    @FXML
    private TextField commonUserTrueNameField;

    @FXML
    private Button searchButton;

    @FXML
    private ComboBox<?> seUserNameBox;

    @FXML
    private TableView<?> seTableView;

    @FXML
    private BorderPane statisticPane;

    @FXML
    private Label bestClassOrderNum;

    @FXML
    private TableColumn<?, ?> commonUserIdColumn;

    @FXML
    private TextField magazineIdField;

    @FXML
    private TextField adminIdField;

    @FXML
    private HBox filterBox;

    @FXML
    private TextField fooMagazineClassIdField;

    @FXML
    private Label mostRichUser;

    @FXML
    private ChoiceBox<?> magazineClassNameBox;

    @FXML
    private TextField commonUserAddrField;

    @FXML
    private ComboBox<?> seMagazineClassBox;

    @FXML
    private ComboBox<?> seMonthBox;

    @FXML
    private ComboBox<?> anMagazineNameBox;

    @FXML
    private TextField magazineMonthPriceField;

    @FXML
    private Label toStatisticButton;

    @FXML
    private TableView<?> fooOrderTableView;

    @FXML
    private TextField magazineOfficeField;

    @FXML
    private ComboBox<?> fooOrderMagazineNameBox;

    @FXML
    private Button imageButton;

    @FXML
    private BorderPane magazinPane;

    @FXML
    private TextField commonUserTelField;

    @FXML
    private BorderPane orderAndMagazineClassPane;

    @FXML
    private TableColumn<?, ?> seTotalPriceColumn;

    @FXML
    private Label toMagazineButton;

    @FXML
    private BarChart<?, ?> magazineBarChart;

    @FXML
    private Label anUserNameLabel;

    @FXML
    private ChoiceBox<?> fooMonthBox;

    @FXML
    private TableColumn<?, ?> magazineIdColumn;

    @FXML
    private TextField commonUserpassField;

    @FXML
    private Label searchLabel;

    @FXML
    private TableColumn<?, ?> seMonthColumn;

    @FXML
    private TableColumn<?, ?> fooMagazineNameColumn;

    @FXML
    private TableColumn<?, ?> fooMagazineClassNameColumn;

    @FXML
    private TextField adminNameField;

    @FXML
    private TableView<?> commonUserTableView;

    @FXML
    private TableColumn<?, ?> seUserNameColumn;

    @FXML
    private TableColumn<?, ?> fooUserNameColumn;

    @FXML
    private TextField magazineNameField;

    @FXML
    private Label logOutButton;

    @FXML
    private Label mostOrderNumUsersOrderNum;

    @FXML
    private PieChart statisticPriceChart;

    @FXML
    private Label mostRichUsersTotalPrice;

    @FXML
    private Label adminPasswordLabel;

    @FXML
    private TableColumn<?, ?> adminIdColumn;

    @FXML
    private ComboBox<?> seMagazineNameBox;

    @FXML
    private TableColumn<?, ?> seMagaNameColumn;

    @FXML
    private Button filterButton;

    @FXML
    private TextField fooTotalPriceField;

    @FXML
    private HBox searchBox;

    @FXML
    private TableColumn<?, ?> seCopiesNumColumn;

    @FXML
    void handleNewOrder(ActionEvent event) {

    }

    @FXML
    void handleDeleteOrder(ActionEvent event) {

    }

    @FXML
    void handleUpdateOrder(ActionEvent event) {

    }

    @FXML
    void handleNewMagazineClass(ActionEvent event) {

    }

    @FXML
    void handleDeleteMagazineClass(ActionEvent event) {

    }

    @FXML
    void handleUpdateMagazineClass(ActionEvent event) {

    }

    @FXML
    void updateSeMagezineClassBox(ActionEvent event) {

    }

    @FXML
    void handleFilter(ActionEvent event) {

    }

    @FXML
    void updateSeMagazineNameBox(ActionEvent event) {

    }

    @FXML
    void updateSeUserNameBox(ActionEvent event) {

    }

    @FXML
    void handleSearch(ActionEvent event) {

    }

    @FXML
    void updateAnUserNameBox(ActionEvent event) {

    }

    @FXML
    void handleNamePricePie(ActionEvent event) {

    }

    @FXML
    void handleClassPricePie(ActionEvent event) {

    }

    @FXML
    void updateAnMagazineNameBox(ActionEvent event) {

    }

    @FXML
    void handleMagazinePriceBarChart(ActionEvent event) {

    }

    @FXML
    void handleMagezineCopiesNumberBarChart(ActionEvent event) {

    }

    @FXML
    void handleSwitchImage(ActionEvent event) {

    }

    @FXML
    void handleNewMagazine(ActionEvent event) {

    }

    @FXML
    void handleDeleteMagezine(ActionEvent event) {

    }

    @FXML
    void handleUpdateMagazine(ActionEvent event) {

    }

    @FXML
    void handleNewCommonUser(ActionEvent event) {

    }

    @FXML
    void handleDeleteCommonUser(ActionEvent event) {

    }

    @FXML
    void handleUpdateCommonUser(ActionEvent event) {

    }

    @FXML
    void handleNewAdmin(ActionEvent event) {

    }

    @FXML
    void handleDeleteAdmin(ActionEvent event) {

    }

    @FXML
    void handleSubmitAdmin(ActionEvent event) {

    }


    @FXML
    void handleToSearch(ActionEvent event) {

    }

    @FXML
    void handleToStatistic(ActionEvent event) {

    }


    @FXML
    void handleToCommonUser(ActionEvent event) {

    }

    @FXML
    void handleToAdmin(ActionEvent event) {

    }

    @FXML
    void handleLogout(ActionEvent event) {

    }

}

