package mar.sirenko.customer_order_manager;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "profiles")
@Entity
@Getter
@Setter
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;
}
