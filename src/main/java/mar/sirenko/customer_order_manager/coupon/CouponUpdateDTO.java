package mar.sirenko.customer_order_manager.coupon;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CouponUpdateDTO(
        @Null
        Long id,

        String code,

        @Min(value = 1)
        @Max(value = 99)
        Integer discount,

        @Future
        LocalDate expirationDate
) {
}
