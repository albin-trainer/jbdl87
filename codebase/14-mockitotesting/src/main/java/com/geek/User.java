package com.geek;

public class User {
private int id;
private String name;
private boolean premium;

public User() {
	// TODO Auto-generated constructor stub
}

public User(int id, String name, boolean premium) {
	super();
	this.id = id;
	this.name = name;
	this.premium = premium;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public boolean isPremium() {
	return premium;
}

public void setPremium(boolean premium) {
	this.premium = premium;
}

}
