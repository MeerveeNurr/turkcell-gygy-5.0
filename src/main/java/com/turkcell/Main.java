package com.turkcell;

import java.util.Arrays;

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
          //Değişken Tİpleri= int, double, char, boolean, String
          String name="Merve";
          String age="25"; //char tek tırnaktır,metinsel veri çift tırnaktır.Bazı diller ikisi de olacak şekilde kullanır.Ama javada bu özgürlük yok.
          boolean isStudent=true;
          char grade='A';
           String name3=name.concat("abc");
           System.out.println(name3);
          // String immutable(değiştirilemez) bir yapıya sahiptir.
          //concat() gibi metotlar yeni bir string oluşturur, mevcut stringi değiştirmez.

          
          //Diziler(Arrays)
          String[] names={"Merve","Ahmet","Ayşe"};
          System.out.println(names); //Arrayi direkt konsola yazdırmak demek o ararayin referansını yazdırmak demektir.
          System.out.println(names[0]); 
          //index= o elemanın bulunduğu konum,Dizilerde index 0'dan başlar.

          //Primitive(İlkel) Tipler = int, double, char, boolean
          int a=0;
          int b=a;
          a=10;
          System.out.println(a);
          System.out.println(b); //b'nin değeri a'nın ilk değerine eşittir,sonradan yapılan değişiklikler b'yi etkilemez.Çünkü integer ilkel bir tip.

          //Referans Tipler = String, Arrays, Objects
          int[] c ={0,1,2,3};
          int[] d = c;
          d[3]=30;
          System.out.println(c[3]);
          System.out.println(d[3]);

          System.out.println("**************");
          System.out.println(a==b); //a ve b eşit mi? false
          System.out.println(c==d); //c ve d eşit mi? true çünkü c ve d aynı referansı gösteriyor.

          int[] x = {4,5,6,7};
          int[] y = {4,5,6,7};
          System.out.println(x==y); //x ve y eşit mi? false çünkü x ve y farklı referansları gösteriyor, içlerindeki değerler aynı olsa da referansları farklı olduğu için eşit değiller.(Birbirlerine eşitleme yapmadık yukarıdaki gibi)

          System.out.println(Arrays.equals(x, y)); //x ve y'nin içindeki değerler eşit mi? true çünkü Arrays.equals() metodu dizilerin içindeki değerleri karşılaştırır.

          String s1="Merhaba";
          String s2="Merhaba";
          System.out.println(s1==s2); //true çünkü string referans bi tip.

          //String Pool=Java'da stringler için özel bir bellek alanı vardır, aynı içeriğe sahip stringler bu havuzda tek bir kopya olarak saklanır ve referansları paylaşır. Bu nedenle s1 ve s2 aynı referansı gösterir ve s1==s2 true döner.


          //String Pool= Aynı metinlerin bir havuzda toplanıp performans için birebir olanları aynı referansa ata.


          //Yine de daha güvenli bir karşılaştırma için equals() kullanılır.
          System.out.println(s1.equals(s2));

          String s3="Turkcell";
          String s4=s3.intern();
          System.out.println(s3==s4); 
          // intern() metodu s3'ün değerini string pool'a ekler ve oradaki referansı döndürür.

          String str3="Turkcell";
          String str4= new String("Turkcell");
          System.out.println(str3==str4); // false farklı referanslar new o classtan yeni bir tür üretir.
          //instance oluşturur,farklı referans

          System.out.println("Merhaba"+" "  + "Dünya");
         //Operatörler
          System.out.println(10*20);
          System.out.println(10/3);
          System.out.println(1==1); 
          System.out.println(1!=1);
          System.out.println(5>10);

          //Döngüler
          //X işlemini birden fazla kez çalıştırmak.
          //iteration=tekrarlama,yineleme
          //Değişken,koşul,her iterasyon sonrası işlem(artış,azalış...)
          for(int i=0;i<5;i++){
            System.out.println("For çalıştı.");
            System.out.println(i);
          }

          String[] students={"Merve","Ahmet","Ayşe"};
          for(int i=0;i<students.length;i++){ //students.length dizinin uzunluğunu verir.ve bu sayede dizinin sonuna gelene kadar döngü devam eder.
            System.out.println(students[i]);
    } 
    //alternatif syntax olarak for-each döngüsü de kullanılabilir.
    for(String student:students){ //for-each döngüsü, dizinin her bir elemanını sırayla student değişkenine atar ve döngü boyunca kullanır.
        System.out.println(student);  
    }
        //iterasyon->koşul
       // while(true){ //sonsuz döngü
         //   System.out.println("Sonsuz döngü...");
  //  }
    int whileDongusu= 0;
    while(whileDongusu<5){
        System.out.println("While çalıştı.");
        whileDongusu++;
    }

    // Karar Blokları & Döngüler
