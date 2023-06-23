package controller;

import Factory.RespositoryFactory;
import app.Main;
import daopattern.RoomIRepository;
import database.Connector;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Room;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    public static ObservableList<Room> listRooms = FXCollections.observableArrayList();
    public TableView<Room> tbV;
    public TableColumn<Room, String> tcRoom;
    public TableColumn<Room, String> tcType;

    public TableColumn<Room, Double> tcPrice;
    public TableColumn<Room, String> tcStatus;
    public TableColumn<Room,Button> tcEditRoom;
    public TableColumn<Room, Button> tcDeleteRoom;
    public TextField search;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tcRoom.setCellValueFactory(new PropertyValueFactory<>("nameRoom"));
        tcType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tcPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("st"));
        tcEditRoom.setCellValueFactory(new PropertyValueFactory<>("edit"));
        tcDeleteRoom.setCellValueFactory(new PropertyValueFactory<>("delete"));
        try {
            ObservableList<Room> listRooms = FXCollections.observableArrayList();
            listRooms.addAll(RespositoryFactory.createRepositoryInstance(RepType.ROOM).getAll());
            tbV.setItems(listRooms);
            // search room
            FilteredList<Room> filterData = new FilteredList<>(listRooms,b->true);
            search.textProperty().addListener((observable ,oldValue,newValue ) ->{
                filterData.setPredicate(Room -> {
                    if(newValue.isEmpty() || newValue.equals("") || newValue == null){
                        return true;
                    }
                    String searchKey = newValue.toLowerCase();
                    if(Room.getNameRoom().toLowerCase().indexOf(searchKey)>-1){
                        return true;
                    } else if (Room.getType().toLowerCase().indexOf(searchKey)>-1) {
                        return true;

                    } else if (Room.getSt().toLowerCase().indexOf(searchKey)>-1) {
                        return true;

                    } else if (Room.getPrice().toString().indexOf(searchKey)>-1) {
                        return true;

                    }

                    return false;
                });


            });
            SortedList<Room> sortData = new SortedList<>(filterData);
            sortData.comparatorProperty().bind(tbV.comparatorProperty());
            tbV.setItems(sortData);

        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }

              };


    public void create(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../listview/formAddRoom.fxml"));
        Main.mainStage.setScene(new Scene(root,1000,600));


    }

    public void backHome(ActionEvent actionEvent) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../listview/trangchu.fxml"));
        Main.mainStage.setScene(new Scene(root,1000,600));
    }
}