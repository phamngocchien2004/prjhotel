package controller;

import Factory.RespositoryFactory;
import app.Main;
import enums.RepType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ToCheckin;
import model.ToCheckout;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class ToCheckoutController implements Initializable {

    public TableView tbroombooked;
    public TableColumn<ToCheckout, String> tcName;
    public TableColumn<ToCheckout, String> tcId;
    public TableColumn<ToCheckout, String> tcPhone;
    public TableColumn<ToCheckout, String> tcType;
    public TableColumn<ToCheckout, String> tcNumber;
    public TableColumn<ToCheckout, Double> tcPrice;
    public TableColumn<ToCheckout, String> tcTimein;
    public TableColumn<ToCheckout, Button> toAction;
    public TextField search;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tcType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tcNumber.setCellValueFactory(new PropertyValueFactory<>("nameRoom"));
        tcPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tcTimein.setCellValueFactory(new PropertyValueFactory<>("timeIN"));
        toAction.setCellValueFactory(new PropertyValueFactory<>("onAction"));
        try {
            ObservableList<ToCheckout> listbooked = FXCollections.observableArrayList();
            listbooked.addAll(RespositoryFactory.createRepositoryInstance(RepType.ToCheckout).getAll());
            tbroombooked.setItems(listbooked);


            //search
            FilteredList<ToCheckout> filteredList = new FilteredList<>(listbooked,b->true);
            search.textProperty().addListener((observable, oldValue, newValue) -> {
              filteredList.setPredicate(ToCheckout -> {
                  if (newValue.isEmpty() || newValue.equals("")|| newValue == null){
                      return true;

                  }
                  String searchRoomkey = newValue.toLowerCase();
                  if (ToCheckout.getType().indexOf(searchRoomkey)>-1){
                      return true;

                  }
                  return false;
              });
            });
            SortedList<ToCheckout> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(tbroombooked.comparatorProperty());
            tbroombooked.setItems(sortedList);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    public void backHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../listview/trangchu.fxml"));
        Main.mainStage.setScene(new Scene(root,1000,600));
    }
}
