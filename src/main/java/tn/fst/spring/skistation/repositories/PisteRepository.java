package tn.fst.spring.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.fst.spring.skistation.entities.Color;
import tn.fst.spring.skistation.entities.Piste;

import java.util.List;

@Repository
public interface PisteRepository extends JpaRepository<Piste, Long> {
    
    List<Piste> findByNamePiste(String namePiste);
    
    List<Piste> findByColor(Color color);
    
    List<Piste> findByLengthGreaterThan(int minLength);
    
    List<Piste> findBySlopeLessThan(int maxSlope);
    
    List<Piste> findByColorAndLengthGreaterThan(Color color, int minLength);
    
    @Query("SELECT p FROM Piste p WHERE p.color = :color ORDER BY p.length DESC")
    List<Piste> findPistesByColorOrderByLength(@Param("color") Color color);
    
    @Query("SELECT p, COUNT(s) FROM Piste p LEFT JOIN p.skier s GROUP BY p")
    List<Object[]> findPistesWithSkierCount();
    
    @Query("SELECT p FROM Piste p WHERE p.slope BETWEEN :minSlope AND :maxSlope")
    List<Piste> findPistesBySlopeRange(@Param("minSlope") int minSlope, @Param("maxSlope") int maxSlope);
    
    @Query(value = "SELECT p.* FROM piste p " +
                  "JOIN skier_pistes sp ON p.num_piste = sp.pistes_num_piste " +
                  "GROUP BY p.num_piste " +
                  "HAVING COUNT(sp.skier_num_skier) >= :minSkiers", 
           nativeQuery = true)
    List<Piste> findPistesWithMinSkiers(@Param("minSkiers") int minSkiers);
}
