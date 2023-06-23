package model;

import app.Main;
import controller.FormAddRoom;
import daopattern.RoomIRepository;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Room {
    String nameRoom;
    String type;
    Double price;
    String st;
    private Button edit,delete;

    public Room(String nameRoom, String type, Double price, String st) {

        this.nameRoom = nameRoom;
        this.type = type;
        this.price = price;
        this.st = st;
        this.edit=new Button("EDIT");
        this.delete=new Button("DELETE");
        this.edit.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../listview/formAddRoom.fxml"));
                Parent root = loader.load();
                FormAddRoom fa = loader.getController();
                fa.setEditRoom(this);
                Main.mainStage.setScene(new Scene(root,1000,650));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        });
        this.delete.setOnAction(event -> {
           try {
               RoomIRepository rr = new RoomIRepository();
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
               alert.setTitle("Delete Room");
               alert.setHeaderText("Are you sure want to move this file to the Recycle Bin?");
               alert.setContentText("Name Room : " + this.getNameRoom());

               //option != null
               Optional<ButtonType> option = alert.showAndWait();
               if (option.get() == null) {
                   this.delete.setText("No selection!");
               } else if (option.get()==ButtonType.OK) {
                   this.delete.setText("Room deleted!");
                   rr.deleteRoom(this);//deleteRoom
               } else if(option.get() == ButtonType.CANCEL) {
                   this.delete.setText("Cancelled!");
               } else {
                   this.delete.setText("-");
               }
               FXMLLoader loader = new FXMLLoader(getClass().getResource("../listview/room.fxml"));
               Parent root = loader.load();
               Main.mainStage.setScene(new Scene(root , 1000,600));

           } catch (Exception e) {

           }


        });
    }

    public Room() {
    }

    public Room(String nameRoom, String type, Double price) {

    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }
    public Button getDelete() {
        return delete;
    }
    public Button getEdit() {
        return  edit;
    }

}