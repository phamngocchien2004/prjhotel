package daopattern;

import database.Connector;
import model.Bill;
import model.Room;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

public class BillIRepository implements IRespository<Bill> {
    private static BillIRepository instance;

    private BillIRepository() {

    }
    public static BillIRepository getInstance() {
        if (instance == null) {
            instance = new BillIRepository();
        }
        return instance;
    }
    @Override
    public ArrayList<Bill> getAll() {
        ArrayList<Bill> bills =new ArrayList<>();
        try {
            Connection conn = Connector.getInstance().getConn();
            String sql ="select * from bill";
            Statement stt = conn.createStatement();
            ResultSet rs =stt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nameR = rs.getString("nameRoom");
                String phoneN = rs.getString("phoneCustomer");
                String price = rs.getString("price");
                String customerName = rs.getString("customerName");
                Date checkIn = rs.getDate("checkIn");
                Date checkOut = rs.getDate("checkOut");
                Bill b = new Bill(id,nameR,phoneN,price,customerName,checkIn,checkOut);
                bills.add(b);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return bills;
    }

    @Override
    public Boolean create(Bill bill) {
        return null;
    }

    @Override
    public Boolean editRoom(Bill bill) {
        return null;
    }

    @Override
    public Room find(Integer id) {
        return null;
    }

    @Override
    public Boolean deleteRoom(Bill bill) {
        return null;
    }


}
