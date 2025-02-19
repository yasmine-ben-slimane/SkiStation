package tn.fst.spring.skistation;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numInstructor;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date dateOfHire;
    //@OneToMany
    //private List<Course> courses;

}

