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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Room;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;

public class ManegeController implements Initializable {
    public TableView<Room> tbV;
    public TableColumn<Room, String> tcRoom;
    public TableColumn<Room, String> tcType;

    public TableColumn<Room, Double> tcPrice;
    public TableColumn<Room, String> tcStatus;
    public TextField search;

    public void manageRoom(ActionEvent actionEvent) throws Exception {
        Parent root = load(getClass().getResource("../listview/room.fxml"));
        Main.mainStage.setScene(new Scene(root, 1000, 600));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tcRoom.setCellValueFactory(new PropertyValueFactory<>("nameRoom"));
        tcType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tcPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("st"));
        try {
            ObservableList<Room> listRooms = FXCollections.observableArrayList();
            listRooms.addAll(RespositoryFactory.createRepositoryInstance(RepType.ROOM).getAll());
            tbV.setItems(listRooms);
            FilteredList<Room> filterData = new FilteredList<>(listRooms, b->true);
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
    }

    public void logOut(ActionEvent actionEvent) throws Exception {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Messages");
            alert.setContentText("Are you sure you want to sign out?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get()== ButtonType.OK) {
                Parent root = load(getClass().getResource("../listview/login.fxml"));
                Main.mainStage.setScene(new Scene(root,700,500));
            }

        } catch (Exception e) {

        }
    }

    public void CheckIn(ActionEvent actionEvent) throws Exception {
        Parent root = load(getClass().getResource("../listview/checkin.fxml"));
        Main.mainStage.setScene(new Scene(root, 1000, 600));

    }

    public void checkOut(ActionEvent actionEvent) throws Exception {
        Parent root = load(getClass().getResource("../listview/checkout.fxml"));
        Main.mainStage.setScene(new Scene(root, 1000, 600));

    }



    public void goToBill(ActionEvent actionEvent) throws Exception{
        Parent root = load(getClass().getResource("../listview/bill.fxml"));
        Main.mainStage.setScene(new Scene(root,1000,600));
    }
}
