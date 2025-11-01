package com.example.model;

public class Product {
private int productId;
private String prodName;
private float price;
private String portNo;
public Product() {
	// TODO Auto-generated constructor stub
}
public Product(int productId, String prodName, float price, String portNo) {
	super();
	this.productId = productId;
	this.prodName = prodName;
	this.price = price;
	this.portNo = portNo;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProdName() {
	return prodName;
}
public void setProdName(String prodName) {
	this.prodName = prodName;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getPortNo() {
	return portNo;
}
public void setPortNo(String portNo) {
	this.portNo = portNo;
}


}
