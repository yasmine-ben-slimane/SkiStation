package tn.fst.spring.skistation.services;

import tn.fst.spring.skistation.entities.Subscription;
import tn.fst.spring.skistation.entities.TypeSubscription;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ISubscriptionService {
    
    Subscription addSubscription(Subscription subscription);
    
    List<Subscription> getAllSubscriptions();
    
    Optional<Subscription> getSubscriptionById(Long id);
    
    Subscription updateSubscription(Subscription subscription);
    
    void deleteSubscription(Long id);
    
    List<Subscription> findByTypeSub(TypeSubscription typeSub);
    
    List<Subscription> findByStartDateAfter(Date startDate);
    
    List<Subscription> findByEndDateBefore(Date endDate);
    
    List<Subscription> findByPriceLessThan(float price);
    
    List<Subscription> findByPriceGreaterThan(float price);
    
    List<Subscription> findActiveSubscriptions(Date currentDate);
    
    List<Subscription> findSubscriptionsExpiringBetween(Date startDate, Date endDate);
    
    Map<TypeSubscription, Long> getSubscriptionCountByType();
    
    List<Subscription> findSubscriptionsLongerThan(int days);
}