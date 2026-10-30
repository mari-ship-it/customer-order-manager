package mar.sirenko.customer_order_manager.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleAlreadyExists(AlreadyExistsException e) {
        log.warn(e.getMessage());

        String errorCode = switch (e) {
            case AlreadyExistsException.Coupon c -> "COUPON_ALREADY_EXISTS";
            case AlreadyExistsException.Profile p -> "PROFILE_ALREADY_EXISTS";

        };

        return new ErrorResponse(errorCode, e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException e) {
        log.warn(e.getMessage());

        String errorCode = switch (e) {
            case NotFoundException.Coupon c -> "COUPON_NOT_FOUND";
            case NotFoundException.Profile p -> "PROFILE_NOT_FOUND";

        };

        return new ErrorResponse(errorCode, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidation(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = (error instanceof FieldError fieldError)
                    ? fieldError.getField()
                    : error.getObjectName();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        log.warn("Validation failed for object '{}'. Errors: {}",
                e.getBindingResult().getObjectName(), errors);

        return new ErrorResponse("VALIDATION_ERROR", "Ошибка валидации входящих данных", errors);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handlerAllUncaught(Exception e) {

        log.error("Unexpected error occurred on server", e);

        return new ErrorResponse("INTERNAL_SERVER_ERROR",
                "Произошла внутренняя ошибка сервера");
    }
}
