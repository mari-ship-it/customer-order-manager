package mar.sirenko.customer_order_manager.coupon;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/coupon")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CouponDTO createCoupon(
            @RequestBody @Valid CouponDTO createCoupon
    ) {
        log.info("Called createCoupon");
        return couponService.createCoupon(createCoupon);
    }

    @PatchMapping("/{id}")
    CouponDTO updateCoupon(
            @PathVariable("id") Long id,
            @RequestBody @Valid CouponUpdateDTO updateCoupon
    ) {
        log.info("Called couponToUpdate: id={}", id);
        return couponService.updateCoupon(id, updateCoupon);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCoupon(
            @PathVariable("id") Long id
    ) {
        log.info("Called deleteCoupon");
        couponService.deleteCoupon(id);
    }
}
