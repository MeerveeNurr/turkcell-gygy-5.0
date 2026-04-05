package com.turkcell;

public class Main {
    public static void main(String[] args) {
        System.out.println("Merhaba Turkcell,Java'ya hoşgeldiniz!");
        
        // Proglamlama Konseptleri
        //Scope{} Kavramı = Scope=Yaşam alanı, bir değişkenin tanımlandığı ve erişilebildiği bölge,Kapsama alanı
        // Scope içerisine kod yazmakla scope dışarısına kod yazmak aynı anlam değil.
         // iç scope dışardan bilgi alabilirken , dış scope içerden bilgi alamaz.

   // Değişkenler (Variables)
   // Kodun akışında değer tutan isimli veriler.
   System.out.println(10);
   int X=15; //Değişken tanımlandı. X ismine bir değer atandı.
   //Tanımlandıktan itibaren değişebilir,erişilebilir.
   System.out.println(X);
   X=20;
   System.out.println(X);

    }
   // System.out.println("Bu satır hata verecektir çünkü scope dışında kaldı.");
  
} //Main classının kapsama alanı(sınır)