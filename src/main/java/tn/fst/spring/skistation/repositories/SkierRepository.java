package tn.fst.spring.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.fst.spring.skistation.entities.Skier;
import tn.fst.spring.skistation.entities.Subscription;

import java.util.Date;
import java.util.List;

@Repository
public interface SkierRepository extends JpaRepository<Skier, Long> {
    
    List<Skier> findByFirstName(String firstName);
    
    List<Skier> findByLastName(String lastName);
    
    List<Skier> findByCity(String city);
    
    List<Skier> findByDateOfBirthAfter(Date date);
    
    List<Skier> findBySubscription(Subscription subscription);
    
    @Query("SELECT s FROM Skier s JOIN s.pistes p WHERE p.color = :color")
    List<Skier> findSkiersByPisteColor(@Param("color") String color);
    
    @Query("SELECT s FROM Skier s JOIN s.registrations r JOIN r.course c WHERE c.support = :support")
    List<Skier> findSkiersByCourseSupportType(@Param("support") String support);
    
    @Query("SELECT s, COUNT(r) FROM Skier s JOIN s.registrations r GROUP BY s ORDER BY COUNT(r) DESC")
    List<Object[]> findSkiersWithRegistrationCount();
    
    @Query(value = "SELECT s.* FROM skier s JOIN skier_pistes sp ON s.num_skier = sp.skier_num_skier " +
                   "GROUP BY s.num_skier HAVING COUNT(DISTINCT sp.pistes_num_piste) >= :minPistes", 
           nativeQuery = true)
    List<Skier> findSkiersWithMinPistesCount(@Param("minPistes") int minPistes);
}