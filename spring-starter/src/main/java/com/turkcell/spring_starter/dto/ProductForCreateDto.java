package com.turkcell.spring_starter.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

public class ProductForCreateDto {
  @NotBlank // Boş olamaz validasyonu 
  @Length(min=2) //
  @Pattern(regexp = "^[^0-9]+$") //regex -> Regular Expression demek. Pattern ise regex'in Java'daki karşılığı. regex ile ürün isminin rakam içermemesi gerektiğini belirttik.

  private String name;

  @PositiveOrZero // Negatif olamaz validasyonu
  private Double price;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Double getPrice() {
    return price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }
}
