package com.example.linkmain;

public class StoreClass {
    private String storename;
    private String category;
    private String address;
    private double point_x;
    private double point_y;
    private String phone;
    private String worktime;
    private String notworktime;
    private int parking;
    private int store_picture;

    public StoreClass(String storename, String catrgory, String address, double point_x, double point_y, String phone, String worktime, String notworktime, int parking, int store_picture) {
        this.storename = storename;
        this.category = catrgory;
        this.address = address;
        this.point_x = point_x;
        this.point_y = point_y;
        this.phone = phone;
        this.worktime = worktime;
        this.notworktime = notworktime;
        this.parking = parking;
        this.store_picture = store_picture;
    }

    public String getStorename() {
        return storename;
    }
    public String getCategory(){
        return category;
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
    public int getParking() {
        return parking;
    }
    public int getStore_picture() {
        return store_picture;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }
    public void setCategory(String category){
        this.category = category;
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
    public void setStore_picture(int store_picture) {
        this.store_picture = store_picture;
    }
}
