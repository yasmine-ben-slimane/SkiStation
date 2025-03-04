package tn.fst.spring.skistation.entities;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
public class Skier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkier;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String city;
    @OneToOne
    private Subscription subscription;
    @ManyToMany
    private Set<Piste> pistes;

    @OneToMany (mappedBy = "skier")
    private Set<Registration> registrations;
}
