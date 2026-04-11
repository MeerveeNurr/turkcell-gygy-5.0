package com.turkcell.spring_starter.model;

//Entity,Domain,Model->Veritabanı nesnesinin koddaki bir temsili.
public class Product {
    public int id;
    public String name;
    public Double price;
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
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    
//DTO : Data Transfer Object -> Veritabanı nesnesinin request ve response'ta kullanılacak hali.
//Entity ile X(controller,service) arası veri transferi için oluşturulan sınıfardır.
//Dto kullanma amacı:Veritabanındaki her alanı dış dünyaya (kullanıcıya) göstermek istemezsin.
}
