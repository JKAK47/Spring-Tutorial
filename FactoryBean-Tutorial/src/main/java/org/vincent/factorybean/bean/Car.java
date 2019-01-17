package org.vincent.factorybean.bean;

/**
 * Package: org.vincent.factorybean.bean
 * Created by PengRong on 2019/1/17.
 * ProjectName: Spring-Tutorial
 */
public class Car {
    private String make;
    private int year ;

    public  Car(){

    }
    @Override
    public String toString() {
        return super.toString();
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
