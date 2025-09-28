package com.geek.entity;
import jakarta.persistence.Embeddable;
@Embeddable
public class Address {
private String placeName;
private String doorNo;
private int pinCode;
public Address() {
	// TODO Auto-generated constructor stub
}


public Address(String placeName, String doorNo, int pinCode) {
	super();
	this.placeName = placeName;
	this.doorNo = doorNo;
	this.pinCode = pinCode;
}


public String getPlaceName() {
	return placeName;
}
public void setPlaceName(String placeName) {
	this.placeName = placeName;
}
public String getDoorNo() {
	return doorNo;
}
public void setDoorNo(String doorNo) {
	this.doorNo = doorNo;
}
public int getPinCode() {
	return pinCode;
}
public void setPinCode(int pinCode) {
	this.pinCode = pinCode;
}


@Override
public String toString() {
	return "Address [placeName=" + placeName + ", doorNo=" + doorNo + ", pinCode=" + pinCode + "]";
}

}
