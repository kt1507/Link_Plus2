package com.example.linkmain;

public class ListViewItem {

    //private Drawable iconDrawable;
    private String nameStr;
    private String phoneStr;
    private String timeStr;
    private String categoryStr;

    public void setStoreName(String store_name){
        nameStr = store_name;
    }
    public void setPhone(String phone){
        phoneStr = phone;
    }
    public void setTime(String time){
        timeStr = time;
    }
    public void setCategoryStr(String categoryStr) {
        this.categoryStr = categoryStr;
    }
    /*public void setIcon(Drawable icon){
        iconDrawable = icon;
    }*/

    /*public Drawable getIcon(){
        return this.iconDrawable;
    }*/

    public String getStoreName(){ return this.nameStr; }
    public String getPhone() { return this.phoneStr; }
    public String getTime() { return this.timeStr; }
    public String getCategoryStr() { return categoryStr; }


}
