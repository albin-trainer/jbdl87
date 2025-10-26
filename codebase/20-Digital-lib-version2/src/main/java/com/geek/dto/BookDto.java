package com.geek.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geek.entity.Genre;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;
@Data
public class BookDto {
private int bookId;
@NotBlank(message = "Please enter book name")
private String bookName;
private String title;
@Min(value = 0,message = "please enter valid cost")
private float cost;
@PastOrPresent(message = "publishedDate should be past or present")
//format -- 10-jan-25 or 10/01/25
@JsonFormat(pattern = "dd-MM-yyyy")
private LocalDate publishedDate;
@Positive(message = "minimum value should be 1")
private int stock;
@Enumerated(EnumType.STRING)
private Genre genre;
private int authourId;
}
