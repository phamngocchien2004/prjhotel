package model;

import java.awt.*;

import app.Main;
import controller.ChekinController;
import controller.ToCheckinController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class ToCheckin {
    private String type;
    private String nameRoom;
    private  double price;
    private String st;
    Button toCheckin;



    public ToCheckin(String type, String nameRoom, double price, String st) {
        this.type = type;
        this.nameRoom = nameRoom;
        this.price = price;
        this.st = st;
        this.toCheckin = new Button("Check In");


        this.toCheckin.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../listview/checkin.fxml"));
                Parent root = loader.load();
                ChekinController to = loader.getController();
                to.editCheckin(this);
                Main.mainStage.setScene(new Scene(root,1000,600));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public Button getToCheckin() {
        return toCheckin;
    }

    public void setToCheckin(Button toCheckin) {
        this.toCheckin = toCheckin;
    }
}
