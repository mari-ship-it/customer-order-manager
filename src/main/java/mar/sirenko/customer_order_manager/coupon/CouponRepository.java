package mar.sirenko.customer_order_manager.coupon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    boolean existsByCode(String code);

    @Modifying
    @Query("DELETE FROM Coupon c WHERE c.id = :id")
    int deleteCouponById(Long id);
}
