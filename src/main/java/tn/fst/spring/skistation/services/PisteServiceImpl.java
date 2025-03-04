package tn.fst.spring.skistation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.fst.spring.skistation.entities.Color;
import tn.fst.spring.skistation.entities.Piste;
import tn.fst.spring.skistation.repositories.PisteRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PisteServiceImpl implements IPisteService {
    
    @Autowired
    private PisteRepository pisteRepository;
    
    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }
    
    @Override
    public List<Piste> getAllPistes() {
        return pisteRepository.findAll();
    }
    
    @Override
    public Optional<Piste> getPisteById(Long id) {
        return pisteRepository.findById(id);
    }
    
    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }
    
    @Override
    public void deletePiste(Long id) {
        pisteRepository.deleteById(id);
    }
    
    @Override
    public List<Piste> findByNamePiste(String namePiste) {
        return pisteRepository.findByNamePiste(namePiste);
    }
    
    @Override
    public List<Piste> findByColor(Color color) {
        return pisteRepository.findByColor(color);
    }
    
    @Override
    public List<Piste> findByLengthGreaterThan(int minLength) {
        return pisteRepository.findByLengthGreaterThan(minLength);
    }
    
    @Override
    public List<Piste> findBySlopeLessThan(int maxSlope) {
        return pisteRepository.findBySlopeLessThan(maxSlope);
    }
    
    @Override
    public List<Piste> findByColorAndLengthGreaterThan(Color color, int minLength) {
        return pisteRepository.findByColorAndLengthGreaterThan(color, minLength);
    }
    
    @Override
    public List<Piste> findPistesByColorOrderByLength(Color color) {
        return pisteRepository.findPistesByColorOrderByLength(color);
    }
    
    @Override
    public Map<Piste, Long> getPistesWithSkierCount() {
        List<Object[]> results = pisteRepository.findPistesWithSkierCount();
        Map<Piste, Long> pistesWithCount = new HashMap<>();
        
        for (Object[] result : results) {
            Piste piste = (Piste) result[0];
            Long count = (Long) result[1];
            pistesWithCount.put(piste, count);
        }
        
        return pistesWithCount;
    }
    
    @Override
    public List<Piste> findPistesBySlopeRange(int minSlope, int maxSlope) {
        return pisteRepository.findPistesBySlopeRange(minSlope, maxSlope);
    }
    
    @Override
    public List<Piste> findPistesWithMinSkiers(int minSkiers) {
        return pisteRepository.findPistesWithMinSkiers(minSkiers);
    }
}