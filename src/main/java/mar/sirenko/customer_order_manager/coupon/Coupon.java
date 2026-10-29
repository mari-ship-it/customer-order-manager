package mar.sirenko.customer_order_manager.coupon;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mar.sirenko.customer_order_manager.client.Client;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Table(name = "coupons")
@Entity
@Getter
@Setter
@ToString(exclude = "clients")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "discount", nullable = false)
    private Integer discount;

    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @ManyToMany
    @JoinTable(
            name = "client_coupons",
            joinColumns = @JoinColumn(name = "coupon_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private Set<Client> clients = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return code != null && code.equals(coupon.code);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
