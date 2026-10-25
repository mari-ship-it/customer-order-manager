package mar.sirenko.customer_order_manager;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "clients")
@Entity
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name =  "email", unique = true)
    private String email;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    @ManyToMany(mappedBy = "clients")
    private Set<Coupon> coupons = new HashSet<>();

    public void addProfile(Profile profile) {
        this.profile = profile;
        profile.setClient(this);
    }

    public void addOrder(Order order) {
        this.orders.add(order);
        order.setClient(this);
    }
}
