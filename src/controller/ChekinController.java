package controller;

import Factory.RespositoryFactory;
import app.Main;
import database.Connector;
import enums.RepType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Checkin;
import model.ToCheckin;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChekinController implements Initializable {


    public TextField txtName;
    public TextField txtId;
    public TextField txtPhone;
    public TextField txtTime;


    public TextField txtPrice;
    public TextField txtType;
    public TextField txtNumber;
    public ToCheckin editCheckin;
    public TextField txtDateOut;
    public TextField txtTotal;


    public void tobackHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../listview/toCheckin.fxml"));
        Main.mainStage.setScene(new Scene(root, 1000, 600));

    }


    public void toCheckin(ActionEvent actionEvent) throws IOException {
        try {
            String name = txtName.getText();
            String id = txtId.getText();
            String phone = txtPhone.getText();
//            Calendar cal = Calendar.getInstance();
//            int nam = cal.get(Calendar.YEAR);
//            int thang = cal.get(Calendar.MONTH);
//            int ngay = cal.get(Calendar.DAY_OF_MONTH);
//            SimpleDateFormat obj = new SimpleDateFormat("hh:mm:ss yyyy/MM/dd a");
//            java.util.Date d = cal.getTime();
//            String time = obj.format(d);
//            // combobox chon type va phong
           String type = txtType.getText();
           String nameRoom = txtNumber.getText();
            LocalDateTime dateOut = LocalDateTime.now();
            txtTime.setText(String.valueOf(dateOut));


            double price = Double.parseDouble(txtPrice.getText());
            Checkin checkin = new Checkin(name, id, phone, type, nameRoom, price);
            if (RespositoryFactory.createRepositoryInstance(RepType.Checkin).create(checkin))
                tobackHome(null);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        Parent root = FXMLLoader.load(getClass().getResource("../listview/trangchu.fxml"));
        Main.mainStage.setScene(new Scene(root, 1000, 600));
    }








    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void editCheckin(ToCheckin editCheckin) {
        this.editCheckin = editCheckin;
        this.txtType.setText(editCheckin.getType());
        this.txtNumber.setText(editCheckin.getNameRoom());
        this.txtPrice.setText(toString().valueOf(editCheckin.getPrice()));
    }
}

