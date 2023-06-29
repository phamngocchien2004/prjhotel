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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Bill;

import java.net.URL;
import java.util.ResourceBundle;

public class BillController implements Initializable {

    public TableView<Bill> tVb;
    public TableColumn <Bill,String> txtName;
    public TableColumn <Bill,String>txtPhone;
    public TableColumn <Bill,String>txtRoom;
    public TableColumn <Bill,String>txtIn;
    public TableColumn <Bill,String> txtOut;
    public TableColumn <Bill,String>txtPrice;
    public TextField search;
    public TableColumn<Bill,Integer> txtId;


    public void goToHome(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../listview/trangchu.fxml"));
        Main.mainStage.setScene(new Scene(root,1000,600));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtId.setCellValueFactory(new PropertyValueFactory<>("id"));
        txtPhone.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        txtPrice.setCellValueFactory(new PropertyValueFactory<>("phoneCustomer"));
        txtRoom.setCellValueFactory(new PropertyValueFactory<>("nameRoom"));
        txtIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        txtOut.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        txtName.setCellValueFactory(new PropertyValueFactory<>("price"));


        try {

            ObservableList<Bill> list = FXCollections.observableArrayList();
           list.addAll(RespositoryFactory.createRepositoryInstance(RepType.Bill).getAll());
            tVb.setItems(list);
            // search bill
           FilteredList<Bill> filterData = new FilteredList<>(list,b->true);
           search.textProperty().addListener((observable, oldValue, newValue) -> {
               filterData.setPredicate(Bill ->{
                   if(newValue.isEmpty() || newValue.equals("") ||newValue == null) {
                       return true;
                   }
                   String searchKey = newValue.toLowerCase();
                   if (Bill.getNameRoom().toLowerCase().indexOf(searchKey)>-1){
                       return  true;
                   }else if (Bill.getCustomerName().toLowerCase().indexOf(searchKey) >-1) {
                       return true;
                   }else if (Bill.getPhoneCustomer().toLowerCase().indexOf(searchKey) >-1) {
                       return true;
                   }else if (Bill.getCheckIn().toString().indexOf(searchKey) >-1) {
                       return true;
                   }else if (Bill.getCheckOut().toString().indexOf(searchKey) >-1) {
                       return true;
                   }else if (Bill.getPrice().toLowerCase().indexOf(searchKey) >-1) {
                       return true;
                   }
                   return false;

               });
           });
           SortedList<Bill> sortData = new SortedList<>(filterData);
           sortData.comparatorProperty().bind(tVb.comparatorProperty());
           tVb.setItems(sortData);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
