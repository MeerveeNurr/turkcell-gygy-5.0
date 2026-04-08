package com.turkcell;

public class Functions
{
    public static void main(String[] args) {

        //primitive tip: fonksiyon->fonksiyonun onu değiştirmesi orijinal değişkeni etkilemez.
        //String immutable olduğu için orijinal değer değişmez
        String name="Merve";
        sayWelcome(name); //Nur
        System.out.println(name); //çıktı? Merve, çünkü sayWelcome fonksiyonu name değişkeninin değerini değiştirdi ama main fonksiyonundaki name değişkeni etkilenmedi.

        //referans tip: fonksiyon->fonksiyonun onu değiştirmesi orijinal değişkeni etkiler.
        int[] numbers={10,20,30,4};
        sum(numbers);
        System.out.println(numbers[0]);
    }
    //pass by value : değer ile aktar.
    public static void sayWelcome(String name){ //camelCase yazım kuralına göre fonksiyon isimleri küçük harfle başlar ve sonraki kelimeler büyük harfle başlar.Fonksiyonlarda camelCase kullanılır.
        name="Nur"; // değişen şey değer.
        System.out.println("Hoşgeldin "+name);;
    }
    //pass by reference : referans ile aktar.
    public static void sum(int[] numbers){
        int total=0;
        for(int num:numbers){
            total+=num;
        }
        numbers[0]=100; //dizinin ilk elemanını değiştirelim. Diziler mutable (değiştirilebilir) olduğu için orijinal dizi değişir
        System.out.println("Toplam: "+total); 
    }
    // Pass by Value (Değer ile Geçiş) => Primitive tipler (int, double, boolean, char) ve String gibi immutable tipler için geçerlidir. 
    // Methodlara argüman olarak verilen değerlerin kopyası oluşturulur ve method içinde yapılan değişiklikler orijinal değeri etkilemez
    // Referans tipler (Arrays, Objects) için geçerli değildir. Methodlara argüman olarak verilen referansların kopyası oluşturulur ancak bu referanslar aynı nesneyi işaret eder. 
    // Bu nedenle method içinde yapılan değişiklikler orijinal nesneyi etkiler.

}
