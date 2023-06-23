package controller;

import Factory.RespositoryFactory;
import app.Main;
import enums.RepType;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Order;

import javax.swing.*;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class CheckInController  {


    public TextField txtNameRoom;
    public TextField txtPrice;
    public TextField txtNameCus;
    public TextField txtIDCus;
    public TextField txtTelCus;
    public DatePicker txtDateIn;


    public void backHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../listview/trangchu.fxml"));
        Main.mainStage.setScene(new Scene(root,1000,600));

    }

    public void checkIn(ActionEvent actionEvent) {
        try {
            String nameR = txtNameRoom.getText();
            String priceR = txtPrice.getText();
            String nameC = txtNameCus.getText();
            String idC = txtIDCus.getText();
            String phoneC = txtTelCus.getText();
            LocalDate dateIn = txtDateIn.getValue();
            Date d = Date.valueOf(dateIn);
            Order o = new Order(nameR,priceR,nameC,idC,phoneC,d);
            if (RespositoryFactory.createRepositoryInstance(RepType.Order).create(o))
                backHome(null);
            else throw new Exception();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }

    }
}
