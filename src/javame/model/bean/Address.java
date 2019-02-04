/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javame.model.bean;

/**
 *
 * @author Kuldeep
 */
class Address {
    
    private int houseNo; 
private String streetName; 
private String city; 
private int pinCode;


    public Address(int houseNo, String streetName, String city, int pinCode) {
        this.houseNo = houseNo;
        this.streetName = streetName;
        this.city = city;
        this.pinCode = pinCode;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    
}
