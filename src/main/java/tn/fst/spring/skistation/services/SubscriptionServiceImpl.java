package tn.fst.spring.skistation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.fst.spring.skistation.entities.Subscription;
import tn.fst.spring.skistation.entities.TypeSubscription;
import tn.fst.spring.skistation.repositories.SubscriptionRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService {
    
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    
    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }
    
    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }
    
    @Override
    public Optional<Subscription> getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id);
    }
    
    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }
    
    @Override
    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }
    
    @Override
    public List<Subscription> findByTypeSub(TypeSubscription typeSub) {
        return subscriptionRepository.findByTypeSub(typeSub);
    }
    
    @Override
    public List<Subscription> findByStartDateAfter(Date startDate) {
        return subscriptionRepository.findByStartDateAfter(startDate);
    }
    
    @Override
    public List<Subscription> findByEndDateBefore(Date endDate) {
        return subscriptionRepository.findByEndDateBefore(endDate);
    }
    
    @Override
    public List<Subscription> findByPriceLessThan(float price) {
        return subscriptionRepository.findByPriceLessThan(price);
    }
    
    @Override
    public List<Subscription> findByPriceGreaterThan(float price) {
        return subscriptionRepository.findByPriceGreaterThan(price);
    }
    
    @Override
    public List<Subscription> findActiveSubscriptions(Date currentDate) {
        return subscriptionRepository.findActiveSubscriptions(currentDate);
    }
    
    @Override
    public List<Subscription> findSubscriptionsExpiringBetween(Date startDate, Date endDate) {
        return subscriptionRepository.findSubscriptionsExpiringBetween(startDate, endDate);
    }
    
    @Override
    public Map<TypeSubscription, Long> getSubscriptionCountByType() {
        List<Object[]> results = subscriptionRepository.findSubscriptionCountByType();
        Map<TypeSubscription, Long> typeCounts = new HashMap<>();
        
        for (Object[] result : results) {
            TypeSubscription type = (TypeSubscription) result[0];
            Long count = (Long) result[1];
            typeCounts.put(type, count);
        }
        
        return typeCounts;
    }
    
    @Override
    public List<Subscription> findSubscriptionsLongerThan(int days) {
        return subscriptionRepository.findSubscriptionsLongerThan(days);
    }
}