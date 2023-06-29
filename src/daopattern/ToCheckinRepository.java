package daopattern;

import database.Connector;
import model.Room;
import model.ToCheckin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ToCheckinRepository implements IRespository<ToCheckin> {
    private  static ToCheckinRepository instance;
    public  ToCheckinRepository(){};
    public static ToCheckinRepository getInstance(){
        if (instance == null ){
            instance = new ToCheckinRepository();

        }
        return instance;
    }

    @Override
    public ArrayList<ToCheckin> getAll() {
        ArrayList<ToCheckin> toCheckins = new ArrayList<>();
        //query
        try {
            Connection conn = Connector.getInstance().getConn();
            Statement stt = conn.createStatement();
            String sql ="select * from room where status ='not booked' ";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()){
                String type = rs.getString("type");
                String nameRoom = rs.getString("nameRoom");
                Double price = (double) rs.getInt("price");
                String status = rs.getString("status");
                ToCheckin t = new ToCheckin(type,nameRoom,price,status);
                toCheckins.add(t);



            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return toCheckins;
    }

    @Override
    public ArrayList<ToCheckin> getAll1() {
        return null;
    }

    @Override
    public Boolean create(ToCheckin toCheckin) {
        return null;
    }

    @Override
    public Boolean editRoom(ToCheckin toCheckin) {
        return null;
    }

    @Override
    public Room find(Integer id) {
        return null;
    }

    @Override
    public Boolean deleteRoom(ToCheckin toCheckin) {
        return null;
    }
}
