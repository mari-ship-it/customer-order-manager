package mar.sirenko.customer_order_manager.profile;

import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;


public record ProfileUpdateDTO(

        @Null(message = "ID профиля нельзя передавать в теле запроса")
        Long id,

        @Pattern(
                regexp = "^(?!\\s*$).+",
                message = "Адрес не должен быть пустым")
        String address,

        @Pattern(
                regexp = "^\\+?\\d{7,15}$",
                message = "Телефон должен содержать только цифры (от 7 до 15 знаков) и может начинаться с '+'"
        )
        String phone
) {
}
