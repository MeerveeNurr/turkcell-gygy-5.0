package com.turkcell.spring_starter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.turkcell.spring_starter.dto.CreateCategoryRequest;
import com.turkcell.spring_starter.dto.CreatedCategoryResponse;
import com.turkcell.spring_starter.dto.ListCategoryResponse;
import com.turkcell.spring_starter.entity.Category;
import com.turkcell.spring_starter.repository.CategoryRepository;

import jakarta.persistence.EntityManager;

@Service  
public class CategoryServiceImpl {
    private final CategoryRepository categoryRepository;
    private final EntityManager entityManager;
   //  private final ProductServiceImpl productServiceImpl; //servisler arasında sonsuz döngü oluşur, birinin üretilmesi lazım kidiğeri de onun üretilmesine baplı çalışsın.

    public CategoryServiceImpl(CategoryRepository categoryRepository,EntityManager entityManager) {
        this.categoryRepository = categoryRepository;
        this.entityManager = entityManager;
    }

     public Category getById(UUID id)
    {
        return categoryRepository.findById(id).orElse(null);
    }
 
    public CreatedCategoryResponse create(CreateCategoryRequest createCategoryRequest) {
        // Veritabanında insert-update çalıştır.
        // entity id'e sahipse update
        // entity id'si null ise insert

        Category category = new Category();
        category.setName(createCategoryRequest.getName());

        category = this.categoryRepository.save(category); // ekledikten sonraki halini al

        CreatedCategoryResponse response = new CreatedCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());

        return response;
    } 

    public List<ListCategoryResponse> getAll(){
        List<Category> categories = this.categoryRepository.findAll();
        List<ListCategoryResponse> responseList = new ArrayList<>();

        for(Category category:categories){
            ListCategoryResponse response = new ListCategoryResponse();
            response.setId(category.getId());
            response.setName(category.getName());
            responseList.add(response);
        }
        return responseList;
    }

      public List<ListCategoryResponse> search(String query){

        //Set<Category> categories = categoryRepository.findByNameLike("%" + query + "%");

        //Strin Concantination -> KESİNLİKLE YASAK. Çünkü performans sorunlarına yol açar. Java'da String'ler immutable (değiştirilemez) olduğu için her birleştirme işlemi yeni bir String oluşturur ve bu da bellek kullanımını artırır.

         //  //String jpql = "Select c from Category c Where c.name LIKE '%" + query + "%'";

        String jpql= "Select c from Category c  Where c.name LIKE :query"; // JPQL sorgusu, doğrudan tablo adlarıyla değil, Entity sınıf adlarıyla çalışır. Bu nedenle "Category" ifadesi, veritabanındaki tablo adı değil, Java'daki Entity sınıfının adıdır. JPQL, SQL'e benzer bir sözdizimine sahip olsa da, Entity'ler üzerinden sorgulama yapar ve bu da veritabanı bağımsızlığı sağlar.


        //Burada kullanılan Set veri yapısı, benzersiz (unique) elemanları saklamak için kullanılır. Yani, aynı kategori adıyla birden fazla kategori varsa, sadece bir tanesi Set içinde saklanır. Bu, arama sonuçlarında tekrar eden kategorilerin tekrarını önler.

        //findByNameLike metodu, CategoryRepository arayüzünde tanımlanmış bir sorgu yöntemidir. Bu yöntem, kategori adında belirli bir deseni içeren kategorileri bulmak için kullanılır. Örneğin, "%query%" ifadesi, kategori adında "query" kelimesini içeren tüm kategorileri bulur. Bu, SQL'deki LIKE operatörüne benzer şekilde çalışır ve arama sonuçlarını filtrelemek için kullanılır.
        List<Category> categories = entityManager
        .createQuery(jpql, Category.class) 
        .setParameter("query", "%" + query + "%")
        .getResultList();

        List<ListCategoryResponse> responseList = new ArrayList<>();

        for(Category category:categories){
            ListCategoryResponse response = new ListCategoryResponse();
            response.setId(category.getId());
            response.setName(category.getName());
            responseList.add(response);
        }
        return responseList;
      }
      
     //ödev kısmı
   /* public ListCategoryResponse getById(UUID id){
        Category category = this.categoryRepository.findById(id).orElseThrow();

        ListCategoryResponse response = new ListCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());

        return response;
    } */ 

    public CreatedCategoryResponse update(UUID id, CreateCategoryRequest request){
        Category category = this.categoryRepository.findById(id).orElseThrow();
        category.setName(request.getName());

        category = this.categoryRepository.save(category);

        CreatedCategoryResponse response = new CreatedCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());

        return response;
    }

    public void delete(UUID id){
        Category category = this.categoryRepository.findById(id).orElseThrow();
        this.categoryRepository.delete(category);
    }
}