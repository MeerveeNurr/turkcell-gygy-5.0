package com.turkcell;

public class OOP {
 public static void main(String[] args) {
    Car car1 = new Car(true, "BMV"); // new Car();
    // yeni bir araba nesnesi örneği(instance) üret.
    
    //  new -> yeni bir instance oluşturma keyword'ü, Car() ise Car sınıfının constructor'ı. Constructor, bir sınıftan nesne oluşturmak için kullanılan özel bir metottur. Car sınıfında constructor tanımlanmazsa, Java varsayılan bir constructor sağlar.

    car1.setYear(2020); 
    car1.setModel("X5"); 
    car1.setBrand("BMW");  
    car1.setPricePerDay(-500.000);
    //car1.price = 500.000; // set işlemi değer atama işlemidir. car1 nesnesinin price özelliğine 500.000 değerini atadık.
    car1.setPricePerDay(500.000); //set 
    String[] specs= {"Cam Tavan","Bebek koltuğu","Otonom Sürüş"};
    car1.setSpecs(specs);
    String[] x=car1.getSpecs();
    x[0]="abc";
    System.out.println(car1.getSpecs()[0]); //Cam Tavan
    System.out.println(car1.getBrand());// get işlemi değer
    System.out.println(car1.getPricePerDay()); //private olduğu için erişilemez.
    // get işlemi değer okuma işlemidir. car1 nesnesinin price özelliğinin değerini ekrana yazdırır.

    Bike bike1=new Bike();
    Car car2= new Car(true,"Mercedes");
    System.out.println(car2.getBrand());   

    // Gerçek hayatta depo dediğimiz şey sanalda veritabanıdır.
    //Kurumsal hayatta yazdığımız bir kodun başarılı olabilmesi o kodun teknoloji değişikliğine ne kadar ayak uydurabildiğine bağlı.
 }
}
