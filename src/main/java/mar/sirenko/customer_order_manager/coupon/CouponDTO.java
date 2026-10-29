package mar.sirenko.customer_order_manager.coupon;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record CouponDTO(

        @Null
        Long id,

        @NotBlank
        String code,

        @NotNull
        @Min(value = 1)
        @Max(value = 99)
        Integer discount,

        @NotNull
        @Future
        LocalDate expirationDate
) {
}
