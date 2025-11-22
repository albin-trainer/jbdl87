package com.example.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class MessageDto  implements Serializable {
private int userId;
private String email;
private String userName;
private String msg;

}
