package mar.sirenko.customer_order_manager.profile;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@Slf4j
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileDTO createProfile(@RequestBody @Valid ProfileDTO profileCreateDto) {

        log.info("Called createProfile");
        return profileService.createProfile(profileCreateDto);
    }

    @PatchMapping("/{id}")
    public ProfileDTO patchProfile(@PathVariable("id") Long id, @RequestBody @Valid ProfileUpdateDTO profileUpdateDto) {

        log.info("Called patchProfile id={}", id);
        return profileService.patchProfile(id, profileUpdateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfile(@PathVariable("id") Long id) {

        log.info("Called deleteProfile id={}", id);
        profileService.deleteProfile(id);
    }
}
