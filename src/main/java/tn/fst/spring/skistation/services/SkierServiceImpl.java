package tn.fst.spring.skistation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.fst.spring.skistation.entities.Skier;
import tn.fst.spring.skistation.entities.Subscription;
import tn.fst.spring.skistation.repositories.SkierRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SkierServiceImpl implements ISkierService {
    
    @Autowired
    private SkierRepository skierRepository;
    
    @Override
    public Skier addSkier(Skier skier) {
        return skierRepository.save(skier);
    }
    
    @Override
    public List<Skier> getAllSkiers() {
        return skierRepository.findAll();
    }
    
    @Override
    public Optional<Skier> getSkierById(Long id) {
        return skierRepository.findById(id);
    }
    
    @Override
    public Skier updateSkier(Skier skier) {
        return skierRepository.save(skier);
    }
    
    @Override
    public void deleteSkier(Long id) {
        skierRepository.deleteById(id);
    }
    
    @Override
    public List<Skier> findByFirstName(String firstName) {
        return skierRepository.findByFirstName(firstName);
    }
    
    @Override
    public List<Skier> findByLastName(String lastName) {
        return skierRepository.findByLastName(lastName);
    }
    
    @Override
    public List<Skier> findByCity(String city) {
        return skierRepository.findByCity(city);
    }
    
    @Override
    public List<Skier> findByDateOfBirthAfter(Date date) {
        return skierRepository.findByDateOfBirthAfter(date);
    }
    
    @Override
    public List<Skier> findBySubscription(Subscription subscription) {
        return skierRepository.findBySubscription(subscription);
    }
    
    @Override
    public List<Skier> findSkiersByPisteColor(String color) {
        return skierRepository.findSkiersByPisteColor(color);
    }
    
    @Override
    public List<Skier> findSkiersByCourseSupportType(String support) {
        return skierRepository.findSkiersByCourseSupportType(support);
    }
    
    @Override
    public Map<Skier, Long> getSkiersWithRegistrationCount() {
        List<Object[]> results = skierRepository.findSkiersWithRegistrationCount();
        Map<Skier, Long> skiersWithCount = new HashMap<>();
        
        for (Object[] result : results) {
            Skier skier = (Skier) result[0];
            Long count = (Long) result[1];
            skiersWithCount.put(skier, count);
        }
        
        return skiersWithCount;
    }
    
    @Override
    public List<Skier> findSkiersWithMinPistesCount(int minPistes) {
        return skierRepository.findSkiersWithMinPistesCount(minPistes);
    }
}