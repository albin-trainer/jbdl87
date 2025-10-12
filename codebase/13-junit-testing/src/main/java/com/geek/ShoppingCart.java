package com.geek;

import java.util.HashMap;

public class ShoppingCart {
private HashMap<String, Float> items= new HashMap<>();
public void addItem(String itemName, float price) {
	if(price<=0)
		throw new IllegalArgumentException("Price must be greater than zero");
	items.put(itemName, price);
}
public double totalPrice() {
	  double totalPrice= 
			  items.values().
			  stream().
			  mapToDouble(p->p).sum();
	return totalPrice;
}
public int itemCount() {
	return items.size();
}

public float getPrice (String itemName) {
	if(items.containsKey(itemName))
		return items.get(itemName);
	throw new IllegalArgumentException("item not found");
		
}
public void clearCart() {
	items.clear();
}

public HashMap<String, Float> getCart(){
	return items;
}
}
