package com.turkcell;
//ARAÇ klasmanına giren tüm nesnelerin ortak özellikleri
public class Vehicle {
    private int year;
    private String brand;
    private String model;
    private double pricePerDay;
      public void setPricePerDay(double pricePerDay){
        // this->sınıfın kendisi
        if(pricePerDay<0){
            // System.out.println("Fiyat sıfırdan küçük olamaz");
            return; //metottan çıkış yapar.
        }
        this.pricePerDay=pricePerDay;
    }
         public double getPricePerDay() {
        return pricePerDay;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
      
}
