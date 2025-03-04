package tn.fst.spring.skistation.services;

import tn.fst.spring.skistation.entities.Color;
import tn.fst.spring.skistation.entities.Piste;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IPisteService {
    
    Piste addPiste(Piste piste);
    List<Piste> getAllPistes();
    Optional<Piste> getPisteById(Long id);
    Piste updatePiste(Piste piste);
    void deletePiste(Long id);
    
    List<Piste> findByNamePiste(String namePiste);
    List<Piste> findByColor(Color color);
    List<Piste> findByLengthGreaterThan(int minLength);
    List<Piste> findBySlopeLessThan(int maxSlope);
    List<Piste> findByColorAndLengthGreaterThan(Color color, int minLength);
    List<Piste> findPistesByColorOrderByLength(Color color);
    Map<Piste, Long> getPistesWithSkierCount();
    List<Piste> findPistesBySlopeRange(int minSlope, int maxSlope);
    List<Piste> findPistesWithMinSkiers(int minSkiers);
}