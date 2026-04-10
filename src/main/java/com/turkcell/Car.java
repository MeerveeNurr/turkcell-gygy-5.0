package com.turkcell;
//Car isminde bir type oluşturmak.
//Vehicle'ın tüm özelliklerini yükle,üstüne
//buraya yazacağım özellikleri de ekle.=>CAR
public class Car extends Vehicle
{
//Car isminde bir type oluşturmak

    //GERÇEK HAYATTAKİ HER ŞEYİ DEĞİL,
    //PROGRAMDA İHTİYACIMIZ OLAN ŞEYLERİ MODELLEMEK İSTİYORUZ.
    private String[] specs;
    private boolean hasSunroof;

     //Erişim beirteci->o alana kimlerin erişebileceğini belirleyen sistem.
    // Public->her yerden erişilebilir alan.
    //private->sadece tanımlandığı sınıfın içinden erişilebilir alan.
    //protected->aynı paketteki sınıflardan erişilebilir.Sadece tanımlanan sınıf ve o  sınıftan(türetilen) sınıflardan erişilebilir.

     // bir alanı public olarak açarsak,o alana atanacak değeri kontrol edemeyiz.Ama direkt erişimi kapatıp bir metot üzeriden erişim sağlarsak(set), o metot içerisinde o alana atanacak değeri kontrol edebiliriz

     //***************************************************** */

    //ENCAPSULATION(KAPSÜLLEME) :bir sınıfın içindeki verilerin ve o verilere erişim sağlayan metotların tek bir çatı altında toplanmasıdır. Verilerin doğrudan erişimini engelleyip, sadece belirli metotlar aracılığıyla erişim sağlanması prensibine dayanır. 
    
    //Encapsulation->Dışarıdan manipülasyone(değişime)kapalı
    public String[] getSpecs() {
        return specs.clone();
    }

    public void setSpecs(String[] specs) {
        this.specs = specs.clone(); // clone->bir nesnenin kopyasını oluşturmak için kullanılan bir yöntemdir. Bu, orijinal nesnenin değiştirilmesini önler ve güvenli bir şekilde veri paylaşımı sağlar.Yani dışardan girilen veriye izin vermedi.

        //Değerlerini al,referansını alma
        //clone referans tipler için kullanılır.
    }
     // Değerlerini al, referansı alma.
    public boolean isHasSunroof() {
        return hasSunroof;
    }
    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }
    //Read-only write-only
    //ör get metodunu kaldırırsam bu alanı okuyamam ama yazma işlemi yapabilirim. set için de tam tersi.
      //setter methodu->değer atama işlemi yapar.
     // price değerini private yaptık, get ve set ile erişim sağlandı.ama doğrudan değil.
     //getter methodu->değer okuma işlemi yapar.Değeri geri dönme işlemi

     // kısayol : sağ tıkla->source action->generate getter and setter yapmak istediğin alanları seç.

   //Constructor->yapıcı metot -- Yazmasanız bile bir tane var.
   //Ama yazarsak Auto olanı override etmiş (ezmiş ) oluruz.

   //subclass- superclass
   //subclass ->kalıtımı alan extended eden classdır.
   //superclass->kalıtım alınan ortak özelliklerin olduğu classtır.
   public Car (boolean hasSunroof,String brand){ //Dönüş metotu belirtmeden
    // 1. SIRADA OLMALI: Önce üst sınıf (Vehicle) hazır hale gelir Java 21 ile alakalı
     super(); //Vehicle classının constructor'ını da çağırır. Kalıtım aldığım classın constructor'ını çağırmak için kullanılı
    System.out.println("Car constructor'u çalıştı");
    this.hasSunroof=hasSunroof;
    super.setBrand(brand);

      //Super->Vehicle classını (Kalıtım aldığım classı)
   }
   public Car(){ 
   }
   //Constructor'un en çok kullanım amacı; nesne direkt üretilirken özelliklerini set etmek sonrasında , her satırda tek tek çağırma ihtiyacı yerine bir seferde set edebilmek.


}
