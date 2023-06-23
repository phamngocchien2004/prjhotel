package model;

import java.sql.Date;

public class Bill {
    Integer id;

    private String nameRoom;
    private String price;
    private String customerName;
    private String cccd;
    private String phoneCustomer;
    private Date checkIn;
    private Date checkOut;

    public Bill( Integer id,String nameRoom, String price, String customerName,String phoneCustomer,  Date checkIn, Date checkOut) {
        this.id=id;
        this.nameRoom = nameRoom;
        this.price = price;
        this.customerName = customerName;
        this.phoneCustomer = phoneCustomer;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
}