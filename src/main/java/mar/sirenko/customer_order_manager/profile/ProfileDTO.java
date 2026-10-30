package mar.sirenko.customer_order_manager.profile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;

public record ProfileDTO(

        @Null(message = "ID профиля нельзя передавать в теле запроса")
        Long id,

        @NotBlank(message = "Адрес не должен быть пустым")
        String address,

        @NotNull
        @Pattern(
                regexp = "^\\+?\\d{7,15}$",
                message = "Телефон должен содержать только цифры (от 7 до 15 знаков) и может начинаться с '+'"
        )
        String phone
) {
}
