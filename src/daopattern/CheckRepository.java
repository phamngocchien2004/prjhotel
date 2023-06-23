package daopattern;

import database.Connector;
import model.Check;

import java.sql.*;
import java.util.ArrayList;

public class CheckRepository implements IRepository<Check> {
    private static CheckRepository instance;
    private CheckRepository(){

    }

    public static CheckRepository getInstance() {
        if (instance == null) {
            instance = new CheckRepository();
        }
        return instance;
    }
    @Override
    public ArrayList<Check> getAll() {
        ArrayList<Check> checks = new ArrayList<>();
        try {
            Connection conn = Connector.getInstance().getConn();
            String sql = "select * from orders";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                String room = rs.getString("roomName");
                String price = rs.getString("roomPrice");
                String phoneNumber = rs.getString("customerPhone");
                String nameCus = rs.getString("customerName");
                String cccD = rs.getString("customerID");
                Date checkIn = rs.getDate("dateIN");

                Check ch = new Check(room,price,phoneNumber,nameCus,cccD,checkIn);
                checks.add(ch);
            }
        } catch ( Exception e){
            System.out.println(e.getMessage());

        }
        return checks;
    }

    @Override
    public Boolean create(Check check) {
        try {
            Connection conn = Connector.getInstance().getConn();
            String sql = "insert into bill(nameRoom,price,customerName,cccd,phoneCustomer,checkIn,checkOut) values(?,?,?,?,?,?,?)";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1,check.getRoom());
            stt.setString(2, check.getPrice());
            stt.setString(3,check.getNameCus());
            stt.setString(4,check.getCccD());
            stt.setString(5,check.getPhoneNumber());
            stt.setDate(6,check.getCheckIn());
            stt.setDate(7, check.getCheckOut());
            stt.executeUpdate();
            return true;
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public Boolean update(Check check) {
        return null;
    }

    @Override
    public Boolean delete(Check check) {
        return null;
    }

    @Override
    public Check find(String id) {
        return null;
    }

    @Override
    public Check find(Integer id) {
        return null;
    }

}
