package com.turkcell;
//Car isminde bir type oluşturmak.
public class Car 
{
    //GERÇEK HAYATTAKİ HER ŞEYİ DEĞİL,
    //PROGRAMDA İHTİYACIMIZ OLAN ŞEYLERİ MODELLEMEK İSTİYORUZ.
    public String model;
    public String brand;
    public int year;
    // Public->her noktadan erişilebilir alan.

    //ENCAPSULATION(KAPSÜLLEME)
    //Read-only write-only
    private Double pricePerDay;
// get set metodunu hocanın videoyla kıyasl
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    //setter method
    //getter method
}
