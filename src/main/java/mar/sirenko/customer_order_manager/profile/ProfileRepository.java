package mar.sirenko.customer_order_manager.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    boolean existsByPhone(String phone);

    @Modifying
    @Query("DELETE FROM Profile p WHERE p.id = :id")
    int deleteProfileById(Long id);
}
