package com.turkcell.spring_starter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Bu class bir rest controller'dır.İçini uygulama başladığında tara,http->function tanımlarını al.
@RequestMapping("/api/product") //localhost:8080/api/product -> bu adrese gelen istekleri karşılar.->ProductController

public class ProductController {
    // Kullanıcı ne zaman /api/product alanına istek atarsa -> cevap bu fonksiyondan dönen cevap olsun
    ///api/product-> sayHi(); matchle
    // HTTP Method -> GET, POST, PUT, DELETE, PATCH...
    @GetMapping("") //Controllerin uzantıı + getin uzantısı -> /api/product 
    public String sayHi(String name,int age){
        return "Hi" +name+ "yaşınız" + age;
    }
    //Controllerin uzantısı + getin uzantısı -> /api/product/hello/{name}
    @GetMapping("/hello/{name}/{age}")
     public String sayHello(@PathVariable String name,@PathVariable int age){
        return " Hello " + name + " yaşınız "+ age;
     }

}
