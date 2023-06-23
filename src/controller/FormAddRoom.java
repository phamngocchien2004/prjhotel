package controller;

import Factory.RespositoryFactory;
import app.Main;
import enums.RepType;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Check;
import model.Room;

public class FormAddRoom {

    public TextField txtNameRoom;
    public TextField txtType;
    public TextField txtPrice;
    public TextField txtStatus;
    public Room editRoom;
    public void setEditRoom (Room editRoom)
    {
        this.editRoom=editRoom;
        this.txtNameRoom.setText(editRoom.getNameRoom());
        this.txtPrice.setText(toString().valueOf(editRoom.getPrice()));
        this.txtType.setText(editRoom.getType());
        this.txtStatus.setText(editRoom.getSt());
    }
    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../listview/room.fxml"));
        Main.mainStage.setScene(new Scene(root, 1000, 600));
    }
    public void add(ActionEvent actionEvent) throws Exception {

        try {
            String nameRoom = txtNameRoom.getText();
            String type = txtType.getText();
            Double price = Double.valueOf(txtPrice.getText());
            String st = txtStatus.getText();

            if (nameRoom.equals("") ){
                throw new Exception("Please enter full room information!");
            }else if (price <= 0) {
                throw new Exception("The price must be greater than 0!");

            } /*else if (price.toString().i ) {
                throw new Exception("jjj");

                
            }*/ else
                if(type.equals("")){
                    throw new Exception("Please enter full room information!");
                }
                Room room = new Room(nameRoom, type, price,st);
                if (this.editRoom == null) {
                    if (RespositoryFactory.createRepositoryInstance(RepType.ROOM).create(room)) {
                        back(null);
                    }
                } else {
                    if(RespositoryFactory.createRepositoryInstance(RepType.ROOM).editRoom(room)) {
                        back(null);
                    }

                }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }

            }

}

