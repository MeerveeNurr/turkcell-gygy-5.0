package com.turkcell.spring_starter.repository;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.turkcell.spring_starter.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID>
{
    // 1. JPQL -> Jpa+SQL
    // 2. SQL -> Saf SQL
    @Query("Select c from Category c Where c.name LIKE %:query%") // SQL değil JPQL
    //@Query(value = "Select * from categories c where c.name ilike %:query%", nativeQuery = true) // Düz SQL
    Set<Category> search(String query);
    // 3. Named Queries
    Set<Category> findByNameLike(String name);

}

        /*@Query Notasyonu
Spring Data JPA'nın otomatik oluşturduğu metodlar (findByName gibi) bazen karmaşık sorgular için yetersiz kalır. @Query kullanarak SQL'e çok benzeyen ama doğrudan tablolarla değil, Java sınıflarınla (Entity) konuşan özel sorgular yazabilirsin.*/

/*%:query: Bu, aranan kelimenin sonunda ne olduğuna bakar. Yani kelime :query ile bitmelidir.

Örnek: Eğer parametren "telefon" ise; "akıllı telefon", "ev telefonu" sonuçlarını getirir, ama "telefon kılıfı" sonucunu getirmez.

:query (Named Parameter): Bu bir değişkendir. Metodun içindeki @Param("query") String query parametresiyle eşleşir. */
