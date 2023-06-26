package daopattern;

import database.Connector;
import model.Checkin;
import model.Room;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.SimpleTimeZone;

public class CheckinReposity implements IRespository<Checkin> {
    private  static CheckinReposity instance;
    private CheckinReposity(){



    }

    public static CheckinReposity getInstance(){
        if (instance == null){
            instance = new CheckinReposity();
        }
        return instance;
    }

    @Override
    public ArrayList<Checkin> getAll() {
        ArrayList<Checkin> checkins = new ArrayList<>();
        try {

            Connection conn = Connector.getInstance().getConn();
            String sql = "select * from checkin";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()){
                String name = rs.getString("name");
                String id = rs.getString("id");
                String phone = rs.getString("phone");
                String time = rs.getString("timeIN");
                String type = rs.getString("type");
                String nameRoom = rs.getString("number");
                Double price = (double) rs.getInt("price");
                Checkin checkin = new Checkin(name,id,phone,time, type, nameRoom, price);
                checkins.add(checkin);


            }
        } catch (Exception e){
            System.out.println(e.getMessage());

        }        return checkins;
    }

    @Override
    public Boolean create(Checkin checkin) {
        try {

            Connection conn = Connector.getInstance().getConn();
            String sql = "insert into checkin(name,id,phone,timeIN,type,nameRoom,price) values (?,?,?,?,?,?,?)";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1, checkin.getName());
            stt.setString(2,checkin.getId());
            stt.setString(3,checkin.getPhone());
            stt.setString(4,checkin.getTime());
            stt.setString(5,checkin.getType());
            stt.setString(6,checkin.getNameRoom());
            stt.setDouble(7,checkin.getPrice());
            stt.executeUpdate();
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean editRoom(Checkin checkin) {
        return null;
    }

    @Override
    public Room find(Integer id) {
        return null;
    }

    @Override
    public Boolean deleteRoom(Checkin checkin) {
        return null;
    }
}
