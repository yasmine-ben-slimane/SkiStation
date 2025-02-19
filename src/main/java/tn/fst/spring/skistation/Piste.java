package tn.fst.spring.skistation;

import jakarta.persistence.*;

import java.util.List;


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
}
