package com.turkcell;
//İmplemenst ediyorsan imzaları aynen uygulamak zorundasın.Parametre ekleyip-çıkaramazsın metot adı,dönüş tipi vs değiştiremezsin.
public class PgCarRepository implements CarRepository {
    
    public void add(Car car){ //En az 300 yerde kullandın add metodunu. Şimdi bu metodu değiştirmek istediğinde 300 yerde tek tek değişiklik yapman gerekecek. Bu da hata riskini artırır.
       System.out.println("Araba nesnesi postresql'e eklendi");

    }

}
