package team.gym.Controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import team.gym.Beans.Customer;
import team.gym.Beans.User;


import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class UserController {
    @FXML
    private TableColumn<User, String> gender;

    @FXML
    private TableColumn<Customer, String> level;

    @FXML
    private TableView<Customer> usertable;

    @FXML
    private TableColumn<Customer, String> name;

    @FXML
    private TableColumn<Customer, String> account;

    private ObservableList<Customer> userData = FXCollections.observableArrayList();

    @FXML
    private void initialize(){
        userData.add(new Customer());
        userData.add(new Customer());
        userData.add(new Customer());
        usertable.setItems(userData);
        usertable.getSelectionModel().selectFirst();

        account.setCellValueFactory(cellData -> cellData.getValue().accountProperty());
        gender.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        level.setCellValueFactory(cellData -> cellData.getValue().levelProperty());
        name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    }

}