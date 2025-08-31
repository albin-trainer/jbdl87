package com.geeks.streams;
//Assume its legacy class
//Authour of class wants to sort or price L to H
public class Product implements Comparable<Product> {
private int prodId;
private String prodName;
private float price;
private float ratings;
public Product(int prodId, String prodName, float price, float ratings) {
	super();
	this.prodId = prodId;
	this.prodName = prodName;
	this.price = price;
	this.ratings = ratings;
}


public int getProdId() {
	return prodId;
}


public void setProdId(int prodId) {
	this.prodId = prodId;
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


public float getRatings() {
	return ratings;
}


public void setRatings(float ratings) {
	this.ratings = ratings;
}


@Override
public String toString() {
	return "Product [prodId=" + prodId + ", prodName=" + prodName + ", price=" + price + ", ratings=" + ratings + "]\n";
}
@Override
public int compareTo(Product p) {
	if (this.price<p.price)
		return -1;
	else
		return 1;
}
}
