package model;

import java.sql.Date;

public class Order {
    private String nameRoom;
    private String priceRoom;
    private String nameCus;
    private String idCus;
    private String phoneCus;
    private Date dateIn;

    public Order() {

    }

    public Order(String nameRoom, String priceRoom, String nameCus, String idCus, String phoneCus, Date dateIn) {
        this.nameRoom = nameRoom;
        this.priceRoom = priceRoom;
        this.nameCus = nameCus;
        this.idCus = idCus;
        this.phoneCus = phoneCus;
        this.dateIn = dateIn;
    }


    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getPriceRoom() {
        return priceRoom;
    }

    public void setPriceRoom(String priceRoom) {
        this.priceRoom = priceRoom;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getIdCus() {
        return idCus;
    }

    public void setIdCus(String idCus) {
        this.idCus = idCus;
    }

    public String getPhoneCus() {
        return phoneCus;
    }

    public void setPhoneCus(String phoneCus) {
        this.phoneCus = phoneCus;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }
}
