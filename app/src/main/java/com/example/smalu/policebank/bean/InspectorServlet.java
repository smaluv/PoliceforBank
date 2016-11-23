package com.example.smalu.policebank.bean;

/**
 * Created by Smalu on 2016/11/20.
 */

public class InspectorServlet {

    /**
     * place : 上海
     * date : 2015
     * hid_danger : 一切正常
     * method : 解决办法
     * checkman : 大白
     * check_unit : 小白
     * tel : 电话
     */

    private String place;
    private String date;
    private String hid_danger;
    private String method;
    private String checkman;
    private String check_unit;
    private String tel;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHid_danger() {
        return hid_danger;
    }

    public void setHid_danger(String hid_danger) {
        this.hid_danger = hid_danger;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCheckman() {
        return checkman;
    }

    public void setCheckman(String checkman) {
        this.checkman = checkman;
    }

    public String getCheck_unit() {
        return check_unit;
    }

    public void setCheck_unit(String check_unit) {
        this.check_unit = check_unit;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