// Belirli 1+ kapsamdaki kod bloklarını belirli koşullara göre ateşlemek.
// Karar bloğu minimum 1 maksimum n adet karara göre farklı kodlar çalıştırabilir.
// Koşul: true-false

/* if (1==1){
    // burası her zaman çalışır çünkü koşul true olacak buna dead kod denir.
} */ 
//Her koşul yalnızca maksimum bir scope çalıştırır.
     int age2=18;
     // Eğer if döngüsü >= 18 olsaydı kodlar yukarıdan aşağıya çalıştığı için ilk if bloğu çalışır ve diğer bloklara bakılmazdı.Çıktı Yetki verildi olurdu.Yani hata vermezdi.
     if(age2>18){
      System.out.println("Yetki verildi.");
     }
     // eğer else if yerine if olsaydı iki farklı if bloğu olduğu içiin çıktı hem yetki verildi hem de yaşınız tam 18,ay kontolü yapılıyor olurdu.
     else if(age2==18){
        System.out.println("Yaşınız tam 18,ay kontolü yapılıyor...");
     }
     else {
    System.out.println("Yetki verilmedi.");
}

     String username="Merve";
     if(username.equals("Nur")){ //Equals() metodu stringlerin içeriğini karşılaştırır.
        System.out.println("Hoşgeldin Nur");
     } //Karar blokları illaki bir scopu çalıştırma zorunluluğu barındırmaz.
    
     calculateGrade(85, "Merve");
     calculateGrade(70, "Ahmet");
     calculateGrade(50, "Ayşe");
     calculateGrade(30, "Fatma");
    }//Main classının kapsama alanı(sınır)  
    // System.out.println("Bu satır hata verecektir çünkü scope dışında kaldı.");

    //Methodlar=> Belirli bir işi yapan kod bloklarıdır. Methodlar sayesinde kod tekrarından kurtuluruz, kodlarımız daha okunabilir ve bakımı kolay olur. Methodlar parametre alabilir ve geriye değer döndürebilirler.

//erişim belirteci-static veya boş dönüş tipi(void->boş)-method ismi -(parametreler) -{}
//Bir parametre tanımlıysa null bile olsa göndermek zorundasın.
 public static void calculateGrade(int grade, String name){ //required parametre(zorunlu)
    if(grade>=90){
        System.out.println("Notunuz: A"+" "+name);
    } else if(grade>=80){
        System.out.println("Notunuz: B"+" "+name);
    } else if(grade>=70){
        System.out.println("Notunuz: C"+" "+name);
    } else if(grade>=60){
        System.out.println("Notunuz: D"+" "+name);
    } else {
        System.out.println("Notunuz: F"+" "+name);
    }
}
    //Name gönderilemezse öğrenci varsayılan değer alsın.
    //Method Overloading = Aynı isimde farklı parametre sayısına sahip metodlar oluşturma

    public static void calculateGrade(int grade) {
        calculateGrade(grade, "Öğrenci");
    }
}
