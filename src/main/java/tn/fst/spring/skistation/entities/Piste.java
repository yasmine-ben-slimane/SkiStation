package tn.fst.spring.skistation.entities;

import jakarta.persistence.*;

import java.util.Set;


@Entity
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;
    private String namePiste;
    @Enumerated(EnumType.STRING)
    private Color color;
    private int length;
    private int slope;
    @ManyToMany(mappedBy = "pistes")
    private Set<Skier> skier;
}
