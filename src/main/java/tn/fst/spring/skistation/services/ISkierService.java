package tn.fst.spring.skistation.services;

import tn.fst.spring.skistation.entities.Skier;
import tn.fst.spring.skistation.entities.Subscription;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ISkierService {
    
    Skier addSkier(Skier skier);
    
    List<Skier> getAllSkiers();
    
    Optional<Skier> getSkierById(Long id);
    
    Skier updateSkier(Skier skier);
    
    void deleteSkier(Long id);
    
    List<Skier> findByFirstName(String firstName);
    
    List<Skier> findByLastName(String lastName);
    
    List<Skier> findByCity(String city);
    
    List<Skier> findByDateOfBirthAfter(Date date);
    
    List<Skier> findBySubscription(Subscription subscription);
    
    List<Skier> findSkiersByPisteColor(String color);
    
    List<Skier> findSkiersByCourseSupportType(String support);
    
    Map<Skier, Long> getSkiersWithRegistrationCount();
    
    List<Skier> findSkiersWithMinPistesCount(int minPistes);
}