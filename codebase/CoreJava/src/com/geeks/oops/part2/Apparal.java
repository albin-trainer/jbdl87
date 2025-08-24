package com.geeks.oops.part2;

public class Apparal extends Product {
 private String size;
 private String fabric;
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public String getFabric() {
	return fabric;
}
public void setFabric(String fabric) {
	this.fabric = fabric;
}
 
 public void print() {
	 System.out.println("Size : "+size);
	 System.out.println("Fabric "+fabric);
 }
}
