package mar.sirenko.customer_order_manager.exception;

public abstract sealed class AlreadyExistsException extends RuntimeException
        permits AlreadyExistsException.Coupon, AlreadyExistsException.Profile {

    protected AlreadyExistsException(String message) {
        super(message);
    }

    public static final class Coupon extends AlreadyExistsException {

        public Coupon() {
            super("Купон уже существует");
        }
    }

    public static final class Profile extends AlreadyExistsException {

        public Profile() {
            super("Профиль уже существует");
        }
    }
}
