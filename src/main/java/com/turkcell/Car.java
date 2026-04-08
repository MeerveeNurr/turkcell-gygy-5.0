package com.turkcell;
//Car isminde bir type oluşturmak.
public class Car 
{
    //GERÇEK HAYATTAKİ HER ŞEYİ DEĞİL,
    //PROGRAMDA İHTİYACIMIZ OLAN ŞEYLERİ MODELLEMEK İSTİYORUZ.
    public int year;
    public String model;
    public String brand;
    private double price;

     //Erişim beirteci->o alana kimlerin erişebileceğini belirleyen sistem.
    // Public->her yerden erişilebilir alan.
    //private->sadece tanımlandığı sınıfın içinden erişilebilir alan.
    //protected->aynı paketteki sınıflardan erişilebilir.Sadece tanımlanan sınıf ve o  sınıftan(türetilen) sınıflardan erişilebilir.

    //ENCAPSULATION(KAPSÜLLEME)
    //Read-only write-only

    // price değerini private yaptık, get ve set ile erişim sağlandı.ama doğrudan değil.
    public double getPrice() {
        return price;
    }
    public void setPrice(double price){
        //classın kendisi ->price
        if(price<0){
            System.out.println("Fiyat sıfırdan küçük olamaz.")
            return;
        }
        this.price=price;
    }


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
