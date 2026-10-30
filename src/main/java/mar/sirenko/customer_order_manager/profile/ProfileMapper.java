package mar.sirenko.customer_order_manager.profile;

import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProfileMapper {

//    @Mapping(target = "client", ignore = true)
    ProfileDTO toDto(Profile profile);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client", ignore = true)
    Profile toEntity(ProfileDTO profileDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toPatchEntity(ProfileUpdateDTO profileUpdateDto, @MappingTarget Profile profile);
}
