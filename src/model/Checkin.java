package model;

import java.util.Date;

public class Checkin {


    public String name;
    public String id;
    public String phone;
    public String time;
    public String type;
    public String nameRoom;
    public double price;


    public Checkin(String name, String id, String phone,String time, String type, String nameRoom, double price ) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.type = type;
        this.nameRoom = nameRoom;
        this.price = price;
        this.time = time;
    }

    public Checkin(String name, String id, String phone, String time, double price) {
    }

    public Checkin(String name, String id, String phone, String type, String nameRoom, double price) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
