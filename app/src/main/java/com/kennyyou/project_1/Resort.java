package com.kennyyou.project_1;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by Kenny You on 3/21/2018.
 */

public class Resort {
    private String name;
    private String location;
    private String code;
    private int year;
    private double ppnpg;
    private double resortfee;
    private double taxrate;
    private String imageURL;


    public Resort(String name, String location, String code, int year, double ppnpg, double resortfee, double taxrate, String imageURL) {
        //this. calls constructor from same class
        this.name = name;
        this.location = location;
        this.code = code;
        this.year = year;
        this.ppnpg = ppnpg;
        this.resortfee = resortfee;
        this.taxrate = taxrate;
        this.imageURL = imageURL;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCode() {
        return code;
    }

    public int getYear() {
        return year;
    }

    public double getPpnpg() {
        return ppnpg;
    }

    public double getResortfee() {
        return resortfee;
    }

    public double getTaxrate() {
        return taxrate;
    }

    public String getImageURL() {
        return imageURL;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPpnpg(double ppnpg) {
        this.ppnpg = ppnpg;
    }

    public void setResortfee(double resortfee) {
        this.resortfee = resortfee;
    }

    public void setTaxrate(double taxrate) {
        this.taxrate = taxrate;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /*
    public static int getage(int newage)
    {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());

        return cal.get(Calendar.YEAR);
    }
    */

} //End