package com.turkcell;
//Sisteminde araba veritabanı olarak 
//çalışmak isteyen her nesne
//bu interface'i implement etmek zorunda.
public interface CarRepository {
    //Bir CarRepository'si nasıl davranmalı? Net kalıp ve kurallar ile tanımla.
    //Soyut->içi boş yalnızca imzası olan methodar tanımlamak.

     void add(Car car);

     }

//Böylece PostreSqlCarRepository, MySQLCarRepository gibi farklı veritabanları için farklı implementasyonlar yapabiliriz. 
//Bu sayede kodumuz daha esnek ve sürdürülebilir olur. Yeni bir veritabanı eklemek istediğimizde sadece yeni bir sınıf oluşturup CarRepository arayüzünü implement etmemiz yeterli olacaktır. Mevcut kodda herhangi bir değişiklik yapmamıza gerek kalmaz. Bu da kodun bakımını kolaylaştırır ve hata riskini azaltır.