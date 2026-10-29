package mar.sirenko.customer_order_manager.coupon;

import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CouponMapper {

    CouponDTO toDto(Coupon coupon);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "clients", ignore = true)
    Coupon toEntity(CouponDTO couponDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "clients", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchEntityFromDto(CouponUpdateDTO couponDTO, @MappingTarget Coupon coupon);
}
