package controller;

import daopattern.CheckRepository;
import Factory.RepositoryFactoryCheckOut;
import app.Main;
import enums.RepositoryType;
import Factory.RepositoryFactoryCheckOut;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.util.ResourceBundle;


import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import model.Check;
import model.Room;

public class CheckOutController implements Initializable {
    public TableColumn<Check,String> tcRoom;
    public TableColumn<Check,String> tcPrice;
    public TableColumn<Check,String> tcCus;
    public TableColumn<Check,String> tcPhone;
    public TableColumn<Check,String> tcCC;
    public TableView<Check> tbV;
    public TableColumn<Check,Date> tcCheckIn;
    public TableColumn<Check, Button> tcEdit;
    public TableColumn<Check,Button> tcAction;
    public TextField search;


    public void backHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../listview/trangchu.fxml"));
        Main.mainStage.setScene(new Scene(root,1000,600));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcRoom.setCellValueFactory(new PropertyValueFactory<>("room"));
        tcPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tcCus.setCellValueFactory(new PropertyValueFactory<>("nameCus"));
        tcPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        tcCC.setCellValueFactory(new PropertyValueFactory<>("cccD"));
        tcCheckIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        tcAction.setCellValueFactory(new PropertyValueFactory<>("action"));


        try {
            ObservableList<Check> list = FXCollections.observableArrayList();
            list.addAll(RepositoryFactoryCheckOut.createRepositoryInstance(RepositoryType.Check).getAll());
            tbV.setItems(list);
            // search room
            FilteredList<Check> filterData = new FilteredList<>(list, b->true);
            search.textProperty().addListener((observable ,oldValue,newValue ) ->{
                filterData.setPredicate(Check -> {
                    if(newValue.isEmpty() || newValue.equals("") || newValue == null){
                        return true;
                    }
                    String searchKey = newValue.toLowerCase();
                    if (Check.getRoom().indexOf(searchKey)>-1){
                        return true;
                    } else if (Check.getNameCus().indexOf(searchKey)>-1) {
                        return true;

                    }

                    return false;
                });


            });
            SortedList<Check> sortData = new SortedList<>(filterData);
            sortData.comparatorProperty().bind(tbV.comparatorProperty());
            tbV.setItems(sortData);



        }catch (Exception e){
            System.out.println("errror: " + e.getMessage());

        }
    }

}