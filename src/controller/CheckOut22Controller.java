package controller;

import java.sql.Statement;
import app.Main;
import daopattern.CheckRepository;
import database.Connector;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Check;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.Date;

import java.time.LocalDate;

public class CheckOut22Controller {
    public TextField txtNameRoom;
    public TextField txtPrice;
    public TextField txtNameCustomer;
    public TextField txtCccd;
    public TextField txtPhoneNumber;
    public TextField txtCheckIn;
    public DatePicker txtCheckOut;
    public Check editData;

    public void setEditData(Check editData) {
        txtNameRoom.setText(editData.getRoom());
        txtNameCustomer.setText(editData.getPrice());
        txtPhoneNumber.setText(editData.getNameCus());
        txtPrice.setText(editData.getPhoneNumber());
        txtCccd.setText(editData.getCccD());
        txtCheckIn.setText(toString().valueOf(editData.getCheckIn()));
    }


    public void back(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../listview/checkout.fxml"));
        Main.mainStage.setScene(new Scene(root,1000,600));
    }
    public void deleteCheckIn() {
        try {
            String nameRoom = txtNameRoom.getText();
            Connection conn = Connector.getInstance().getConn();
            String sql_txt = "DELETE FROM orders where nameRoom=?";
            PreparedStatement stq = conn.prepareStatement(sql_txt);
            stq.setString(1,nameRoom);
            stq.execute();
        } catch (Exception e) {

        }

    }


    public void finish(ActionEvent actionEvent) throws Exception {
        String nameRoom = txtNameRoom.getText();
        String nameCustomer = txtNameCustomer.getText();
        String price = txtPrice.getText();
        Date checkIn = Date.valueOf(txtCheckIn.getText());
        String cccd=txtCccd.getText();
        String phoneNumber = txtPhoneNumber.getText();
        LocalDate check = txtCheckOut.getValue();
        Date c =  Date.valueOf(check);
        try {

            Check ch = new Check(nameRoom,price,phoneNumber,nameCustomer,cccd,checkIn,c);

            Connection conn = Connector.getInstance().getConn();
            String sql = "insert into bill(nameRoom,price,customerName,cccd,phoneCustomer,checkIn,checkOut) values(?,?,?,?,?,?,?)";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1,nameRoom);
            stt.setString(2, price);
            stt.setString(3,nameCustomer);
            stt.setString(4,cccd);
            stt.setString(5,phoneNumber);
            stt.setDate(6,checkIn);
            stt.setDate(7, c);
            stt.executeUpdate();
            //
            String sql_txt = "update room set st=? where nameRoom=?";
            PreparedStatement stq = conn.prepareStatement(sql_txt);
            stq.setString(1,"NOT BOOKED");
            stq.setString(2,nameRoom);
            stq.executeUpdate();

            String sql_txt1 = "DELETE FROM orders where roomName=?";
            PreparedStatement stq1 = conn.prepareStatement(sql_txt1);
            stq1.setString(1,nameRoom);
            stq1.execute();


        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        JOptionPane.showMessageDialog(null,"Are you sure you want to pay for the room :" + nameRoom);




        Parent root = FXMLLoader.load(getClass().getResource("../listview/bill.fxml"));
        Main.mainStage.setScene(new Scene(root,1000,600));
    }

}