package com.turkcell;

public class OOP {
 public static void main(String[] args) {
    Car car1 = new Car(); // new Car(); new -> yeni bir instance oluşturma keyword'ü, Car() ise Car sınıfının constructor'ı. Constructor, bir sınıftan nesne oluşturmak için kullanılan özel bir metottur. Car sınıfında constructor tanımlanmazsa, Java varsayılan bir constructor sağlar.

    car1.year = 2020; 
    car1.model = "X5"; 
    car1.brand = "BMW"; 
    //car1.price = 500.000; // set işlemi değer atama işlemidir. car1 nesnesinin price özelliğine 500.000 değerini atadık.

    car1.setPrice(500.000); //set 

    System.out.println(car1.getPrice()); // get işlemi değer okuma işlemidir. car1 nesnesinin price özelliğinin değerini ekrana yazdırır.
   

    //yeni bir araba nesnesi örneği(instance) üret
    car1.setBrand("BMV");
    car1.setModel("X5");
    car1.setYear(2020);
    car1.setPricePerDay(-500.0); 

    System.out.println(car1.getBrand());// get işlemi değer
    System.out.println(car1.getPricePerDay()); //private...
 }
}
