package tn.fst.spring.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.fst.spring.skistation.entities.Subscription;
import tn.fst.spring.skistation.entities.TypeSubscription;

import java.util.Date;
import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    
    List<Subscription> findByTypeSub(TypeSubscription typeSub);
    
    List<Subscription> findByStartDateAfter(Date startDate);
    
    List<Subscription> findByEndDateBefore(Date endDate);
    
    List<Subscription> findByPriceLessThan(float price);
    
    List<Subscription> findByPriceGreaterThan(float price);
    
    @Query("SELECT s FROM Subscription s WHERE s.startDate <= :currentDate AND s.endDate >= :currentDate")
    List<Subscription> findActiveSubscriptions(@Param("currentDate") Date currentDate);
    
    @Query("SELECT s FROM Subscription s WHERE s.endDate BETWEEN :startDate AND :endDate")
    List<Subscription> findSubscriptionsExpiringBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
    
    @Query("SELECT s.typeSub, COUNT(s) FROM Subscription s GROUP BY s.typeSub ORDER BY COUNT(s) DESC")
    List<Object[]> findSubscriptionCountByType();
    
    @Query(value = "SELECT * FROM subscription s WHERE DATEDIFF(s.end_date, s.start_date) > :days", nativeQuery = true)
    List<Subscription> findSubscriptionsLongerThan(@Param("days") int days);
}