package com.geeks;
//just a blue print (not real)
public class Product {
 private  int productId;
 private String prodName;
 private float price;
 
  //cannot run this class directly ....
  void discount(int offerCode) {
	  if(offerCode==10001  && price>=10000 ) {
		  price=price-1000;
		  System.out.println("Congratulations !!!! u have saved 1000 rs");
	  }
	  else
		  System.out.println();
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
  
  
}
