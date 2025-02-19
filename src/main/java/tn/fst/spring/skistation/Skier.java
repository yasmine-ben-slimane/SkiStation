package tn.fst.spring.skistation;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


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
    private List<Piste> pistes;
}
