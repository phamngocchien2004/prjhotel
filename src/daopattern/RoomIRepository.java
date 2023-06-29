package daopattern;

import database.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RoomIRepository implements IRespository<Room> {
    private static RoomIRepository instance;

    public RoomIRepository() {

    }

    public static RoomIRepository getInstance() {
        if (instance == null) {
            instance = new RoomIRepository();
        }
        return instance;
    }

    @Override
    public ArrayList<Room> getAll() {
        ArrayList<Room> rooms = new ArrayList<>();

        // query
        try {


            Connection conn = Connector.getInstance().getConn();
            Statement stt = conn.createStatement();
            String sql = "select * from room";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                String room = rs.getString("nameRoom");
                String type = rs.getString("type");
                Double price = (double) rs.getInt("price");
                String st = rs.getString("status");
                Room s = new Room(room, type, price, st);
                rooms.add(s);
            }
        } catch (Exception e) {

        }
        return rooms;
    }

    @Override
    public ArrayList<Room> getAll1() {
        return null;
    }

    @Override
    public Boolean create(Room room) {
        try {
            Connection conn = Connector.getInstance().getConn();
            String sql = "insert into room(nameRoom,type,price) values(?,?,?)";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1, room.getNameRoom());
            stt.setString(2, room.getType());
            stt.setDouble(3, room.getPrice());
            stt.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public Boolean editRoom(Room room) {
        String sql_txt = "update room set type=?,price=?,st=? where nameRoom=?";
        try {
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1, room.getType());
            stt.setDouble(2, room.getPrice());
            stt.setString(3, room.getSt());
            stt.setString(4, room.getNameRoom());
            stt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    @Override
    public Room find(Integer id) {
        return null;
    }

    @Override
    public Boolean deleteRoom(Room room) {
        String sql_text = "DELETE FROM room where nameRoom=?";
        try {
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_text);
            stt.setString(1, room.getNameRoom());
            stt.execute();
        } catch (Exception e) {

        }
        return null;
    }

}