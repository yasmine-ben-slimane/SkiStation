package tn.fst.spring.skistation;
import jakarta.persistence.*;
import java.util.Date;


@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSub;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private float price;
    @Enumerated(EnumType.STRING)
    private TypeSubscription typeSub;


}
