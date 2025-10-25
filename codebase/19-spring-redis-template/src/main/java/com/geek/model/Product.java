package com.geek.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable {
private int prodId;
private String prodName;

}
