package tn.fst.spring.skistation.entities;
import jakarta.persistence.*;

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
