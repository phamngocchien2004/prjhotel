package model;

import app.Main;
import controller.CheckOut22Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class ToCheckout {
    private String name;
    private  String id;
    private String phone;
    private String type;
    private String nameRoom;
    private double price;
    String TimeIN;


    Button onAction;




    public ToCheckout(String name, String id, String phone, String type, String nameRoom, double price, String timeIN) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.type = type;
        this.nameRoom = nameRoom;
        this.price = price;
        this.TimeIN = timeIN;
        this.onAction=new Button("Check Out");
        this.onAction.setOnAction(event -> {
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../listview/list.fxml"));
                Parent root = loader.load();
                CheckOut22Controller c22 = loader.getController();
                c22.setEditData(this);
                Main.mainStage.setScene(new Scene(root,1000,600));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        });

    }

    public ToCheckout(String nameCustomer, String cccd, String phoneNumber, String nameRoom, String price) {
    }

    public String getTimeIN() {
        return TimeIN;
    }

    public void setTimeIN(String timeIN) {
        TimeIN = timeIN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Button getOnAction() {
        return onAction;
    }

    public void setOnAction(Button onAction) {
        this.onAction = onAction;
    }

}
