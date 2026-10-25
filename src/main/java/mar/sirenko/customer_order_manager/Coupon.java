package mar.sirenko.customer_order_manager;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "coupons")
@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", unique = true)
    private Long code;

    @Column(name = "discount")
    private int discount;

    @ManyToMany
    @JoinTable(
            name = "client_coupons",
            joinColumns = @JoinColumn(name = "coupon_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private Set<Client> clients = new HashSet<>();
}
