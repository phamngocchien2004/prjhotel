package controller;

import app.Main;
import com.mysql.jdbc.ResultSet;
import database.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LoginController {
    public TextField txtUser;
    public PasswordField txtPassword;
    PreparedStatement pst;
    ResultSet rs;

    public void login(ActionEvent actionEvent) throws Exception {
        String userName = txtUser.getText();
        String pass = txtPassword.getText();
        if(userName.equals("")) {
            JOptionPane.showMessageDialog(null,"User Name is not blank");
        } else if (pass.equals("")) {
            JOptionPane.showMessageDialog(null,"Password is not blank");

        }  else
        {
            try{
            Connection conn = Connector.getInstance().getConn();
            pst = conn.prepareStatement("select * from admin where user=? and password=?");
            pst.setString(1,userName);
            pst.setString(2,pass);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                Parent root = FXMLLoader.load(getClass().getResource("../listview/trangchu.fxml"));
                Main.mainStage.setScene(new Scene(root,1000,600));
            } else {
                JOptionPane.showMessageDialog(null,"Incorrect account or password");
            }

        }
        catch (Exception e){


            }
        }
    }
}

