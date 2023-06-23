package model;

import app.Main;
import controller.CheckOut22Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.sql.Date;
import java.time.LocalDate;



public class Check {
    Integer id;
    private String room;
    private String price;
    private String phoneNumber;
    private String nameCus;
    private String cccD;
    Date checkIn;
    Date checkOut;
    Button action;


    public Check(String room,Integer id, String price, String phoneNumber, String nameCus, String cccD, Date checkIn, Date checkOut) {
        this.room = room;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.nameCus = nameCus;
        this.cccD = cccD;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.id=id;



    }

    public Check(String room, String price, String phoneNumber, String nameCus, String cccD, Date checkIn) {
        this.room = room;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.nameCus = nameCus;
        this.cccD = cccD;
        this.checkIn = checkIn;
        this.action=new Button("Check Out");


        this.action.setOnAction(event -> {
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

    public Check(String nameRoom, String price, String phoneNumber, String nameCustomer, String cccd, Date checkIn, Date c) {
    }


    public  String getRoom() {return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getCccD() {
        return cccD;
    }

    public void setCccD(String cccD) {
        this.cccD = cccD;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Button getAction() {
        return action;
    }

    public void setAction(Button action) {
        this.action = action;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}