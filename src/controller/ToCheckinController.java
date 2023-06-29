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

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Observable;
import java.util.ResourceBundle;

public class ToCheckinController implements Initializable {
    public TableColumn<ToCheckin, String> tcType;
    public TableColumn<ToCheckin,String> tcNumber;
    public TableColumn<ToCheckin, Double> tcPrice;
    public TableColumn<ToCheckin, String> tcStatus;
    public TableColumn<ToCheckin, Button> tcAction;

    public TextField search;
    public TableView tbNotbooked;


    public void backHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../listview/trangchu.fxml"));
        Main.mainStage.setScene(new Scene(root,1000,600));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tcNumber.setCellValueFactory(new PropertyValueFactory<>("nameRoom"));
        tcPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("st"));
        tcAction.setCellValueFactory(new PropertyValueFactory<>("toCheckin"));
        try {
            ObservableList<ToCheckin> listnotbooked = FXCollections.observableArrayList();
            listnotbooked.addAll(RespositoryFactory.createRepositoryInstance(RepType.ToCheckin).getAll());
            tbNotbooked.setItems(listnotbooked);
            //search
            FilteredList<ToCheckin> filteredRoom = new FilteredList<>(listnotbooked,b->true);
            search.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredRoom.setPredicate(ToCheckin -> {
                    if (newValue.isEmpty() || newValue.equals("")|| newValue == null){
                        return true;

                    }
                    String searchRoomkey = newValue.toLowerCase();
                    if (ToCheckin.getType().indexOf(searchRoomkey)>-1){
                        return true;

                    }
                    return false;
                });
            });
            SortedList<ToCheckin> sortRoom = new SortedList<>(filteredRoom);
            sortRoom.comparatorProperty().bind(tbNotbooked.comparatorProperty());
            tbNotbooked.setItems(sortRoom);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }    }
}
