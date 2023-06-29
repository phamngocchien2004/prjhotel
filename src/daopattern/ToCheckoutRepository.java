package daopattern;

import database.Connector;
import model.Room;
import model.ToCheckout;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ToCheckoutRepository implements IRespository<ToCheckout> {
    private static ToCheckoutRepository instance;
    public ToCheckoutRepository(){};
    public static ToCheckoutRepository getInstance(){
        if (instance == null){
            instance = new ToCheckoutRepository();
        }
        return instance;
    }
    @Override
    public ArrayList<ToCheckout> getAll() {
        ArrayList<ToCheckout> toCheckouts = new ArrayList<>();
        try {
            Connection conn = Connector.getInstance().getConn();
            Statement stt = conn.createStatement();
            String sql ="select * from checkin ";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()){
                String name = rs.getString("name");
                String id = rs.getString("id");
                String phone = rs.getString("phone");
                String type = rs.getString("type");
                String nameRoom = rs.getString("nameRoom");
                Double price = (double) rs.getInt("price");
                String timeIN = rs.getString("timeIN");
                ToCheckout t = new ToCheckout(name,id,phone,type,nameRoom,price,timeIN);
                toCheckouts.add(t);

            }        } catch (Exception e){
            System.out.println(e.getMessage());

        }        return toCheckouts;
    }

    @Override
    public ArrayList<ToCheckout> getAll1() {
        return null;
    }

    @Override
    public Boolean create(ToCheckout toCheckout) {
        return null;
    }

    @Override
    public Boolean editRoom(ToCheckout toCheckout) {
        return null;
    }

    @Override
    public Room find(Integer id) {
        return null;
    }

    @Override
    public Boolean deleteRoom(ToCheckout toCheckout) {
        return null;
    }
}
