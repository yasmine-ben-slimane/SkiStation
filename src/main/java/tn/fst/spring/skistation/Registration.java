package tn.fst.spring.skistation;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numRegistration;
    private int numWeek;
    @ManyToOne
    private Skier skier;
    @ManyToOne
    private Course course;
}
