package mar.sirenko.customer_order_manager.exception;

public abstract sealed class NotFoundException extends RuntimeException
        permits NotFoundException.Coupon, NotFoundException.Profile {

    protected NotFoundException(String message) {
        super(message);
    }

    public static final class Coupon extends NotFoundException {

        public Coupon(Long id) {
            super("Не найден купон с id: " + id); }
    }

    public static final class Profile extends NotFoundException {
        public Profile(Long id) {
            super("Не найден профиль с id: " + id);
        }
    }

}
