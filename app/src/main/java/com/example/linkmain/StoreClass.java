package com.example.linkmain;

public class StoreClass {
    private String storename;
    private String categoly;
    private String address;
    private double point_x;
    private double point_y;
    private String phone;
    private String worktime;
    private String notworktime;
    private int parking;

    public StoreClass(String storename, String catrgoly, String address, double point_x, double point_y, String phone, String worktime, String notworktime, int parking) {
        this.storename = storename;
        this.categoly = catrgoly;
        this.address = address;
        this.point_x = point_x;
        this.point_y = point_y;
        this.phone = phone;
        this.worktime = worktime;
        this.notworktime = notworktime;
        this.parking = parking;
    }

    public String getStorename() {
        return storename;
    }
    public String getCategoly(){
        return categoly;
    }
    public String getAddress() {
        return address;
    }
    public double getPoint_x() {
        return point_x;
    }
    public double getPoint_y() {
        return point_y;
    }
    public String getPhone() {
        return phone;
    }
    public String getWorktime() {
        return worktime;
    }
    public String getNotworktime() {
        return notworktime;
    }
    public int isParking() {
        return parking;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }
    public void setCategoly(String categoly){
        this.categoly = categoly;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPoint_x(double point_x) {
        this.point_x = point_x;
    }
    public void setPoint_y(double point_y) {
        this.point_y = point_y;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }
    public void setNotworktime(String notworktime) {
        this.notworktime = notworktime;
    }
    public void setParking(int parking) {
        this.parking = parking;
    }


}
