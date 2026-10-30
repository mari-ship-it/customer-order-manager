package mar.sirenko.customer_order_manager.profile;

import lombok.RequiredArgsConstructor;
import mar.sirenko.customer_order_manager.exception.AlreadyExistsException;
import mar.sirenko.customer_order_manager.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    @Transactional
    public ProfileDTO createProfile(ProfileDTO profileCreateDto) {

        if(profileRepository.existsByPhone(profileCreateDto.phone())) {
            throw new AlreadyExistsException.Profile();
        }
        Profile profile = profileMapper.toEntity(profileCreateDto);
        return profileMapper.toDto(profileRepository.save(profile));
    }

    @Transactional
    public ProfileDTO patchProfile(Long id, ProfileUpdateDTO profileUpdateDto) {

        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new NotFoundException.Profile(id));

        profileMapper.toPatchEntity(profileUpdateDto, profile);
        return profileMapper.toDto(profile);
    }

    @Transactional
    public void deleteProfile(Long id) {

        if (profileRepository.deleteProfileById(id) == 0) {
            throw new NotFoundException.Profile(id);
        }
    }

}
