package mar.sirenko.customer_order_manager.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(
        String errorCode,
        String message,
        Map<String, String> errors
) {
    public ErrorResponse(String errorCode, String message) {
        this(errorCode, message, null);
    }
}
