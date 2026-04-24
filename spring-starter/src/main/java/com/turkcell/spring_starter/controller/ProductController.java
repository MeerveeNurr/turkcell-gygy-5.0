package com.turkcell.spring_starter.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.spring_starter.dto.ProductCreatedResponse;
import com.turkcell.spring_starter.dto.ProductForCreateDto;
import com.turkcell.spring_starter.model.Product;
import com.turkcell.spring_starter.service.ProductServiceImpl;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

@RestController //Bu class bir rest controller'dır.İçini uygulama başladığında tara,http->function tanımlarını al.
@RequestMapping("/api/product") //localhost:8080/api/product -> bu adrese gelen istekleri karşılar.->ProductController
//Altın kural:Veritabanı nesneleri requesttede response'da da kullanılamaz.(Kodsal olarak bir engel yok ama kurumsalda böyle bir kullanım seçeneği bulunmaz)Çünkü her bir isteğin ve cevabın ihtiyacı farklıdır.
public class ProductController {
    // Kullanıcı ne zaman /api/product alanına istek atarsa -> cevap bu fonksiyondan dönen cevap olsun
    ///api/product-> sayHi(); matchle
    // HTTP Method -> GET, POST, PUT, DELETE, PATCH...

    //BU YORUM SATIRINDAKİLER İLK ÖRNEKLER. DENEME YAP SENDE ÖĞRENMEK İÇİN.

   /*  @GetMapping("") //Controllerin uzantısı + getin uzantısı -> /api/product 
    public String sayHi(String name,int age){
        return "Hi " + name + " yaşınız " + age;
    }

    //Controllerin uzantısı + getin uzantısı -> /api/product/hello/{name}
    @GetMapping("/hello/{name}/{age}")
     public String sayHello(@PathVariable String name,@PathVariable int age){
        return " Hello " + name + " yaşınız "+ age;
     }
     @PostMapping
     public Product add(@RequestBody Product product){ //Json'dan ->Java objesine çevirir.
     //RequestBody -> İstek gövdesinden gelen veriyi Java objesine çevirir.
      // return product.getId() +" İd'li " +product.getName() +" İsimli Ürün Eklendi "; 
      return product;
     } */ 

      //5 Temel Crud işlemi -> Create, Read, Update, Delete, List temel olarak aşağıdaki şekilde
      //veritabanına geçene kadar in-memory olarak yapacağız.
      // post ve put için request body'den gelen veriyi java objesine çevirmek için @RequestBody kullanılır.Çünkü ürünün tüm bilgilerine ihtiyacımız var.
      //get ve dekete için id'ye göre işlem yapacağımız için @PathVariable kullanılır.Çünkü id'ye göre işlem yapacağız.sadece id'ye ihtiyacımız var.

      /*private List<Product> productList= new ArrayList<>();

      @GetMapping
      public List<Product> getAllProducts(){ //Bütün ürünleri listele
         return productList;
      }
      @GetMapping("{id}")
      public Product getProductById(@PathVariable int id){ //Id'ye göre ürün getir
      //stream -> ürün listesi üzerinde dolaşır, filter -> id'si eşit olan ürünü bulur, findFirst -> ilk bulduğu ürünü döndürür, orElse(null) -> eğer ürün bulunamazsa null döndürür.
      //Listeden id=product.getId() ise onu yoksa null dön.
         return productList.stream().filter(i->i.getId()==id).findFirst().orElse(null);
      }
      //Request-Response Pattern
      //Her istek-cevap kendine has bir modele sahip olmak zorunda
      //Birebir başka bir istek-cevap çiftiyle aynı içeriğe sahip olsa dahi!!
      @PostMapping 
      public ProductCreatedResponse createProduct(@RequestBody ProductForCreateDto productDto){ //Yeni ürün ekle

         // Sen dışardan ProductForCreateDto alıyosun 
        // ama veritabanı Product ile çalışıyor
         if(productDto.getPrice() < 0)
            throw new RuntimeException("Para 0'dan küçük olamaz.");

         Product product = new Product(); //Yeni bir ürün oluştur
         //Transfer -> MANUAL MAPPING -> Birbirine benzemeyen iki sınıf arasında veri transferi yapmak için manuel olarak kod yazmak.
         //Mapping -> Mapping (Eşleme), verinin bir nesneden (örneğin Entity) alınıp başka bir nesneye (DTO) aktarılması işlemidir.
         product.setName(productDto.getName());;
         product.setPrice(productDto.getPrice());
         product.setId(new Random().nextInt(999)); //Id'yi random olarak atıyoruz. Gerçek hayatta veritabanı otomatik atar.

         productList.add(product);
         //Domain Nesnesi ->Dto 
         
         ProductCreatedResponse response= new ProductCreatedResponse();//Yeni bir response oluştur
         response.setId(product.getId());
         response.setName((product.getName()));
         response.setPrice(product.getPrice());
         return response;
         // RequestBody ile alınan ProductForCreateDto nesnesi, manuel mapping ile Product entity'sine dönüştürülür,
         // ürün listeye eklenir ve sonuç ProductCreatedResponse DTO olarak client'a gönderilir.

         // Ben controller olarak iş kodu çalıştıramam, ama bunu yapmam gerekli..
         // İş kodunu çalıştıracak olan yapıya BAĞIMLIYIM.
        // Bağımlılık Enjeksiyonu -> Dependency Injection
      }
      @PutMapping
      public void updateProduct(@RequestBody Product product)  { //Var olan ürünü güncelle
         Product productToUpdate= productList.stream().filter(p->p.getId()== product.getId()).findFirst().orElseThrow(); //Güncellenecek ürünü bul. Eğer ürün bulunamazsa hata fırlatır.
         productToUpdate.setName(product.getName()); //Güncellenecek ürünün ismini güncelle
         productToUpdate.setPrice(product.getPrice()); //Güncellenecek ürünün fiyatını güncelle
         //Her güncelleme yaptığımızda ürün bilgilerini göndermek zorundayız.Aynı kalsa bile.
      }
      @DeleteMapping("{id}")
      public void deleteProduct(@PathVariable int id){ //Id'ye göre ürün sil
       
        //Hoca ile sonra bakılacak
      }*/ 
     //private final ProductServiceImpl productServiceImpl = new ProductServiceImpl();
    private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @PostMapping
    public ProductCreatedResponse create(@RequestBody @Valid ProductForCreateDto productDto) { //Valid yazınca ProductForCreateDto içindeki validasyonlar çalışır. Eğer validasyonlardan biri başarısız olursa, Spring otomatik olarak 400 Bad Request hatası döndürür ve hangi validasyonun başarısız olduğunu belirtir.
        return this.productServiceImpl.create(productDto);
    }


      
     }

