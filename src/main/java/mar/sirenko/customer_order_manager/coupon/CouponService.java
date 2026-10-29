package mar.sirenko.customer_order_manager.coupon;

import lombok.RequiredArgsConstructor;
import mar.sirenko.customer_order_manager.exception.AlreadyExistsException;
import mar.sirenko.customer_order_manager.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;
    private final CouponMapper couponMapper;

    @Transactional
    public CouponDTO createCoupon(CouponDTO createCoupon) {

        if (couponRepository.existsByCode(createCoupon.code())) {
            throw new AlreadyExistsException.Coupon();
        }
        Coupon coupon = couponMapper.toEntity(createCoupon);
        return couponMapper.toDto(couponRepository.save(coupon));
    }

    @Transactional
    public CouponDTO updateCoupon(Long id, CouponUpdateDTO updateCoupon) {

        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new NotFoundException.Coupon(id));

        couponMapper.patchEntityFromDto(updateCoupon, coupon);
        return couponMapper.toDto(coupon);

    }

    @Transactional
    public void deleteCoupon(Long id) {

        if (couponRepository.deleteCouponById(id) == 0) {
            throw new NotFoundException.Coupon(id);
        }
    }

}
